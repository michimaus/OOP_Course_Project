package angelseffects;

import common.Constants;
import players.KnightPlayer;
import players.PyromancerPlayer;
import players.RoguePlayer;
import players.WizardPlayer;
import players.StandardPlayer;

public class AngelEffects implements AngelVisitor {

    @Override
    public final void effectDamageAngel(final KnightPlayer player) {
        player.addModifier(Constants.DAMAGE_ANGEL_KNIGHT);
    }

    @Override
    public final void effectDamageAngel(final PyromancerPlayer player) {
        player.addModifier(Constants.DAMAGE_ANGEL_PYROMANCER);

    }

    @Override
    public final void effectDamageAngel(final WizardPlayer player) {
        player.addModifier(Constants.DAMAGE_ANGEL_WIZARD);

    }

    @Override
    public final void effectDamageAngel(final RoguePlayer player) {
        player.addModifier(Constants.DAMAGE_ANGEL_ROGUE);
    }

    @Override
    public final void effectDarkAngel(final KnightPlayer player) {
        player.addHp(Constants.DARK_ANGEL_KNIGHT * (-1));
    }

    @Override
    public final void effectDarkAngel(final PyromancerPlayer player) {
        player.addHp(Constants.DARK_ANGEL_PYROMANCER * (-1));
    }

    @Override
    public final void effectDarkAngel(final WizardPlayer player) {
        player.addHp(Constants.DARK_ANGEL_WIZARD * (-1));
    }

    @Override
    public final void effectDarkAngel(final RoguePlayer player) {
        player.addHp(Constants.DARK_ANGEL_ROGUE * (-1));
    }

    @Override
    public final void effectDracula(final KnightPlayer player) {
        player.addModifier(Constants.DRACULA_DAMAGE_KNIGHT * (-1));
        player.addHp(Constants.DRACULA_HP_KNIGHT * (-1));
    }

    @Override
    public final void effectDracula(final PyromancerPlayer player) {
        player.addModifier(Constants.DRACULA_DAMAGE_PYROMANCER * (-1));
        player.addHp(Constants.DRACULA_HP_PYROMANCER * (-1));
    }

    @Override
    public final void effectDracula(final WizardPlayer player) {
        player.addModifier(Constants.DRACULA_DAMAGE_WIZARD * (-1));
        player.addHp(Constants.DRACULA_HP_WIZARD * (-1));
    }

    @Override
    public final void effectDracula(final RoguePlayer player) {
        player.addModifier(Constants.DRACULA_DAMAGE_ROGUE * (-1));
        player.addHp(Constants.DRACULA_HP_ROGUE * (-1));
    }

    @Override
    public final void effectGoodBoy(final KnightPlayer player) {
        player.addModifier(Constants.GOODBOY_DAMAGE_KNIGHT);
        player.addHp(Constants.GOODBOY_HP_KNIGHT);
    }

    @Override
    public final void effectGoodBoy(final PyromancerPlayer player) {
        player.addModifier(Constants.GOODBOY_DAMAGE_PYROMANCER);
        player.addHp(Constants.GOODBOY_HP_PYROMANCER);
    }

    @Override
    public final void effectGoodBoy(final WizardPlayer player) {
        player.addModifier(Constants.GOODBOY_DAMAGE_WIZARD);
        player.addHp(Constants.GOODBOY_HP_WIZARD);
    }

    @Override
    public final void effectGoodBoy(final RoguePlayer player) {
        player.addModifier(Constants.GOODBOY_DAMAGE_ROGUE);
        player.addHp(Constants.GOODBOY_HP_ROGUE);
    }

    @Override
    public final void effectLevelUpAngel(final KnightPlayer player) {
        player.addModifier(Constants.LEVELUP_ANGEL_KNIGHT);
    }

    @Override
    public final void effectLevelUpAngel(final PyromancerPlayer player) {
        player.addModifier(Constants.LEVELUP_ANGEL_PYROMANCER);
    }

    @Override
    public final void effectLevelUpAngel(final WizardPlayer player) {
        player.addModifier(Constants.LEVELUP_ANGEL_WIZARD);
    }

    @Override
    public final void effectLevelUpAngel(final RoguePlayer player) {
        player.addModifier(Constants.LEVELUP_ANGEL_ROGUE);
    }

    @Override
    public final void effectLifeGiver(final KnightPlayer player) {
        player.addHp(Constants.LIFEGIVER_KNIGHT);
    }

    @Override
    public final void effectLifeGiver(final PyromancerPlayer player) {
        player.addHp(Constants.LIFEGIVER_PYROMANCER);
    }

    @Override
    public final void effectLifeGiver(final WizardPlayer player) {
        player.addHp(Constants.LIFEGIVER_WIZARD);
    }

    @Override
    public final void effectLifeGiver(final RoguePlayer player) {
        player.addHp(Constants.LIFEGIVER_ROGUE);
    }

    @Override
    public final void effectSmallAngel(final KnightPlayer player) {
        player.addModifier(Constants.SMALL_ANGEL_DAMAGE_KNIGHT);
        player.addHp(Constants.SMALL_ANGEL_HP_KNIGHT);
    }

    @Override
    public final void effectSmallAngel(final PyromancerPlayer player) {
        player.addModifier(Constants.SMALL_ANGEL_DAMAGE_PYROMANCER);
        player.addHp(Constants.SMALL_ANGEL_HP_PYROMANCER);
    }

    @Override
    public final void effectSmallAngel(final WizardPlayer player) {
        player.addModifier(Constants.SMALL_ANGEL_DAMAGE_WIZARD);
        player.addHp(Constants.SMALL_ANGEL_HP_WIZARD);
    }

    @Override
    public final void effectSmallAngel(final RoguePlayer player) {
        player.addModifier(Constants.SMALL_ANGEL_DAMAGE_ROGUE);
        player.addHp(Constants.SMALL_ANGEL_HP_ROGUE);
    }

    @Override
    public final void effectSpawner(final KnightPlayer player) {
        player.setCurrentHp(Constants.SPAWNER_KNIGHT);
    }

    @Override
    public final void effectSpawner(final PyromancerPlayer player) {
        player.setCurrentHp(Constants.SPAWNER_PYROMANCER);
    }

    @Override
    public final void effectSpawner(final WizardPlayer player) {
        player.setCurrentHp(Constants.SPAWNER_WIZARD);
    }

    @Override
    public final void effectSpawner(final RoguePlayer player) {
        player.setCurrentHp(Constants.SPAWNER_ROGUE);
    }

    @Override
    public final void effectTheDoomer(final StandardPlayer player) {
        player.addHp((-1) * player.getCurrentHp());
    }

    @Override
    public final void effectXpAngel(final KnightPlayer player) {
        player.getXpFromAngel(Constants.XP_ANGEL_KNIGHT);
    }

    @Override
    public final void effectXpAngel(final PyromancerPlayer player) {
        player.getXpFromAngel(Constants.XP_ANGEL_PYROMANCER);
    }

    @Override
    public final void effectXpAngel(final WizardPlayer player) {
        player.getXpFromAngel(Constants.XP_ANGEL_WIZARD);
    }

    @Override
    public final void effectXpAngel(final RoguePlayer player) {
        player.getXpFromAngel(Constants.XP_ANGEL_ROGUE);
    }
}
