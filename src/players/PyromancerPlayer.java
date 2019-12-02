package players;

import common.Constants;

public class PyromancerPlayer extends StandardPlayer {

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


    public PyromancerPlayer(char type, int posR, int posC, int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.PYROMANCE_HP;
        currentHp = maxHp;
    }

    @Override
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land) {
        opponent.getIgnited(heroSpells, this.level, land);
        opponent.getFireBlasted(heroSpells, this.level, land);
        opponent.takeDamage();
        if (this.getKillXp(opponent)) {
            checkLevelUp();
        }
    }


}
