package players;

public interface PlayerVisitor {

    public float fireBlast(KnightPlayer player, int level, char land);
    public float fireBlast(RoguePlayer player, int level, char land);
    public float fireBlast(PyromancerPlayer player, int level, char land);
    public float fireBlast(WizardPlayer player, int level, char land);

    public float ignite(KnightPlayer player, int level, char land);
    public float ignite(PyromancerPlayer player, int level, char land);
    public float ignite(RoguePlayer player, int level, char land);
    public float ignite(WizardPlayer player, int level, char land);

    public float execute(KnightPlayer player, int level, char land);
    public float execute(PyromancerPlayer player, int level, char land);
    public float execute(RoguePlayer player, int level, char land);
    public float execute(WizardPlayer player, int level, char land);

    public float slam(KnightPlayer player, int level, char land);
    public float slam(PyromancerPlayer player, int level, char land);
    public float slam(RoguePlayer player, int level, char land);
    public float slam(WizardPlayer player, int level, char land);

    public float drain(KnightPlayer player, int level, char land);
    public float drain(PyromancerPlayer player, int level, char land);
    public float drain(RoguePlayer player, int level, char land);
    public float drain(WizardPlayer player, int level, char land);

    public float deflect(KnightPlayer player, int level, char land, WizardPlayer wizThis);
    public float deflect(PyromancerPlayer player, int level, char land, WizardPlayer wizThis);
    public float deflect(RoguePlayer player, int level, char land, WizardPlayer wizThis);
    public float deflect(WizardPlayer player, int level, char land, WizardPlayer wizThis);

    public float backStab(KnightPlayer player, int level, char land, int count);
    public float backStab(PyromancerPlayer player, int level, char land, int count);
    public float backStab(RoguePlayer player, int level, char land, int count);
    public float backStab(WizardPlayer player, int level, char land, int count);

    public float paralysis(KnightPlayer player, int level, char land);
    public float paralysis(PyromancerPlayer player, int level, char land);
    public float paralysis(RoguePlayer player, int level, char land);
    public float paralysis(WizardPlayer player, int level, char land);
}
