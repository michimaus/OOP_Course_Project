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
//            if (firstPlayerOnPos[p.getPosX()][p.getPosY()] == null) {
//                firstPlayerOnPos[p.getPosX()][p.getPosY()] = p;
//            } else {
//                System.out.println("eceva");
//                secondPlayerOnPos[p.getPosX()][p.getPosY()] = p;
//            }
            putPlayerAtPosition(p.getPosR(), p.getPosC(), p);
        }
    }

    public void putPlayerAtPosition(final int posX, final int posY, final StandardPlayer player) {
        if (firstPlayerOnPos[posX][posY] == null) {
            firstPlayerOnPos[posX][posY] = player;
        } else {
            System.out.println("eceva");
            secondPlayerOnPos[posX][posY] = player;
        }
    }

//    public void nulTest() {
//        for (int i = 0; i < 20; ++i) {
//            for (int j = 0; j < 20; ++j) {
//                firstPlayerOnPos[i][j] = null;
//            }
//        }
//    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    public void updatePlayerPosition(final int oldX, final int oldY,
                                     final int newX, final int newY, StandardPlayer player) {
        if (secondPlayerOnPos[oldX][oldY] == null) {
            firstPlayerOnPos[oldX][oldY] = null;
        } else {
            if (firstPlayerOnPos[oldX][oldY] == player) {
                firstPlayerOnPos[oldX][oldY] = secondPlayerOnPos[oldX][oldY];
            }
            secondPlayerOnPos[oldX][oldY] = null;
        }
        putPlayerAtPosition(newX, newY, player);
    }

    public void timeForFight(int posR, int posC, boolean[] checked) {
        if (secondPlayerOnPos[posR][posC] == null) {
            checked[firstPlayerOnPos[posR][posC].getId()] = true;
        } else  {
            checked[firstPlayerOnPos[posR][posC].getId()] = true;
            checked[secondPlayerOnPos[posR][posC].getId()] = true;

            StandardPlayer p1 = firstPlayerOnPos[posR][posC];
            StandardPlayer p2 = secondPlayerOnPos[posR][posC];
            p1.setDealDamage(0);
            p2.setDealDamage(0);

            p1.calculateStrike(heroSpells, p2, mapTerain[posR][posC]);
            p2.calculateStrike(heroSpells, p1, mapTerain[posR][posC]);

        }
    }

    public void takeOut(StandardPlayer p) {
        if (p == firstPlayerOnPos[p.getPosR()][p.getPosC()]) {
            firstPlayerOnPos[p.getPosR()][p.getPosC()] = secondPlayerOnPos[p.getPosR()][p.getPosC()];
        }
        secondPlayerOnPos[p.getPosR()][p.getPosC()] = null;
    }
}
