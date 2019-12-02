package players;

import common.Constants;

public class RoguePlayer extends StandardPlayer {
    @Override
    float getSlamed(PlayerVisitor heroSpell, int level) {
        return heroSpell.slam(this, level);
    }

    @Override
    float getFireBlasted(PlayerVisitor heroSpell, int level) {
        return heroSpell.fireBlast(this, level);
    }

    @Override
    float getIgnited(PlayerVisitor heroSpell, int level) {
        return heroSpell.ignite(this, level);
    }

    @Override
    float getExecuted(PlayerVisitor heroSpell, int level) {
        return heroSpell.execute(this, level);
    }

    @Override
    float getDrained(PlayerVisitor heroSpell, int level) {
        return heroSpell.drain(this, level);
    }

    @Override
    float getDeflected(PlayerVisitor heroSpell, int level) {
        return heroSpell.deflect(this, level);
    }

    @Override
    float getBaskStabbed(PlayerVisitor heroSpell, int level) {
        return heroSpell.backStab(this, level);
    }

    @Override
    float getParalyzed(PlayerVisitor heroSpell, int level) {
        return heroSpell.paralysis(this, level);
    }


    public RoguePlayer(char type, int posR, int posC, int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.ROGUE_HP;
        currentHp = maxHp;
    }

    @Override
    public void strike(PlayerVisitor v) {

    }

    @Override
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land) {

    }

}
