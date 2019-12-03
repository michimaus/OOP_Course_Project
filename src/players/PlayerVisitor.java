package players;

public interface PlayerVisitor {
    void fireBlast(KnightPlayer player, int level, char land);
    void fireBlast(RoguePlayer player, int level, char land);
    void fireBlast(PyromancerPlayer player, int level, char land);
    void fireBlast(WizardPlayer player, int level, char land);

    void ignite(KnightPlayer player, int level, char land);
    void ignite(PyromancerPlayer player, int level, char land);
    void ignite(RoguePlayer player, int level, char land);
    void ignite(WizardPlayer player, int level, char land);

    void execute(KnightPlayer player, int level, char land);
    void execute(PyromancerPlayer player, int level, char land);
    void execute(RoguePlayer player, int level, char land);
    void execute(WizardPlayer player, int level, char land);

    void slam(KnightPlayer player, int level, char land);
    void slam(PyromancerPlayer player, int level, char land);
    void slam(RoguePlayer player, int level, char land);
    void slam(WizardPlayer player, int level, char land);

    void drain(KnightPlayer player, int level, char land);
    void drain(PyromancerPlayer player, int level, char land);
    void drain(RoguePlayer player, int level, char land);
    void drain(WizardPlayer player, int level, char land);

    void deflect(KnightPlayer player, int level, char land, WizardPlayer wizThis);
    void deflect(PyromancerPlayer player, int level, char land, WizardPlayer wizThis);
    void deflect(RoguePlayer player, int level, char land, WizardPlayer wizThis);
    void deflect(WizardPlayer player, int level, char land, WizardPlayer wizThis);

    void backStab(KnightPlayer player, int level, char land, int count);
    void backStab(PyromancerPlayer player, int level, char land, int count);
    void backStab(RoguePlayer player, int level, char land, int count);
    void backStab(WizardPlayer player, int level, char land, int count);

    void paralysis(KnightPlayer player, int level, char land);
    void paralysis(PyromancerPlayer player, int level, char land);
    void paralysis(RoguePlayer player, int level, char land);
    void paralysis(WizardPlayer player, int level, char land);
}
