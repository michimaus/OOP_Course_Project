package spells;

import players.KnightPlayer;
import players.PyromancerPlayer;
import players.RoguePlayer;
import players.WizardPlayer;

/**
 * Signatures for the methods of all spells.
 * Particularly implementations for each case-interction between heroes.
 */

public interface PlayerVisitor {

    void fireBlast(KnightPlayer player, PyromancerPlayer caster);
    void fireBlast(RoguePlayer player, PyromancerPlayer caster);
    void fireBlast(PyromancerPlayer player, PyromancerPlayer caster);
    void fireBlast(WizardPlayer player, PyromancerPlayer caster);

    void ignite(KnightPlayer player, PyromancerPlayer caster);
    void ignite(PyromancerPlayer player, PyromancerPlayer caster);
    void ignite(RoguePlayer player, PyromancerPlayer caster);
    void ignite(WizardPlayer player, PyromancerPlayer caster);

    void execute(KnightPlayer player, KnightPlayer caster);
    void execute(PyromancerPlayer player, KnightPlayer caster);
    void execute(RoguePlayer player, KnightPlayer caster);
    void execute(WizardPlayer player, KnightPlayer caster);

    void slam(KnightPlayer player, KnightPlayer caster);
    void slam(PyromancerPlayer player, KnightPlayer caster);
    void slam(RoguePlayer player, KnightPlayer caster);
    void slam(WizardPlayer player, KnightPlayer caster);

    void drain(KnightPlayer player, WizardPlayer caster);
    void drain(PyromancerPlayer player, WizardPlayer caster);
    void drain(RoguePlayer player, WizardPlayer caster);
    void drain(WizardPlayer player, WizardPlayer caster);

    void deflect(KnightPlayer player, WizardPlayer caster);
    void deflect(PyromancerPlayer player, WizardPlayer caster);
    void deflect(RoguePlayer player, WizardPlayer caster);
    void deflect(WizardPlayer player, WizardPlayer caster);

    void backStab(KnightPlayer player, RoguePlayer caster);
    void backStab(PyromancerPlayer player, RoguePlayer caster);
    void backStab(RoguePlayer player, RoguePlayer caster);
    void backStab(WizardPlayer player, RoguePlayer caster);

    void paralysis(KnightPlayer player, RoguePlayer caster);
    void paralysis(PyromancerPlayer player, RoguePlayer caster);
    void paralysis(RoguePlayer player, RoguePlayer caster);
    void paralysis(WizardPlayer player, RoguePlayer caster);
}
