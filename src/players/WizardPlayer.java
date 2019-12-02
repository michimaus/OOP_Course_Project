package players;

import common.Constants;

public class WizardPlayer extends StandardPlayer {

    @Override
    void updateMaxHP(int noLevels) {
        maxHp += noLevels * Constants.WIZARd_HP_ON_LEVEL;
        currentHp = maxHp;
    }
//
//    public float getDeflectDamage() {
//        return deflectDamage;
//    }
//
//    public void setDeflectDamage(float deflectDamage) {
//        this.deflectDamage = deflectDamage;
//    }
//
//    float deflectDamage;

    @Override
    void getSlamed(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.slam(this, level, land);
    }

    @Override
    void getFireBlasted(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.fireBlast(this, level, land);
    }

    @Override
    void getIgnited(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.ignite(this, level, land);
    }

    @Override
    void getExecuted(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.execute(this, level, land);
    }

    @Override
    void getDrained(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.drain(this, level, land);
    }

    @Override
    void getDeflected(PlayerVisitor heroSpell, int level, char land, WizardPlayer wizThis) {
        heroSpell.deflect(this, level, land, wizThis);
    }

    @Override
    void getBaskStabbed(PlayerVisitor heroSpell, int level, char land, int count) {
        heroSpell.backStab(this, level, land, count);
    }

    @Override
    void getParalyzed(PlayerVisitor heroSpell, int level, char land) {
        heroSpell.paralysis(this, level, land);
    }

    public WizardPlayer(char type, int posR, int posC, int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.WIZARd_HP;
        currentHp = maxHp;
    }

    @Override
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land) {
        opponent.getDeflected(heroSpells, level, land, this);
        opponent.getDrained(heroSpells, level, land);
    }


}
