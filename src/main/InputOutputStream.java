package main;

import java.util.List;

import angels.StandardAngel;
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

    InputOutputStream(final String inputPath, final String outputPath,
                      final DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        try {
            fs = new FileSystem(inputPath, outputPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeEmptyLine() {
        try {
            fs.writeNewLine();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeRound(final int round) {
        try {
            fs.writeWord("~~ Round " + (round + 1) + " ~~\n");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeAngelSpawn(final StandardAngel angel) {
        try {
            fs.writeWord("Angel " + angel.getType() + " was spawned at "
                    + angel.getPosR() + " " + angel.getPosC() + '\n');
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writePlayerInteraction(final StandardAngel angel, final StandardPlayer player) {
        try {
            fs.writeWord(angel.getType() + angel.getAngelOutAction()
                    + player.getType() + " " + player.getId() + '\n');
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writePlayerKillingOther(final StandardPlayer killer, final StandardPlayer player) {
        try {
            fs.writeWord("Player " + player.getType() + ' ' + player.getId()
                    + " was killed by " + killer.getType() + " " + killer.getId() + '\n');
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeAngelKillingPlayer(final StandardPlayer player) {
        try {
            fs.writeWord("Player " + player.getType() + ' ' + player.getId()
                    + " was killed by an angel\n");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writePlayerRespawned(final StandardPlayer player) {
        try {
            fs.writeWord("Player " + player.getType() + ' ' + player.getId()
                    + " was brought to life by an angel\n");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writePlayerReachLevel(final StandardPlayer player, final int level) {
        try {
            fs.writeWord(player.getType() + ' ' + player.getId()
                    + " reached level " + level + '\n');
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void writeFinalStandings(final List<StandardPlayer> players) {
        try {
            fs.writeWord("~~ Results ~~\n");
            for (StandardPlayer player : players) {
                fs.writeCharacter(player.getType().charAt(0));
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
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void closeFiles() {
        try {
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
            dataLoader.setNumPlayers(p);
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

    public void loadRoundsMoves() {
        int r;
        char[][] moves;
        try {
            r = fs.nextInt();
            dataLoader.setRounds(r);
            moves = new char[r][dataLoader.getP()];
            for (int i = 0; i < r; ++i) {
                String auxStr = fs.nextWord();
                for (int j = 0; j < dataLoader.getP(); ++j) {
                    moves[i][j] = auxStr.charAt(j);
                }
            }
            dataLoader.setMoves(moves);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadNumAngelsRound() {
        int numAngels;
        try {
            numAngels = fs.nextInt();
            dataLoader.setNumAngelsRound(numAngels);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void loadAngel() {
        try {
            String auxStr = fs.nextWord();
            String[] vecStr = new String[Constants.NUMBER_SPLIT];
            int k = 0;
            for (String auxSubStr : auxStr.split(",")) {
                vecStr[k] = auxSubStr;
                ++k;
            }
            int auxPosC = Integer.parseInt(vecStr[--k]);
            int auxPosR = Integer.parseInt(vecStr[--k]);

            dataLoader.setAngel(vecStr[--k], auxPosR, auxPosC);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
