package main;

import java.util.List;

public class GameInput {

    static class PlayerData {
        char type;
        int pozx;
        int pozy;

        PlayerData(char type, int pozx, int pozy) {
            this.type = type;
            this.pozx = pozx;
            this.pozy = pozy;
        }
    }

    private int n;
    private int m;
    private char [][] map;
    private int p;
    private List<PlayerData> inputPlayers;
    private int r;
    private char [][] moves;

    public GameInput() {
        n = 0;
        m = 0;
        map = null;
        p = 0;
        inputPlayers = null;
        r = 0;
        moves = null;
    }

    public GameInput(final int n, final int m, final char [][] map, final int p,
                     final List<PlayerData> inputPlayers,
                     final int r, final char [][] moves) {
        this.m = m;
        this.n = n;
        this.map = map;
        this.p = p;
        this.inputPlayers = inputPlayers;
        this.r = r;
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

    public int getP() {
        return p;
    }

    public List<PlayerData> getInputPlayers() {
        return inputPlayers;
    }

    public int getR() {
        return r;
    }

    public char[][] getMoves() {
        return moves;
    }
}
