package players;

import angelseffects.AngelVisitor;
import common.Constants;
import gameterain.GameMap;
import spells.PlayerVisitable;
import spells.PlayerVisitor;
import strategy.PlayerStrategy;

/**
 * Abstract class that builds the base player -is getting extended by all other race classes.
 * Retains the basic data for the players
 */

public abstract class StandardPlayer implements PlayerVisitable {

    protected boolean hasAttacked;
    protected int id;
    protected String type;
    protected int posR;
    protected int posC;
    protected int maxHp;
    protected int currentHp;
    protected int xp;
    protected int level;
    protected int hasDotFor;
    protected float dotDamage;
    protected int stunedFor;
    protected GameMap map;
    protected int incomingDamage;
    protected float modifier;
    protected PlayerStrategy strategy;
    protected float basicDotDamage;

    /**
     * Signatures for the spells of the heroes, when they get hit.
     * @param heroSpell = the visitor that implements the logic of the spells
     * @param caster = the hero casting the spell
     * Also "calculateStrike" is specific to every race
     *             -the place where the attacker applies the hits.
     */
    abstract void getSlamed(PlayerVisitor heroSpell, KnightPlayer caster);
    abstract void getFireBlasted(PlayerVisitor heroSpell,  PyromancerPlayer caster);
    abstract void getIgnited(PlayerVisitor heroSpell, PyromancerPlayer caster);
    abstract void getExecuted(PlayerVisitor heroSpell, KnightPlayer caster);
    abstract void getDrained(PlayerVisitor heroSpell, WizardPlayer caster);
    abstract void getDeflected(PlayerVisitor heroSpell, WizardPlayer caster);
    abstract void getBaskStabbed(PlayerVisitor heroSpell, RoguePlayer caster);
    abstract void getParalyzed(PlayerVisitor heroSpell, RoguePlayer caster);

    public abstract void visitedByDamageAngel(AngelVisitor angel);
    public abstract void visitedByDarkAngel(AngelVisitor angel);
    public abstract void visitedByDracula(AngelVisitor angel);
    public abstract void visitedByGoodBoy(AngelVisitor angel);
    public abstract void visitedByLevelUpAngel(AngelVisitor angel);
    public abstract void visitedByLifeGiver(AngelVisitor angel);
    public abstract void visitedBySmallAngel(AngelVisitor angel);
    public abstract void visitedBySpawner(AngelVisitor angel);
    public abstract void visitedByXPAngel(AngelVisitor angel);

    public final void visitedByTheDoomer(final AngelVisitor angel) {
        angel.effectTheDoomer(this);
    }

    public abstract void calculateStrike(PlayerVisitor heroSpells,
                                         StandardPlayer opponent,  char land);

    abstract void updateMaxHP(int noLevels);

    public final void updateLevel(final int noLevels) {
        for (int i = 1; i <= noLevels; ++i) {
            map.getPlayerObservers().updatePlayerLevel(this, level + i);
        }
        updateMaxHP(noLevels);
        level += noLevels;
    }

    public final char getPieceOfLand() {
        return map.getPieceOfLand(posR, posC);
    }

    public final String getType() {
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

    public final boolean isHasAttacked() {
        return hasAttacked;
    }

    public final void setHasAttacked(final boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
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

    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public final int getId() {
        return id;
    }

    public final float getBasicDotDamage() {
        return basicDotDamage;
    }

    public final float getModifier() {
        return modifier;
    }

    public final void addModifier(final float addPercent) {
        modifier += addPercent;
    }

    public StandardPlayer(final String type, final int posR, final int posC, final int id) {
        hasAttacked = false;
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
        this.modifier = 0f;
    }

    /**
     * It is checked the result of the fight.
     * @param other = hero that fought with this one
     * @return true if this hero managed to kill the other
     * In case of a positive result the mecahnism of the level up is implemented below,
     * in "checkLevelUp.
     */

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
           updateLevel(levelCount);
        }
    }

    /**
     * Next three methods implement the logic of the player when taking damage.
     * The effects are getting applied in different sports in the main game engine.
     */

    public final void takeDotDamage() {
        if (hasDotFor != 0) {
            --hasDotFor;
            currentHp -= dotDamage;
            checkLeaveMap();
        } else {
            dotDamage = 0;
        }
    }

//    public final void getDot(final int stunedForSeconds,
//                             final int hasDotForSeconds, final float dotDamageNow) {
//        this.stunedFor = stunedForSeconds;
//        this.hasDotFor = hasDotForSeconds;
//        this.dotDamage = dotDamageNow;
//    }
    public final void setStunedFor(final int stunedForSeconds) {
        this.stunedFor = stunedForSeconds;
    }

    public final void setHasDotFor(final int stunedForSeconds) {
        this.hasDotFor = stunedForSeconds;
    }

    public final void setDotDamage(final float dotDamage) {
        this.dotDamage = dotDamage;
    }

    public final void setBasicDotDamage(final float newBasicDotDamage) {
        basicDotDamage = newBasicDotDamage;
    }

    public final void takeDamage() {
        currentHp -= incomingDamage;
        incomingDamage = 0;
        checkLeaveMap();
    }

    /**
     * If the move is valid the the position of the player gets updated on the map.
     * @param c = the name of the move the player is going to make.
     */

    public final void updatePlayerNewRound(final char c) {
        if (stunedFor == 0) {
            strategy.getStrategy(this);
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

    public final void addHp(final int addHpPVale) {
        currentHp += addHpPVale;
        if (currentHp > maxHp) {
            currentHp = maxHp;
        } else if (currentHp <= 0) {
            map.takeOut(this);
            map.getPlayerObservers().updateAngelKillingPlayer(this);
        }
    }

    public final void checkLeaveMap() {
        if (currentHp <= 0) {
            map.takeOut(this);
        }
    }

    public final void oneLevelUp() {
        xp = Constants.INIT_LEVEL + level * Constants.ENCEREASE_LEVEL;
        updateLevel(1);
    }

    public final void setCurrentHp(final int hp) {
        currentHp = hp;
        map.getPlayerObservers().updatePlayerRespawned(this);
        map.putPlayerAtPosition(posR, posC, this);
    }

    public final void getXpFromAngel(final int addXp) {
        xp += addXp;
        checkLevelUp();
    }
}

