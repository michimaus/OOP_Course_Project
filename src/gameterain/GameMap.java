package gameterain;

import angelseffects.AngelEffects;
import angels.StandardAngel;
import observer.AngelMyObserver;
import observer.PlayerMyObserver;
import spells.Spells;
import players.StandardPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Map is a singletone.
 * Cells of the map contains the terain deffinition and referances to the players that are found
 * at the specific coordinates.
 */

public final class GameMap {
    private static GameMap instance = null;

    private Spells heroSpells;
    private AngelEffects angelEffects;
    private char[][] mapTerain;
    private StandardPlayer[][] firstPlayerOnPos;
    private StandardPlayer[][] secondPlayerOnPos;
    private List<StandardPlayer>[][] deadPlayers;
    private AngelMyObserver angelObservers;
    private PlayerMyObserver playerObservers;

    private GameMap() {
        heroSpells = new Spells();
        angelEffects = new AngelEffects();
        mapTerain = null;
        firstPlayerOnPos = null;
        secondPlayerOnPos = null;
        deadPlayers = null;
    }

    public void initPlayers(final List<StandardPlayer> players) {

        for (StandardPlayer p : players) {
            putPlayerAtPosition(p.getPosR(), p.getPosC(), p);
        }
    }

    public void setPlayerObservers(final PlayerMyObserver obs) {
        playerObservers = obs;
    }

    public void setAngelObservers(final AngelMyObserver obs) {
        angelObservers = obs;
    }

    public AngelMyObserver getAngelObservers() {
        return angelObservers;
    }

    public PlayerMyObserver getPlayerObservers() {
        return playerObservers;
    }

    public void initLand(final int n, final int m, final char[][] mapTerainGet) {
        this.mapTerain = mapTerainGet;
        deadPlayers = new List[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                deadPlayers[i][j] = new ArrayList<>();
            }
        }
        firstPlayerOnPos = new StandardPlayer[n][m];
        secondPlayerOnPos = new StandardPlayer[n][m];
    }

    public void putPlayerAtPosition(final int posX, final int posY, final StandardPlayer player) {
        if (firstPlayerOnPos[posX][posY] == null) {
            firstPlayerOnPos[posX][posY] = player;
        } else {
            secondPlayerOnPos[posX][posY] = player;
        }
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    public void updatePlayerPosition(final int oldX, final int oldY,
                                     final int newX, final int newY, final StandardPlayer player) {

        if (firstPlayerOnPos[oldX][oldY] == player) {
            firstPlayerOnPos[oldX][oldY] = secondPlayerOnPos[oldX][oldY];
            secondPlayerOnPos[oldX][oldY] = null;
        }
        if (secondPlayerOnPos[oldX][oldY] == player) {
            secondPlayerOnPos[oldX][oldY] = null;
        }

//        if (secondPlayerOnPos[oldX][oldY] != player) {
//            firstPlayerOnPos[oldX][oldY] = secondPlayerOnPos[oldX][oldY];
//        }
//        secondPlayerOnPos[oldX][oldY] = null;
        putPlayerAtPosition(newX, newY, player);
    }

    /**
     * Checks tha case for a fight (when two players are on the same sport)
     * Implements the logic of the interaction.
     * @param posR = row
     * @param posC = column
     */

    public void timeForFight(final int posR, final int posC) {
        if (secondPlayerOnPos[posR][posC] != null) {
            StandardPlayer p1 = firstPlayerOnPos[posR][posC];
            StandardPlayer p2 = secondPlayerOnPos[posR][posC];

            System.out.println(p1.getType() + p1.getCurrentHp());
            System.out.println(p2.getType() + p2.getCurrentHp());

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
                playerObservers.updatePlayerKillingOther(p1, p2);
                playerObservers.updatePlayerKillingOther(p2, p1);
                return;
            }

            if (p2.getKillXp(p1)) {
                playerObservers.updatePlayerKillingOther(p2, p1);
                p2.checkLevelUp();
            }

            if (p1.getKillXp(p2)) {
                playerObservers.updatePlayerKillingOther(p1, p2);
                p1.checkLevelUp();
            }
        }
    }

    public char getPieceOfLand(final int posR, final int posC) {
        return mapTerain[posR][posC];
    }

    /**
     * Forgets the player position.
     * @param p = player that is dead, no longer on the map.
     */

    public void takeOut(final StandardPlayer p) {
        if (p == firstPlayerOnPos[p.getPosR()][p.getPosC()]) {
            firstPlayerOnPos[p.getPosR()][p.getPosC()]
                    = secondPlayerOnPos[p.getPosR()][p.getPosC()];
        }
        secondPlayerOnPos[p.getPosR()][p.getPosC()] = null;
        deadPlayers[p.getPosR()][p.getPosC()].add(p);
    }

    public void spawnAngels(final List<StandardAngel> angelsThisRound) {
        for (StandardAngel angel : angelsThisRound) {
            angelObservers.updateAngelSpawn(angel);
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
                    angelObservers.updatePlayerInteraction(angel, p1);
                    angel.applyEffect(angelEffects, p1);
                }
            }
            if (p2 != null) {
                if (angel.canInteract(p2)) {
                    angelObservers.updatePlayerInteraction(angel, p2);
                    angel.applyEffect(angelEffects, p2);
                }
            }
            boolean okRespawn = false;
            for (StandardPlayer deadPlayer : deadPlayers[angel.getPosR()][angel.getPosC()]) {
                if (angel.canInteract(deadPlayer)) {
                    okRespawn = true;
                    angelObservers.updatePlayerInteraction(angel, deadPlayer);
                    angel.applyEffect(angelEffects, deadPlayer);
                } else {
                    break;
                }
            }
            if (okRespawn) {
                deadPlayers[angel.getPosR()][angel.getPosC()] = new ArrayList<>();
            }
        }
    }
}
