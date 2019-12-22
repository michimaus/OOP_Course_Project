package players;

import angels.AngelVisitor;
import common.Constants;
import spells.PlayerVisitor;

/**
 * Class of the Rogue race.
 * Here are implemented the calls for the spells the character is applying,
 * the specific HP status and the calls for the spells that hit this hero, with different efects.
 */

public class RoguePlayer extends StandardPlayer {

    public final int getBackStabCount() {
        return backStabCount;
    }

    private int backStabCount = 2;

    @Override
    final void updateMaxHP(final int noLevels) {
        maxHp += noLevels * Constants.ROGUE_HP_ON_LEVEL;
        currentHp = maxHp;
    }

    @Override
    final void getSlamed(final PlayerVisitor heroSpell, final KnightPlayer caster) {
        heroSpell.slam(this, caster);
    }

    @Override
    final void getFireBlasted(final PlayerVisitor heroSpell, final PyromancerPlayer caster) {
        heroSpell.fireBlast(this, caster);
    }

    @Override
    final void getIgnited(final PlayerVisitor heroSpell, final PyromancerPlayer caster) {
        heroSpell.ignite(this, caster);
    }

    @Override
    final void getExecuted(final PlayerVisitor heroSpell, final KnightPlayer caster) {
        heroSpell.execute(this, caster);
    }

    @Override
    final void getDrained(final PlayerVisitor heroSpell, final WizardPlayer caster) {
        heroSpell.drain(this, caster);
    }

    @Override
    final void getDeflected(final PlayerVisitor heroSpell, final WizardPlayer caster) {
        heroSpell.deflect(this, caster);
    }

    @Override
    final void getBaskStabbed(final PlayerVisitor heroSpell, final RoguePlayer caster) {
        heroSpell.backStab(this, caster);
    }

    @Override
    final void getParalyzed(final PlayerVisitor heroSpell, final RoguePlayer caster) {
        heroSpell.paralysis(this, caster);
    }

    @Override
    void visitedByDamageAngel(final AngelVisitor angel) {

    }

    @Override
    void visitedByDarkAngel(final AngelVisitor angel) {

    }

    @Override
    void visitedByDracula(final AngelVisitor angel) {

    }

    @Override
    void visitedByGoodBoy(final AngelVisitor angel) {

    }

    @Override
    void visitedByLevelUpAngel(final AngelVisitor angel) {

    }

    @Override
    void visitedByLifeGiver(final AngelVisitor angel) {

    }

    @Override
    void visitedBySmallAngel(final AngelVisitor angel) {

    }

    @Override
    void visitedBySpawner(final AngelVisitor angel) {

    }

    @Override
    void visitedByXPAngel(final AngelVisitor angel) {

    }

    public RoguePlayer(final char type, final int posR, final int posC, final int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.ROGUE_HP;
        currentHp = maxHp;
    }

    @Override
    public final void calculateStrike(final PlayerVisitor heroSpells,
                                final StandardPlayer opponent, final char land) {
        ++backStabCount;
        opponent.getBaskStabbed(heroSpells, this);
        opponent.getParalyzed(heroSpells, this);
        if (backStabCount == Constants.BACKSTAB_CRIT_TIME) {
            backStabCount = 0;
        }

    }

}
