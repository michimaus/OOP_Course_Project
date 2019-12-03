package players;

import common.Constants;
import gameterain.GameMap;

public abstract class StandardPlayer implements PlayerVisitable {

    protected boolean hasAtacked;
    protected int id;
    protected char type;
    protected int posR;
    protected int posC;
    protected int maxHp;
    protected int currentHp;
    protected int xp;
    protected int level;
    protected int hasDotFor;
    protected float dotDamage;
    protected int stunedFor;
    protected boolean stuned;
    protected GameMap map;
    protected int incomingDamage;

    abstract void updateMaxHP(int noLevels);
    abstract void getSlamed(PlayerVisitor heroSpell, int levelHero, char land);
    abstract void getFireBlasted(PlayerVisitor heroSpell,  int levelHero, char land);
    abstract void getIgnited(PlayerVisitor heroSpell, int levelHero, char land);
    abstract void getExecuted(PlayerVisitor heroSpell, int levelHero, char land);
    abstract void getDrained(PlayerVisitor heroSpell, int levelHero, char land);
    abstract void getDeflected(PlayerVisitor heroSpell, int levelHero,
                               char land, WizardPlayer wizThis);
    abstract void getBaskStabbed(PlayerVisitor heroSpell, int levelHero, char land, int count);
    abstract void getParalyzed(PlayerVisitor heroSpell, int levelHero, char land);
    public abstract void calculateStrike(PlayerVisitor heroSpells,
                                         StandardPlayer opponent,  char land);

    public final char getType() {
        return type;
    }

    public final int getCurrentHp() {
        return currentHp;
    }

    public final int getPosR() {
        return posR;
    }

    public final int getPosC() {
        return posC;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final boolean isHasAtacked() {
        return hasAtacked;
    }

    public final void setHasAtacked(final boolean hasAtacked) {
        this.hasAtacked = hasAtacked;
    }

    public final int getIncomingDamage() {
        return incomingDamage;
    }

    public final void setIncomingDamage(final int incomingDamage) {
        this.incomingDamage = incomingDamage;
    }

    public final float getDotDamage() {
        return dotDamage;
    }

    public final void setDotDamage(final float dotDamage) {
        this.dotDamage = dotDamage;
    }

    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public final int getId() {
        return id;
    }

    public StandardPlayer(final char type, final int posR, final int posC, final int id) {
        hasAtacked = false;
        this.stuned = false;
        this.stunedFor = 0;
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
    public final boolean getKillXp(final StandardPlayer other) {
        if (other.currentHp > 0) {
            return false;
        }
        int xpTransfer = Constants.XP_UPPER_BOUND - (level - other.level) * Constants.XP_INTERVAL;
        if (xpTransfer < 0) {
            xpTransfer = 0;
        }
        this.xp += xpTransfer;
        return true;
    }

    public final void checkLevelUp() {
        if (xp >= Constants.INIT_LEVEL + level * Constants.ENCEREASE_LEVEL) {
            int levelCount = (1 + (xp - (Constants.INIT_LEVEL + level
                    * Constants.ENCEREASE_LEVEL)) / Constants.ENCEREASE_LEVEL);
            this.updateMaxHP(levelCount);
            level += levelCount;
        }
    }

    public final void takeDotDamage() {
        if (hasDotFor != 0) {
            --hasDotFor;
            currentHp -= dotDamage;
        } else {
            dotDamage = 0;
        }

        if (currentHp <= 0) {
            die();
        }
    }

    public final void updatePlayerNewRound(final char c) {
        if (stunedFor == 0) {
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
            if (ok) {
                map.updatePlayerPosition(oldR, oldC, posR, posC, this);
            }
        } else {
            --stunedFor;
        }
    }

    protected final void die() {
        currentHp = -1;
        map.takeOut(this);
    }

    public final void getDot(final int stunedForSeconds,
                             final int hasDotForSeconds, final float dotDamageNow) {
        this.stunedFor = stunedForSeconds;
        this.hasDotFor = hasDotForSeconds;
        this.dotDamage = dotDamageNow;
    }

    public final void takeDamage() {
        currentHp -= incomingDamage;
        incomingDamage = 0;
        if (currentHp <= 0) {
            die();
        }
    }
}
