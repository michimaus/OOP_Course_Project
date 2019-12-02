package players;

import common.Constants;

public class RoguePlayer extends StandardPlayer {

    public int getBackStabCount() {
        return backStabCount;
    }

    int backStabCount = 2;

    @Override
    float getSlamed(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.slam(this, level, land);
    }

    @Override
    float getFireBlasted(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.fireBlast(this, level, land);
    }

    @Override
    float getIgnited(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.ignite(this, level, land);
    }

    @Override
    float getExecuted(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.execute(this, level, land);
    }

    @Override
    float getDrained(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.drain(this, level, land);
    }

    @Override
    float getDeflected(PlayerVisitor heroSpell, int level, char land, WizardPlayer wizThis) {
        return heroSpell.deflect(this, level, land, wizThis);
    }

    @Override
    float getBaskStabbed(PlayerVisitor heroSpell, int level, char land, int count) {
        return heroSpell.backStab(this, level, land, count);
    }

    @Override
    float getParalyzed(PlayerVisitor heroSpell, int level, char land) {
        return heroSpell.paralysis(this, level, land);
    }

    public RoguePlayer(char type, int posR, int posC, int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.ROGUE_HP;
        currentHp = maxHp;
    }

    @Override
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land) {
        ++backStabCount;
        opponent.getBaskStabbed(heroSpells, level, land, backStabCount);
        opponent.getParalyzed(heroSpells, level, land);
        opponent.takeDamage();
        if (backStabCount == Constants.BACKSTAB_CRIT_TIME) {
            backStabCount = 0;
        }
        if (this.getKillXp(opponent)) {
            checkLevelUp();
        }
    }

}
