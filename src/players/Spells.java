package players;

import common.Constants;

public class Spells implements PlayerVisitor {

    @Override
    public float fireBlast(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float fireBlast(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float fireBlast(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float fireBlast(WizardPlayer player, int level) {
        return 0;
    }

    @Override
    public float ignite(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float ignite(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float ignite(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float ignite(WizardPlayer player, int level) {
        return 0;
    }

    private int baseExecute(int maxHp, int currentHp, int level) {
        float procent = (float) (level + Constants.EXECUTE_PROCENT);
        float currentProcent = ((float) currentHp / (float) maxHp) * Constants.ONE_HUNDRED;
        if (procent > Constants.MAX_EXECUTE_PROCENT)
            procent = Constants.MAX_EXECUTE_PROCENT;
        if (procent >= currentProcent) {
            return -1;
        } else {
            return Constants.EXECUTE_BASE_DAMAGE + level * Constants.ADD_EXECUTE_DAMAGE;
        }
    }

    @Override
    public float execute(KnightPlayer player, int level) {
        int baseDamage = baseExecute(player.getMaxHp(), player.getCurrentHp(), level);
        return (float) baseDamage;
    }

    @Override
    public float execute(PyromancerPlayer player, int level) {
        int baseDamage = baseExecute(player.getMaxHp(), player.getCurrentHp(), level);
        if (baseDamage == -1){
            return (float) baseDamage;
        } else {
            return ((float) baseDamage +
                    (Constants.EXECUTE_PROCENT_PYROMANCER * (float) baseDamage) / Constants.ONE_HUNDRED);
        }
    }

    @Override
    public float execute(RoguePlayer player, int level) {
        int baseDamage = baseExecute(player.getMaxHp(), player.getCurrentHp(), level);
        if (baseDamage == -1){
            return (float) baseDamage;
        } else {
            return ((float) baseDamage +
                    (Constants.EXECUTE_PROCENT_ROGUE * (float) baseDamage) / Constants.ONE_HUNDRED);
        }
    }

    @Override
    public float execute(WizardPlayer player, int level) {
        int baseDamage = baseExecute(player.getMaxHp(), player.getCurrentHp(), level);
        if (baseDamage == -1){
            return (float) baseDamage;
        } else {
            return ((float) baseDamage -
                    (Constants.EXECUTE_PROCENT_WIZARD * (float) baseDamage) / Constants.ONE_HUNDRED);
        }
    }

    @Override
    public float slam(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float slam(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float slam(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float slam(WizardPlayer player, int level) {
        return 0;
    }

    @Override
    public float drain(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float drain(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float drain(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float drain(WizardPlayer player, int level) {
        return 0;
    }

    @Override
    public float deflect(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float deflect(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float deflect(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float deflect(WizardPlayer player, int level) {
        return 0;
    }

    @Override
    public float backStab(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float backStab(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float backStab(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float backStab(WizardPlayer player, int level) {
        return 0;
    }

    @Override
    public float paralysis(KnightPlayer player, int level) {
        return 0;
    }

    @Override
    public float paralysis(PyromancerPlayer player, int level) {
        return 0;
    }

    @Override
    public float paralysis(RoguePlayer player, int level) {
        return 0;
    }

    @Override
    public float paralysis(WizardPlayer player, int level) {
        return 0;
    }
}
