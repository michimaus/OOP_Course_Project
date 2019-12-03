package players;

import common.Constants;

/**
 * Class of the Pyromancer race.
 * Here are implemented the calls for the spells the character is applying,
 * the specific HP status and the calls for the spells that hit this hero, with different efects.
 */

public class PyromancerPlayer extends StandardPlayer {

    @Override
    final void updateMaxHP(final int noLevels) {
        maxHp += noLevels * Constants.PYROMANCE_HP_ON_LEVEL;
        currentHp = maxHp;
    }

    @Override
    final void getSlamed(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.slam(this, level, land);
    }

    @Override
    final void getFireBlasted(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.fireBlast(this, level, land);
    }

    @Override
    final void getIgnited(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.ignite(this, level, land);
    }

    @Override
    final void getExecuted(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.execute(this, level, land);
    }

    @Override
    final void getDrained(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.drain(this, level, land);
    }

    @Override
    final void getDeflected(final PlayerVisitor heroSpell, final int level, final char land,
                      final WizardPlayer wizThis) {
        heroSpell.deflect(this, level, land, wizThis);
    }

    @Override
    final void getBaskStabbed(final PlayerVisitor heroSpell, final int level, final char land,
                        final int count) {
        heroSpell.backStab(this, level, land, count);
    }

    @Override
    final void getParalyzed(final PlayerVisitor heroSpell, final int level, final char land) {
        heroSpell.paralysis(this, level, land);
    }


    public PyromancerPlayer(final char type, final int posR, final int posC, final int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.PYROMANCE_HP;
        currentHp = maxHp;
    }

    @Override
    public final void calculateStrike(final PlayerVisitor heroSpells, final StandardPlayer opponent,
                                final char land) {
        opponent.getIgnited(heroSpells, this.level, land);
        opponent.getFireBlasted(heroSpells, this.level, land);
    }


}
