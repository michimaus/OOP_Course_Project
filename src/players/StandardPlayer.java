package players;

import gameterain.GameMap;

public abstract class StandardPlayer implements PlayerVisitable{
    protected char type;
    protected int posR;
    protected int posC;
    protected int hp;
    protected int xp;
    protected int level;
    protected int hasDotFor;
    protected GameMap map;
    protected int dealDamage;

    public char getType() {
        return type;
    }

    public int getPosR() {
        return posR;
    }

    public int getPosC() {
        return posC;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public StandardPlayer(char type, int posR, int posC) {
        map = GameMap.getInstance();
        this.type = type;
        this.posR = posR;
        this.posC = posC;
        this.xp = 0;
        this.level = 0;
        this.hasDotFor = 0;
    }

    public void movePosition(char c) {
        boolean ok = true;
        final int oldR = posR;
        final int oldC = posC;

        switch (c) {
            case 'U':
                --posR;
                break;
            case 'D':
                ++posR;
                break;
            case 'L':
                --posC;
                break;
            case 'R':
                ++posC;
                break;
            default:
                ok = false;
                break;
        }
        if (ok && hp > 0) {
            map.updatePlayerPosition(oldR, oldC, posR, posC, this);
        }

    }
}
