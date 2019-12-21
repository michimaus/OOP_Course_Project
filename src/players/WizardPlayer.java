package players;

import common.Constants;
import spells.PlayerVisitor;

/**
 * Class of the Wizard race.
 * Here are implemented the calls for the spells the character is applying,
 * the specific HP status and the calls for the spells that hit this hero, with different efects.
 */

public class WizardPlayer extends StandardPlayer {

    @Override
    final void updateMaxHP(final int noLevels) {
        maxHp += noLevels * Constants.WIZARD_HP_ON_LEVEL;
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

    public WizardPlayer(final char type, final int posR, final int posC, final int playerId) {
        super(type, posR, posC, playerId);
        maxHp = Constants.WIZARD_HP;
        currentHp = maxHp;
    }

    @Override
    public final void calculateStrike(final PlayerVisitor heroSpells, final StandardPlayer opponent,
                                final char land) {
        opponent.getDeflected(heroSpells, this);
        opponent.getDrained(heroSpells, this);
    }


}
