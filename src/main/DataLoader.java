package main;

import java.util.List;

public class DataLoader {

    static class PlayerData {
        char type;
        int posR;
        int posC;
        PlayerData(char type, int posR, int posC) {
            this.type = type;
            this.posR = posR;
            this.posC = posC;
        }
    }

    private int n;
    private int m;
    private char [][] map;
    private int NoPlayers;
    private List<PlayerData> inputPlayers;
    private int rounds;
    private char [][] moves;

    public DataLoader() {
        n = 0;
        m = 0;
        map = null;
        NoPlayers = 0;
        inputPlayers = null;
        rounds = 0;
        moves = null;
    }

    public DataLoader(final int n, final int m, final char [][] map, final int NoPlayers,
                      final List<PlayerData> inputPlayers,
                      final int rounds, final char [][] moves) {
        this.m = m;
        this.n = n;
        this.map = map;
        this.NoPlayers = NoPlayers;
        this.inputPlayers = inputPlayers;
        this.rounds = rounds;
        this.moves = moves;
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

    public int getNoPlayers() {
        return NoPlayers;
    }

    public List<PlayerData> getInputPlayers() {
        return inputPlayers;
    }

    public int getRounds() {
        return rounds;
    }

    public char[][] getMoves() {
        return moves;
    }
}
