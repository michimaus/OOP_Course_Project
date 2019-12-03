package players;

import common.Constants;

import java.util.concurrent.CopyOnWriteArrayList;

public class Spells implements PlayerVisitor {

    private float baseFireBlast(StandardPlayer player, int level, char land) {
        float damage = Constants.FIREBLAST + level * Constants.FIREBLAST_LEVEL_BONUS;

        if (land == 'V') {
            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        return damage;
    }

    @Override
    public float fireBlast(KnightPlayer player, int level, char land) {
        int damage = Math.round(baseFireBlast(player, level, land) * Constants.FIREBLAST_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float fireBlast(RoguePlayer player, int level, char land) {
        int damage = Math.round(baseFireBlast(player, level, land) * Constants.FIREBLAST_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float fireBlast(PyromancerPlayer player, int level, char land) {
        int damage = Math.round(baseFireBlast(player, level, land) * Constants.FIREBLAST_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float fireBlast(WizardPlayer player, int level, char land) {
        // AIICICIAI
        int damage = Math.round(baseFireBlast(player, level, land) * Constants.FIREBLAST_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    private float baseIgnite(StandardPlayer player, int level, char land) {
        float damage = Constants.IGNITE + level * Constants.IGNITE_LEVEL_BONUS;
        if (land == 'V') {
            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        return damage;
    }

    @Override
    public float ignite(KnightPlayer player, int level, char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        
        player.getDot(0, Constants.IGNITE_TIME,
                Math.round((Constants.IGNITE_OVERTIME + level * Constants.IGNITE_OVERTIME_BONUS) *
                        Constants.IGNITE_KNIGHT_BONUS));
        return 0;
    }

    @Override
    public float ignite(PyromancerPlayer player, int level, char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(0, Constants.IGNITE_TIME,
                Math.round((Constants.IGNITE_OVERTIME + level * Constants.IGNITE_OVERTIME_BONUS) *
                        Constants.IGNITE_PYROMANCER_BONUS));
        return 0;
    }

    @Override
    public float ignite(RoguePlayer player, int level, char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(0, Constants.IGNITE_TIME,
                Math.round((Constants.IGNITE_OVERTIME + level * Constants.IGNITE_OVERTIME_BONUS) *
                        Constants.IGNITE_ROGUE_BONUS));
        return 0;
    }

    @Override
    public float ignite(WizardPlayer player, int level, char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(0, Constants.IGNITE_TIME,
                Math.round((Constants.IGNITE_OVERTIME + level * Constants.IGNITE_OVERTIME_BONUS) *
                        Constants.IGNITE_WIZARD_BONUS));
        return 0;
    }

    private float baseExecute(StandardPlayer player, int level, char land) {
        float procent = Constants.BASE_EXECUTE_PROCENT + level * Constants.BONUS_EXECUTE_PROCENT;
        if (procent > Constants.MAX_EXECUTE_PROCENT)
            procent = Constants.MAX_EXECUTE_PROCENT;

        if ((float) player.getCurrentHp() / (float) player.getMaxHp() < procent) {
            player.setIncomingDamage(player.getIncomingDamage() + player.getCurrentHp());
            return 0;
        } else {
            if (land == 'L') {
                return (float) (Constants.EXECUTE + Constants.EXECUTE_LEVEL_BONUS * level) * Constants.LAND_KNIGHT_BONUS;
            } else {
                return (Constants.EXECUTE + Constants.EXECUTE_LEVEL_BONUS * level);
            }
        }
    }

    @Override
    public float execute(KnightPlayer player, int level, char land) {
        int damage = Math.round(baseExecute(player, level, land));
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float execute(PyromancerPlayer player, int level, char land) {
        int damage = Math.round(baseExecute(player, level, land) * Constants.EXECUTE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float execute(RoguePlayer player, int level, char land) {
        int damage = Math.round(baseExecute(player, level, land) * Constants.EXECUTE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float execute(WizardPlayer player, int level, char land) {
        int damage = Math.round(baseExecute(player, level, land) * Constants.EXECUTE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    private float baseSlam(StandardPlayer player, int level, char land) {
        float damage = Constants.SLAM + level * Constants.SLAM_LEVEL_BONUS;
        player.getDot(1, 0, 0);
        if (land == 'L') {
            return damage * Constants.LAND_KNIGHT_BONUS;
        }
        return damage;
    }

    @Override
    public float slam(KnightPlayer player, int level, char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float slam(PyromancerPlayer player, int level, char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float slam(RoguePlayer player, int level, char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float slam(WizardPlayer player, int level, char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    private float baseDrain(StandardPlayer player, int level, char land) {
        float percent = Constants.DRAIN + level * Constants.DRAIN_LEVEL_BONUS;
        float damage;
        if ((float) player.getCurrentHp() < (float) player.getMaxHp() * Constants.DRAIN_PERCENT_BONUS) {
            damage = percent * player.getCurrentHp();
        } else {
            damage = percent * player.getMaxHp() * Constants.DRAIN_PERCENT_BONUS;
        }

        if (land == 'D') {
            return damage * Constants.LAND_WIZARD_BONUS;
        }
        return damage;
    }

    @Override
    public float drain(KnightPlayer player, int level, char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);

        return 0;
    }

    @Override
    public float drain(PyromancerPlayer player, int level, char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float drain(RoguePlayer player, int level, char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float drain(WizardPlayer player, int level, char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    private float baseDeflect(int level, char land) {
        float percent = Constants.DEFLECT + level * Constants.DEFLECT_LEVEL_BONUS;
        if (percent > Constants.DEFLECT_MAX_PERCENT)
            percent = Constants.DEFLECT_MAX_PERCENT;
        if (land == 'D') {
            percent *= Constants.LAND_WIZARD_BONUS;
        }
        return percent;
    }

    @Override
    public float deflect(KnightPlayer player, int level, char land, WizardPlayer wizThis) {
        float damage = baseSlam(wizThis, player.getLevel(), land);
        damage = Math.round(damage);
        damage += baseExecute(wizThis, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);
        player.setIncomingDamage(player.getIncomingDamage() +
                Math.round(damage * percent * Constants.DEFLECT_KNIGHT_BONUS));
        return 0;
    }

    @Override
    public float deflect(PyromancerPlayer player, int level, char land, WizardPlayer wizThis) {
        float damage = baseFireBlast(wizThis, player.getLevel(), land);
        damage = Math.round(damage);
        damage += baseIgnite(wizThis, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);

        player.setIncomingDamage(player.getIncomingDamage() +
                Math.round(damage * percent * Constants.DEFLECT_PYROMANCER_BONUS));
        return 0;
    }

    @Override
    public float deflect(RoguePlayer player, int level, char land, WizardPlayer wizThis) {
//        System.out.println(player.getBackStabCount() + "agsjhasjdksadnasnd");
        float damage = 0;
        if ((player.isHasAtacked() && player.getBackStabCount() == 0) || (!player.isHasAtacked() && player.getBackStabCount() == 2)) {
            damage = baseBackStab(wizThis, player.getLevel(), land, Constants.BACKSTAB_CRIT_TIME);
        } else {
            damage = baseBackStab(wizThis, player.getLevel(), land, 0);
        }
        damage = Math.round(damage);
        int [] count = new int[1];
        damage += baseParalysis(count, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);

        player.setIncomingDamage(player.getIncomingDamage() +
                Math.round(damage * percent * Constants.DEFLECT_ROGUE_BONUS));

        return 0;
    }

    @Override
    public float deflect(WizardPlayer player, int level, char land, WizardPlayer wizThis) {

        return 0;
    }

    private float baseBackStab(StandardPlayer player, int level, char land, int count) {
        float damage = Constants.BACKSTAB + level * Constants.BACKSTAB_LEVEL_BONUS;
        if (count == Constants.BACKSTAB_CRIT_TIME && land == 'W') {
            damage *= Constants.BACKSTAB_CRITICAL;
        }

        if (land == 'W') {
            return damage * Constants.LAND_ROGUE_BONUS;
        }
        return damage;
    }

    @Override
    public float backStab(KnightPlayer player, int level, char land, int count) {
        int damage = Math.round(baseBackStab(player, level, land, count) * Constants.BACKSTAB_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float backStab(PyromancerPlayer player, int level, char land, int count) {
        int damage = Math.round(baseBackStab(player, level, land, count) * Constants.BACKSTAB_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float backStab(RoguePlayer player, int level, char land, int count) {
        int damage = Math.round(baseBackStab(player, level, land, count) * Constants.BACKSTAB_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    @Override
    public float backStab(WizardPlayer player, int level, char land, int count) {
        // modify this
        int damage = Math.round(baseBackStab(player, level, land, count) * Constants.BACKSTAB_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        return 0;
    }

    private float baseParalysis(int[] count, int level, char land) {
        float damage = Constants.PARALYSIS + level * Constants.PARALYSIS_LEVEL_BONUS;
        count[0] = 3;
        if (land == 'W') {
            count[0] = 6;
            return damage * Constants.LAND_ROGUE_BONUS;
        }
        return damage;
    }

    @Override
    public float paralysis(KnightPlayer player, int level, char land) {
        int [] count  = new int[1];
        int damage = Math.round(baseParalysis(count, level, land) * Constants.PARALYSIS_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(count[0], count[0], damage);
        return 0;
    }

    @Override
    public float paralysis(PyromancerPlayer player, int level, char land) {
        int [] count  = new int[1];
        int damage = Math.round(baseParalysis(count, level, land) * Constants.PARALYSIS_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(count[0], count[0], damage);
        return 0;
    }

    @Override
    public float paralysis(RoguePlayer player, int level, char land) {
        int [] count  = new int[1];
        int damage = Math.round(baseParalysis(count, level, land) * Constants.PARALYSIS_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(count[0], count[0], damage);
        return 0;
    }

    @Override
    public float paralysis(WizardPlayer player, int level, char land) {
        int [] count  = new int[1];
        int damage = Math.round(baseParalysis(count, level, land) * Constants.PARALYSIS_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.getDot(count[0], count[0], damage);
        return 0;
    }
}
