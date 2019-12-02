package players;

public interface PlayerVisitor {

    public float fireBlast(KnightPlayer player, int level);
    public float fireBlast(RoguePlayer player, int level);
    public float fireBlast(PyromancerPlayer player, int level);
    public float fireBlast(WizardPlayer player, int level);

    public float ignite(KnightPlayer player, int level);
    public float ignite(PyromancerPlayer player, int level);
    public float ignite(RoguePlayer player, int level);
    public float ignite(WizardPlayer player, int level);

    public float execute(KnightPlayer player, int level);
    public float execute(PyromancerPlayer player, int level);
    public float execute(RoguePlayer player, int level);
    public float execute(WizardPlayer player, int level);

    public float slam(KnightPlayer player, int level);
    public float slam(PyromancerPlayer player, int level);
    public float slam(RoguePlayer player, int level);
    public float slam(WizardPlayer player, int level);

    public float drain(KnightPlayer player, int level);
    public float drain(PyromancerPlayer player, int level);
    public float drain(RoguePlayer player, int level);
    public float drain(WizardPlayer player, int level);

    public float deflect(KnightPlayer player, int level);
    public float deflect(PyromancerPlayer player, int level);
    public float deflect(RoguePlayer player, int level);
    public float deflect(WizardPlayer player, int level);

    public float backStab(KnightPlayer player, int level);
    public float backStab(PyromancerPlayer player, int level);
    public float backStab(RoguePlayer player, int level);
    public float backStab(WizardPlayer player, int level);

    public float paralysis(KnightPlayer player, int level);
    public float paralysis(PyromancerPlayer player, int level);
    public float paralysis(RoguePlayer player, int level);
    public float paralysis(WizardPlayer player, int level);
}
