package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * In this file it is designed the structure of the input data.
 * Each field retains raw data that are parsed to the main program where those
 * are getting processed.
 */

public class DataLoader {

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

        private String type;
        private int posR;
        private int posC;
        AngelData(final String type, final int posR, final int posC) {
            this.type = type;
            this.posR = posR;
            this.posC = posC;
        }
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
    private List<PlayerData> inputPlayers;
    private LinkedList<LinkedList<AngelData>> inputAngels;
    private int rounds;
    private char[][] moves;

    public DataLoader(final int n, final int m, final char[][] map,
                      final List<PlayerData> inputPlayers,
                      final LinkedList<LinkedList<AngelData>> inputAngels,
                      final int rounds, final char[][] moves) {
        this.m = m;
        this.n = n;
        this.map = map;
        this.inputPlayers = inputPlayers;
        this.inputAngels = inputAngels;
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

    public final LinkedList<LinkedList<AngelData>> getInputAngels() {
        return inputAngels;
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
