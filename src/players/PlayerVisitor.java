package players;

public interface PlayerVisitor {
    public void fireBlast(KnightPlayer player);
    public void fireBlast(RoguePlayer player);
    public void fireBlast(PyromancerPlayer player);
    public void fireBlast(WizardPlayer player);

    public void ignite(KnightPlayer player);
    public void ignite(PyromancerPlayer player);
    public void ignite(RoguePlayer player);
    public void ignite(WizardPlayer player);

    public void execute(KnightPlayer player);
    public void execute(PyromancerPlayer player);
    public void execute(RoguePlayer player);
    public void execute(WizardPlayer player);

    public void slam(KnightPlayer player);
    public void slam(PyromancerPlayer player);
    public void slam(RoguePlayer player);
    public void slam(WizardPlayer player);

    public void drain(KnightPlayer player);
    public void drain(PyromancerPlayer player);
    public void drain(RoguePlayer player);
    public void drain(WizardPlayer player);

    public void deflect(KnightPlayer player);
    public void deflect(PyromancerPlayer player);
    public void deflect(RoguePlayer player);
    public void deflect(WizardPlayer player);

    public void backStab(KnightPlayer player);
    public void backStab(PyromancerPlayer player);
    public void backStab(RoguePlayer player);
    public void backStab(WizardPlayer player);

    public void paralysis(KnightPlayer player);
    public void paralysis(PyromancerPlayer player);
    public void paralysis(RoguePlayer player);
    public void paralysis(WizardPlayer player);
}
