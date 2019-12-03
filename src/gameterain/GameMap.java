package gameterain;

import players.Spells;
import players.StandardPlayer;

import java.util.List;

public class GameMap {
    private static GameMap instance = null;
    Spells heroSpells;
    private char [][] mapTerain;
    private StandardPlayer [][] firstPlayerOnPos;
    private StandardPlayer [][] secondPlayerOnPos;

    public char[][] getMapTerain() {
        return mapTerain;
    }

    public StandardPlayer[][] getFirstPlayerOnPos() {
        return firstPlayerOnPos;
    }

    public StandardPlayer[][] getSecondPlayerOnPos() {
        return secondPlayerOnPos;
    }

    public char getTerainType(final int posR, final int posC) {
        return mapTerain[posR][posC];
    }

    public Spells getHeroSpells() {
        return heroSpells;
    }

    private GameMap () {
        heroSpells = new Spells();
        mapTerain = null;
        firstPlayerOnPos = null;
        secondPlayerOnPos = null;
    }

    public void initMap(final int n, final int m,
                        final char [][] mapTerain, final List<StandardPlayer> players) {
        this.mapTerain = mapTerain;

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
                                     final int newX, final int newY, StandardPlayer player) {

        if (secondPlayerOnPos[oldX][oldY] == player) {
            secondPlayerOnPos[oldX][oldY] = null;
        } else {
            firstPlayerOnPos[oldX][oldY] = secondPlayerOnPos[oldX][oldY];
            secondPlayerOnPos[oldX][oldY] = null;
        }

        putPlayerAtPosition(newX, newY, player);
    }

    public void testPrint() {
        for (int i = 0; i < firstPlayerOnPos.length; ++i) {
            for(int j = 0; j < firstPlayerOnPos[i].length; ++j) {
                if (secondPlayerOnPos[i][j] != null) {
                    System.out.print(secondPlayerOnPos[i][j].getId() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println(" ");
        }
    }

    public void timeForFight(int posR, int posC, int round) {
        if (secondPlayerOnPos[posR][posC] != null) {
//            System.out.println(posR + " eee "+ round + " ee " + posC);

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

    public void takeOut(StandardPlayer p) {
        if (p == firstPlayerOnPos[p.getPosR()][p.getPosC()]) {
            firstPlayerOnPos[p.getPosR()][p.getPosC()] = secondPlayerOnPos[p.getPosR()][p.getPosC()];
        }
        secondPlayerOnPos[p.getPosR()][p.getPosC()] = null;
    }
}
