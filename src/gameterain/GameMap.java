package gameterain;

import players.Spells;
import players.StandardPlayer;

import java.util.List;

/**
 * Map is a singletone.
 * Cells of the map contains the terain deffinition and referances to the players that are found
 * at the specific coordinates.
 */

public final class GameMap {
    private static GameMap instance = null;
    private Spells heroSpells;
    private char[][] mapTerain;
    private StandardPlayer[][] firstPlayerOnPos;
    private StandardPlayer[][] secondPlayerOnPos;

    private GameMap() {
        heroSpells = new Spells();
        mapTerain = null;
        firstPlayerOnPos = null;
        secondPlayerOnPos = null;
    }

    public void initMap(final int n, final int m,
                        final char[][] mapTerainGet, final List<StandardPlayer> players) {
        this.mapTerain = mapTerainGet;

        firstPlayerOnPos = new StandardPlayer[n][m];
        secondPlayerOnPos = new StandardPlayer[n][m];

        for (StandardPlayer p : players) {

            putPlayerAtPosition(p.getPosR(), p.getPosC(), p);
        }
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

        if (secondPlayerOnPos[oldX][oldY] != player) {
            firstPlayerOnPos[oldX][oldY] = secondPlayerOnPos[oldX][oldY];
        }
        secondPlayerOnPos[oldX][oldY] = null;
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

            p1.setIncomingDamage(0);
            p2.setIncomingDamage(0);

            p1.calculateStrike(heroSpells, p2, mapTerain[posR][posC]);
            p1.setHasAtacked(true);
            p2.calculateStrike(heroSpells, p1, mapTerain[posR][posC]);
            p2.setHasAtacked(true);

            p1.takeDamage();
            p2.takeDamage();

            if (p1.getCurrentHp() <= 0 && p2.getCurrentHp() <= 0) {
                return;
            }

            if (p2.getKillXp(p1)) {
                p2.checkLevelUp();
            }

            if (p1.getKillXp(p2)) {
                p1.checkLevelUp();
            }
        }
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
    }
}
