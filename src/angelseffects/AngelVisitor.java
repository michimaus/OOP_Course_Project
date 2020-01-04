package angelseffects;

import players.KnightPlayer;
import players.PyromancerPlayer;
import players.RoguePlayer;
import players.WizardPlayer;
import players.StandardPlayer;

/**
 * Signatures for the methods of all the effects.
 * Particularly implementations for each case-interction between an angel and a hero.
 */


public interface AngelVisitor {
    void effectDamageAngel(KnightPlayer player);
    void effectDamageAngel(PyromancerPlayer player);
    void effectDamageAngel(WizardPlayer player);
    void effectDamageAngel(RoguePlayer player);

    void effectDarkAngel(KnightPlayer player);
    void effectDarkAngel(PyromancerPlayer player);
    void effectDarkAngel(WizardPlayer player);
    void effectDarkAngel(RoguePlayer player);

    void effectDracula(KnightPlayer player);
    void effectDracula(PyromancerPlayer player);
    void effectDracula(WizardPlayer player);
    void effectDracula(RoguePlayer player);

    void effectGoodBoy(KnightPlayer player);
    void effectGoodBoy(PyromancerPlayer player);
    void effectGoodBoy(WizardPlayer player);
    void effectGoodBoy(RoguePlayer player);

    void effectLevelUpAngel(KnightPlayer player);
    void effectLevelUpAngel(PyromancerPlayer player);
    void effectLevelUpAngel(WizardPlayer player);
    void effectLevelUpAngel(RoguePlayer player);

    void effectLifeGiver(KnightPlayer player);
    void effectLifeGiver(PyromancerPlayer player);
    void effectLifeGiver(WizardPlayer player);
    void effectLifeGiver(RoguePlayer player);

    void effectSmallAngel(KnightPlayer player);
    void effectSmallAngel(PyromancerPlayer player);
    void effectSmallAngel(WizardPlayer player);
    void effectSmallAngel(RoguePlayer player);

    void effectSpawner(KnightPlayer player);
    void effectSpawner(PyromancerPlayer player);
    void effectSpawner(WizardPlayer player);
    void effectSpawner(RoguePlayer player);

    void effectTheDoomer(StandardPlayer player);

    void effectXpAngel(KnightPlayer player);
    void effectXpAngel(PyromancerPlayer player);
    void effectXpAngel(WizardPlayer player);
    void effectXpAngel(RoguePlayer player);
}
