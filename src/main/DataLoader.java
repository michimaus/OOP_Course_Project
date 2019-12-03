package main;

import java.util.List;

/**
 * In this file it is designed the structure of the input data.
 * Each field retains raw data that are parsed to the main program where those
 * are getting processed.
 */

public class DataLoader {

    static class PlayerData {
        public char getType() {
            return type;
        }

        public int getPosR() {
            return posR;
        }

        public int getPosC() {
            return posC;
        }

        private char type;
        private int posR;
        private int posC;
        PlayerData(final char type, final int posR, final int posC) {
            this.type = type;
            this.posR = posR;
            this.posC = posC;
        }
    }

    private int n;
    private int m;
    private char[][] map;
    private int noPlayers;
    private List<PlayerData> inputPlayers;
    private int rounds;
    private char[][] moves;

    public DataLoader(final int n, final int m, final char[][] map, final int noPlayers,
                      final List<PlayerData> inputPlayers,
                      final int rounds, final char[][] moves) {
        this.m = m;
        this.n = n;
        this.map = map;
        this.noPlayers = noPlayers;
        this.inputPlayers = inputPlayers;
        this.rounds = rounds;
        this.moves = moves;
    }

    public final int getN() {
        return n;
    }

    public final int getM() {
        return m;
    }

    public final char[][] getMap() {
        return map;
    }

    public final int getNoPlayers() {
        return noPlayers;
    }

    public final List<PlayerData> getInputPlayers() {
        return inputPlayers;
    }

    public final int getRounds() {
        return rounds;
    }

    public final char[][] getMoves() {
        return moves;
    }
}
