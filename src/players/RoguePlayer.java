package players;

import common.Constants;

public class RoguePlayer extends StandardPlayer {

    public int getBackStabCount() {
        return backStabCount;
    }

    int backStabCount = 2;

    @Override
    void updateMaxHP(int noLevels) {
        maxHp += noLevels * Constants.ROGUE_HP_ON_LEVEL;
        currentHp = maxHp;
    }

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
        if (backStabCount == Constants.BACKSTAB_CRIT_TIME) {
            backStabCount = 0;
        }

    }

}
