package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.Constants;
import fileio.FileSystem;
import players.StandardPlayer;

/**
 * Structer for the calss that reads form files and writes into another one.
 * Used the provided fileIO.jar.
 */

public final class InputOutputStream {
    private FileSystem fs = null;
    private DataLoader dataLoader;

    InputOutputStream(final String inputPath, final String outputPath) {
        dataLoader = DataLoader.getInstance();
        try {
            fs = new FileSystem(inputPath, outputPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeFinalStandings(final List<StandardPlayer> players) {
        try {
            for (StandardPlayer player : players) {
                fs.writeCharacter(player.getType());
                fs.writeCharacter(' ');

                if (player.getCurrentHp() <= 0) {
                    fs.writeWord("dead");
                } else {
                    fs.writeInt(player.getLevel());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getXp());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getCurrentHp());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getPosR());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getPosC());
                }
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadMap() {
        int n;
        int m;
        char[][] map;
        try {
            n = fs.nextInt();
            m = fs.nextInt();
            map = new char[n][m];

            for (int i = 0; i < n; ++i) {
                String auxStr = fs.nextWord();
                for (int j = 0; j < m; ++j) {
                    map[i][j] = auxStr.charAt(j);
                }
            }
            dataLoader.setGameMap(n, m, map);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadNumPlayers() {
        int p;
        try {
            p = fs.nextInt();
            dataLoader.setNumPlyaers(p);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadPlayer() {
        int posR;
        int posC;
        char type;
        try {
            type = fs.nextWord().charAt(0);
            posR = fs.nextInt();
            posC = fs.nextInt();
            dataLoader.setPlayer(type, posR, posC);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadNumRounds() {
        int r;
        try {
            r = fs.nextInt();
            dataLoader.setRounds(r);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void load() {
        int n = 0;
        int m = 0;
        char[][] map = null;
        int p = 0;
        List<DataLoader.PlayerData> inputPlayers = new ArrayList<>();
        LinkedList<LinkedList<DataLoader.AngelData>> inputAngels = new LinkedList<>();
        int r = 0;
        char[][] moves = null;

        try {
            n = fs.nextInt();
            m = fs.nextInt();
            map = new char[n][m];

            for (int i = 0; i < n; ++i) {
                String auxStr = fs.nextWord();
                for (int j = 0; j < m; ++j) {
                    map[i][j] = auxStr.charAt(j);
                }
            }

            p = fs.nextInt();

            for (int i = 0; i < p; ++i) {
                String auxStr = fs.nextWord();
                int auxPosx = fs.nextInt();
                int auxPosy = fs.nextInt();
                inputPlayers.add(new DataLoader.PlayerData(auxStr.charAt(0), auxPosx, auxPosy));
            }

            r = fs.nextInt();
            moves = new char[r][p];

            for (int i = 0; i < r; ++i) {
                String auxStr = fs.nextWord();
                for (int j = 0; j < p; ++j) {
                    moves[i][j] = auxStr.charAt(j);
                }
            }

            for (int i = 0; i < r; ++i) {
                int numAngels = fs.nextInt();

                inputAngels.add(new LinkedList<>());

                for (int j = 0; j < numAngels; ++j) {
                    String auxStr = fs.nextWord();
                    String vecStr[] = new String[Constants.NUMBER_SPLIT + 1];
                    int k = 0;

                    for (String auxSubStr : auxStr.split(",")) {
                        vecStr[k] = auxSubStr;
                        ++k;
                    }

                    int auxPosy = Integer.parseInt(vecStr[--k]);
                    int auxPosx = Integer.parseInt(vecStr[--k]);

                    inputAngels.getLast().add(new DataLoader.AngelData(vecStr[--k],
                            auxPosx, auxPosy));
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }

//        return new DataLoader(n, m, map, inputPlayers, inputAngels, r, moves);
    }
}
