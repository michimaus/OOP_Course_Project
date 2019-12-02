package main;

import java.util.ArrayList;
import java.util.List;

import fileio.FileSystem;
import players.StandardPlayer;

public final class InputOutputStream {
    private final String mInputPath;
    private final String mOutputPath;

    InputOutputStream(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public void write(List<StandardPlayer> players) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (StandardPlayer player : players) {
                fs.writeCharacter(player.getType());
                fs.writeCharacter(' ');

                if (player.getMaxHp() <= 0) {
                    fs.writeWord("dead");
                } else {
                    fs.writeInt(player.getLevel());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getXp());
                    fs.writeCharacter(' ');
                    fs.writeInt(player.getMaxHp());
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
        char [][] map = null;
        int p = 0;
        List<DataLoader.PlayerData> inputPlayers = new ArrayList<>();
        int r = 0;
        char [][] moves = null;

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

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new DataLoader(n, m, map, p,inputPlayers, r, moves);
    }
}
