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
    private final String mInputPath;
    private final String mOutputPath;

    InputOutputStream(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public void write(final List<StandardPlayer> players) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
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

    public DataLoader load() {
        int n = 0;
        int m = 0;
        char[][] map = null;
        int p = 0;
        List<DataLoader.PlayerData> inputPlayers = new ArrayList<>();
        LinkedList<LinkedList<DataLoader.AngelData>> inputAngels = new LinkedList<>();
        int r = 0;
        char[][] moves = null;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

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


//                System.out.println(numAngels);


                inputAngels.add(new LinkedList<>());

                for (int j = 0; j < numAngels; ++j) {
                    String auxStr = fs.nextWord();
                    int len = auxStr.length();

                    int auxPosy = auxStr.charAt(auxStr.length() - Constants.INDEX_POSY) - '0';
                    int auxPosx = auxStr.charAt(auxStr.length() - Constants.INDEX_POSX) - '0';


                    inputAngels.getLast().add(new DataLoader.AngelData(auxStr.substring(0,
                            auxStr.length() - Constants.INDEX_SUBSTRING), auxPosx, auxPosy));
                }
//                System.out.println();
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new DataLoader(n, m, map, inputPlayers, inputAngels, r, moves);
    }
}
