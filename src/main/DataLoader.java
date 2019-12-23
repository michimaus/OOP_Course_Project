package main;

/**
 * In this file it is designed the structure of the input data.
 * Each field retains raw data that are parsed to the main program where those
 * are getting processed.
 */

public final class DataLoader {

    private static DataLoader instance = null;

    private DataLoader() {
        player = new PlayerData();
        angel = new AngelData();
    }

    public static DataLoader getInstance() {
        if (instance == null) {
            return new DataLoader();
        }
        return instance;
    }

    public static class AngelData {
        public final String getType() {
            return type;
        }

        public final int getPosR() {
            return posR;
        }

        public final int getPosC() {
            return posC;
        }

        public final void setType(final String type) {
            this.type = type;
        }

        public final void setPosR(final int posR) {
            this.posR = posR;
        }

        public final void setPosC(final int posC) {
            this.posC = posC;
        }

        private String type;
        private int posR;
        private int posC;
    }

    public static class PlayerData {
        public final char getType() {
            return type;
        }

        public final int getPosR() {
            return posR;
        }

        public final int getPosC() {
            return posC;
        }

        public final void setType(final char type) {
            this.type = type;
        }

        public final void setPosR(final int posR) {
            this.posR = posR;
        }

        public final void setPosC(final int posC) {
            this.posC = posC;
        }

        private char type;
        private int posR;
        private int posC;
    }

    private int n;
    private int p;
    private int m;
    private char[][] map;
    private PlayerData player = null;
    private AngelData angel = null;
    private int rounds;
    private char[][] moves;

    public void setGameMap(final int nRead, final int mRead, final char mapRead[][]) {
        this.n = nRead;
        this.m = mRead;
        this.map = mapRead;
    }

    public void setNumPlyaers(final int pRead) {
        this.p = pRead;
    }

    public PlayerData getPlayer() {
        return player;
    }

    public void setPlayer(final char type, final int posR, final int posC) {
        player.setType(type);
        player.setPosR(posR);
        player.setPosC(posC);
    }

    public void setAngel(final String type, final int posR, final int posC) {
        angel.setType(type);
        angel.setPosR(posR);
        angel.setPosC(posC);
    }


//    public DataLoader(final int n, final int m, final char[][] map,
//                      final List<PlayerData> inputPlayers,
//                      final LinkedList<LinkedList<AngelData>> inputAngels,
//                      final int rounds, final char[][] moves) {
//        this.m = m;
//        this.n = n;
//        this.map = map;
//        this.inputPlayers = inputPlayers;
//        this.inputAngels = inputAngels;
//        this.rounds = rounds;
//        this.moves = moves;
//    }

    public int getP() {
        return p;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public char[][] getMap() {
        return map;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }

    public char[][] getMoves() {
        return moves;
    }
}
