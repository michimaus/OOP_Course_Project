package players;

import gameterain.GameMap;

public abstract class StandardPlayer implements PlayerVisitable{
    protected int id;
    protected char type;
    protected int posR;
    protected int posC;
    protected int maxHp;

    public int getCurrentHp() {
        return currentHp;
    }

    protected int currentHp;
    protected int xp;
    protected int level;
    protected int hasDotFor;
    protected int dotDamage;
    protected int stundeFor;
    protected boolean stuned;
    protected GameMap map;
    protected int dealDamage;


    abstract float getSlamed(PlayerVisitor heroSpell, int level);
    abstract float getFireBlasted(PlayerVisitor heroSpell, int level);
    abstract float getIgnited(PlayerVisitor heroSpell, int level);
    abstract float getExecuted(PlayerVisitor heroSpell, int level);
    abstract float getDrained(PlayerVisitor heroSpell, int level);
    abstract float getDeflected(PlayerVisitor heroSpell, int level);
    abstract float getBaskStabbed(PlayerVisitor heroSpell, int level);
    abstract float getParalyzed(PlayerVisitor heroSpell, int level);
    public abstract void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land);

    public void setDealDamage(int dealDamage) {
        this.dealDamage = dealDamage;
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

    public int getMaxHp() {
        return maxHp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    public StandardPlayer(char type, int posR, int posC, int id) {
        this.stuned = false;
        this.stundeFor = 0;
        this.id = id;
        this.dotDamage = 0;
        map = GameMap.getInstance();
        this.type = type;
        this.posR = posR;
        this.posC = posC;
        this.xp = 0;
        this.level = 0;
        this.hasDotFor = 0;
    }

    public void updatePlayerNewRound(char c) {
        if (currentHp <= 0) {
            return;
        }

        if (hasDotFor != 0) {
            --hasDotFor;
            currentHp -= dotDamage;
        } else {
            dotDamage = 0;
        }

        if (stundeFor == 0) {
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
            if (ok && maxHp > 0) {
                map.updatePlayerPosition(oldR, oldC, posR, posC, this);
            }
        } else {
            --stundeFor;
        }
    }

    protected void die() {
        currentHp = -1;
        map.takeOut(this);
    }

}
