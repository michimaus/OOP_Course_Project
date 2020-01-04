package gameterain;

import angelseffects.AngelEffects;
import angels.StandardAngel;
import common.Constants;
import observer.GreatMage;
import players.PlayerComparator;
import spells.Spells;
import players.StandardPlayer;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Map is a singleton.
 * Cells of the map contains the terain definition and references to the players that are found
 * at the specific coordinates.
 * As part of the game state visitor for the spells and for the effects of the angels have
 * their instances in the calss of the map, as part of the game state.
 * In addition to that, the map is the min observable, because everything is happening on it.
 */

public final class GameMap {
    private static GameMap instance = null;

    private Spells heroSpells;
    private AngelEffects angelEffects;
    private char[][] mapTerain;
    private StandardPlayer[][] firstPlayerOnPos;
    private StandardPlayer[][] secondPlayerOnPos;
    private PriorityQueue<StandardPlayer>[][] deadPlayers;
    private GreatMage observer;

    private GameMap() {
        heroSpells = new Spells();
        angelEffects = new AngelEffects();
        mapTerain = null;
        firstPlayerOnPos = null;
        secondPlayerOnPos = null;
        deadPlayers = null;
    }

    /**
     * Map cells retain referances to the players that can be found
     * at that position.
     */

    public void initPlayers(final List<StandardPlayer> players) {
        for (StandardPlayer p : players) {
            putPlayerAtPosition(p.getPosR(), p.getPosC(), p);
        }
    }

    public void setObserver(final GreatMage obs) {
        observer = obs;
    }

    public GreatMage getObserver() {
        return observer;
    }

    public void initLand(final int n, final int m, final char[][] mapTerainGet) {
        this.mapTerain = mapTerainGet;
        deadPlayers = new PriorityQueue[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                deadPlayers[i][j] = new PriorityQueue<>(Constants.MAX_DEAD_PLAYERS,
                        new PlayerComparator());
            }
        }
        firstPlayerOnPos = new StandardPlayer[n][m];
        secondPlayerOnPos = new StandardPlayer[n][m];
    }

    public void putPlayerAtPosition(final int posR, final int posC, final StandardPlayer player) {
        if (posR < 0 || posC < 0 || mapTerain.length <= posR || mapTerain[0].length <= posC) {
            return;
        }
        if (firstPlayerOnPos[posR][posC] == null) {
            firstPlayerOnPos[posR][posC] = player;
        } else {
            secondPlayerOnPos[posR][posC] = player;
        }
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    /**
     * Player gets moved from his old to his new position, by deleting the old reference
     * and adding a new one at the other cell.
     * It is also checked for the players not the leave the bounds of the map,
     * although this should not happen ... but it does.
     */

    public void updatePlayerPosition(final int oldR, final int oldC,
                                     final int newR, final int newC, final StandardPlayer player) {
        if (oldR < 0 || oldC < 0 || mapTerain.length <= oldR || mapTerain[0].length <= oldC) {
            putPlayerAtPosition(newR, newC, player);
            return;
        }
        if (firstPlayerOnPos[oldR][oldC] == player) {
            firstPlayerOnPos[oldR][oldC] = secondPlayerOnPos[oldR][oldC];
            secondPlayerOnPos[oldR][oldC] = null;
        }
        if (secondPlayerOnPos[oldR][oldC] == player) {
            secondPlayerOnPos[oldR][oldC] = null;
        }

        putPlayerAtPosition(newR, newC, player);
    }

    /**
     * Checks tha case for a fight (when two players are on the same sport)
     * Implements the logic of the interaction.
     * @param posR = row
     * @param posC = column
     */

    public void timeForFight(final int posR, final int posC) {
        if (posR < 0 || posC < 0 || mapTerain.length <= posR || mapTerain[0].length <= posC) {
            return;
        }

        if (secondPlayerOnPos[posR][posC] != null) {
            StandardPlayer p1 = firstPlayerOnPos[posR][posC];
            StandardPlayer p2 = secondPlayerOnPos[posR][posC];

            if (p1.getCurrentHp() <= 0 || p2.getCurrentHp() <= 0) {
                return;
            }

            p1.setIncomingDamage(0);
            p2.setIncomingDamage(0);

            p1.calculateStrike(heroSpells, p2, mapTerain[posR][posC]);
            p1.setHasAttacked(true);
            p2.calculateStrike(heroSpells, p1, mapTerain[posR][posC]);
            p2.setHasAttacked(true);

            p1.takeDamage();
            p2.takeDamage();

            if (p1.getCurrentHp() <= 0 && p2.getCurrentHp() <= 0) {
                observer.updatePlayerKillingOther(p1, p2);
                observer.updatePlayerKillingOther(p2, p1);
                return;
            }

            if (p2.getKillXp(p1)) {
                observer.updatePlayerKillingOther(p2, p1);
                p2.checkLevelUp();
            }

            if (p1.getKillXp(p2)) {
                observer.updatePlayerKillingOther(p1, p2);
                p1.checkLevelUp();
            }
        }
    }

    public char getPieceOfLand(final int posR, final int posC) {
        return mapTerain[posR][posC];
    }

    /**
     * Player gets to be remembered that he died at his last known position.
     * It gets placed in the que of the dead players, that can be found at each cell.
     * @param p = dead player.
     */

    public void takeOut(final StandardPlayer p) {
        if (p == firstPlayerOnPos[p.getPosR()][p.getPosC()]) {
            firstPlayerOnPos[p.getPosR()][p.getPosC()]
                    = secondPlayerOnPos[p.getPosR()][p.getPosC()];
        }
        secondPlayerOnPos[p.getPosR()][p.getPosC()] = null;
        deadPlayers[p.getPosR()][p.getPosC()].add(p);
    }

    /**
     * Angels are spawned at their positions and the observer gets notified.
     * In the case they have to interact with heroes, the visitor will be called and the specific
     * effect will be applied.
     * @param angelsThisRound = list of angels that are spawned this round
     */

    public void spawnAngels(final List<StandardAngel> angelsThisRound) {
        for (StandardAngel angel : angelsThisRound) {
            observer.updateAngelSpawn(angel);
            StandardPlayer p1;
            StandardPlayer p2;
            if (firstPlayerOnPos[angel.getPosR()][angel.getPosC()] != null
                    && secondPlayerOnPos[angel.getPosR()][angel.getPosC()] != null) {
                if (firstPlayerOnPos[angel.getPosR()][angel.getPosC()].getId()
                        < secondPlayerOnPos[angel.getPosR()][angel.getPosC()].getId()) {
                    p1 = firstPlayerOnPos[angel.getPosR()][angel.getPosC()];
                    p2 = secondPlayerOnPos[angel.getPosR()][angel.getPosC()];
                } else {
                    p2 = firstPlayerOnPos[angel.getPosR()][angel.getPosC()];
                    p1 = secondPlayerOnPos[angel.getPosR()][angel.getPosC()];
                }
            } else {
                p1 = firstPlayerOnPos[angel.getPosR()][angel.getPosC()];
                p2 = secondPlayerOnPos[angel.getPosR()][angel.getPosC()];
            }

            if (p1 != null) {
                if (angel.canInteract(p1)) {
                    observer.updatePlayerInteraction(angel, p1);
                    angel.applyEffect(angelEffects, p1);
                }
            }
            if (p2 != null) {
                if (angel.canInteract(p2)) {
                    observer.updatePlayerInteraction(angel, p2);
                    angel.applyEffect(angelEffects, p2);
                }
            }

            while (!deadPlayers[angel.getPosR()][angel.getPosC()].isEmpty()) {
                StandardPlayer deadPlayer = deadPlayers[angel.getPosR()][angel.getPosC()].peek();
                if (angel.canInteract(deadPlayer)) {
                    deadPlayers[angel.getPosR()][angel.getPosC()].poll();
                    observer.updatePlayerInteraction(angel, deadPlayer);
                    angel.applyEffect(angelEffects, deadPlayer);
                } else {
                    break;
                }
            }
        }
    }
}
