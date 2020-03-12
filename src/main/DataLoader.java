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
            instance = new DataLoader();
        }
        return instance;
    }

    public static final class AngelData {
        private AngelData() {
        }

        public String getType() {
            return type;
        }

        public int getPosR() {
            return posR;
        }

        public int getPosC() {
            return posC;
        }

        public void setType(final String type) {
            this.type = type;
        }

        public void setPosR(final int posR) {
            this.posR = posR;
        }

        public void setPosC(final int posC) {
            this.posC = posC;
        }

        private String type;
        private int posR;
        private int posC;
    }

    public static final class PlayerData {
        private PlayerData() {
        }

        public char getType() {
            return type;
        }

        public int getPosR() {
            return posR;
        }

        public int getPosC() {
            return posC;
        }

        public void setType(final char type) {
            this.type = type;
        }

        public void setPosR(final int posR) {
            this.posR = posR;
        }

        public void setPosC(final int posC) {
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
    private PlayerData player;
    private AngelData angel;
    private int rounds;
    private char[][] moves;
    private int numAngelsRound;

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    public void setMoves(final char[][] moves) {
        this.moves = moves;
    }

    public void setNumPlayers(final int pRead) {
        this.p = pRead;
    }

    public void setNumAngelsRound(final int numAngels) {
        numAngelsRound = numAngels;
    }

    public void setGameMap(final int nRead, final int mRead, final char[][] mapRead) {
        this.n = nRead;
        this.m = mRead;
        this.map = mapRead;
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

    public PlayerData getPlayer() {
        return player;
    }

    public AngelData getAngel() {
        return angel;
    }

    public int getP() {
        return p;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getNumAngelsRound() {
        return numAngelsRound;
    }

    public char[][] getMap() {
        return map;
    }

    public int getRounds() {
        return rounds;
    }

    public char[][] getMoves() {
        return moves;
    }
}
