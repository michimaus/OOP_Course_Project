package players;

import common.Constants;

public class Spells implements PlayerVisitor {

    private float baseFireBlast(final int level, final char land) {
        float damage = Constants.FIREBLAST + level * Constants.FIREBLAST_LEVEL_BONUS;
        if (land == 'V') {
            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        return damage;
    }

    @Override
    public final void fireBlast(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseFireBlast(level, land)
                * Constants.FIREBLAST_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseFireBlast(level, land)
                * Constants.FIREBLAST_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseFireBlast(level, land)
                * Constants.FIREBLAST_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseFireBlast(level, land)
                * Constants.FIREBLAST_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    private float baseIgnite(final StandardPlayer player, final int level, final char land) {
        float damage = Constants.IGNITE + level * Constants.IGNITE_LEVEL_BONUS;

        if (land == 'V') {
            player.getDot(0, Constants.IGNITE_TIME,
                    (Constants.IGNITE_OVERTIME + level
                            * Constants.IGNITE_OVERTIME_BONUS) * Constants.LAND_PYROMANCER_BONUS);

            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        player.getDot(0, Constants.IGNITE_TIME, (Constants.IGNITE_OVERTIME + level
                * Constants.IGNITE_OVERTIME_BONUS));
        return damage;
    }

    @Override
    public final void ignite(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_KNIGHT_BONUS);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_KNIGHT_BONUS));
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void ignite(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseIgnite(player, level, land)
                * Constants.IGNITE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_PYROMANCER_BONUS));
    }

    @Override
    public final void ignite(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_ROGUE_BONUS));

    }

    @Override
    public final void ignite(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseIgnite(player, level, land) * Constants.IGNITE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_WIZARD_BONUS));

    }

    private float baseExecute(final StandardPlayer player, final int level, final char land) {
        float procent = Constants.BASE_EXECUTE_PROCENT + level * Constants.BONUS_EXECUTE_PROCENT;
        if (procent > Constants.MAX_EXECUTE_PROCENT) {
            procent = Constants.MAX_EXECUTE_PROCENT;
        }

        if ((float) player.getCurrentHp() / (float) player.getMaxHp() < procent) {
            player.setIncomingDamage(player.getIncomingDamage() + player.getCurrentHp());
            return 0;
        } else {
            if (land == 'L') {
                return (float) (Constants.EXECUTE + Constants.EXECUTE_LEVEL_BONUS * level)
                        * Constants.LAND_KNIGHT_BONUS;
            } else {
                return (Constants.EXECUTE + Constants.EXECUTE_LEVEL_BONUS * level);
            }
        }
    }

    @Override
    public final void execute(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseExecute(player, level, land));
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseExecute(player, level, land)
                * Constants.EXECUTE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseExecute(player, level, land) * Constants.EXECUTE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseExecute(player, level, land) * Constants.EXECUTE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    private float baseSlam(final StandardPlayer player, final int level, final char land) {
        float damage = Constants.SLAM + level * Constants.SLAM_LEVEL_BONUS;
        player.getDot(1, 0, 0);
        if (land == 'L') {
            return damage * Constants.LAND_KNIGHT_BONUS;
        }
        return damage;
    }

    @Override
    public final void slam(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseSlam(player, level, land) * Constants.SLAM_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    private float baseDrain(final StandardPlayer player, final int level, final char land) {
        float percent = Constants.DRAIN + level * Constants.DRAIN_LEVEL_BONUS;
        float damage;
        if ((float) player.getCurrentHp() < (float) player.getMaxHp()
                * Constants.DRAIN_PERCENT_BONUS) {
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
    public final void drain(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);

    }

    @Override
    public final void drain(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void drain(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void drain(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseDrain(player, level, land) * Constants.DRAIN_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    private float baseDeflect(final int level, final char land) {
        float percent = Constants.DEFLECT + level * Constants.DEFLECT_LEVEL_BONUS;
        if (percent > Constants.DEFLECT_MAX_PERCENT) {
            percent = Constants.DEFLECT_MAX_PERCENT;
        }
        if (land == 'D') {
            percent *= Constants.LAND_WIZARD_BONUS;
        }
        return percent;
    }

    @Override
    public final void deflect(final KnightPlayer player, final int level,
                              final char land, final WizardPlayer wizThis) {
        float damage = baseSlam(wizThis, player.getLevel(), land);
        damage = Math.round(damage);
        damage += baseExecute(wizThis, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);
        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_KNIGHT_BONUS));
    }

    @Override
    public final void deflect(final PyromancerPlayer player, final int level,
                              final char land, final WizardPlayer wizThis) {
        float damage = baseFireBlast(player.getLevel(), land);
        damage = Math.round(damage);
        damage += baseIgnite(wizThis, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);

        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_PYROMANCER_BONUS));
    }

    @Override
    public final void deflect(final RoguePlayer player, final int level,
                              final char land, final WizardPlayer wizThis) {
        float damage;
        if ((player.isHasAtacked() && player.getBackStabCount() == 0)
                || (!player.isHasAtacked() && player.getBackStabCount() == 2)) {
            damage = baseBackStab(player.getLevel(), land, Constants.BACKSTAB_CRIT_TIME);
        } else {
            damage = baseBackStab(player.getLevel(), land, 0);
        }
        damage = Math.round(damage);
        damage += baseParalysis(wizThis, player.getLevel(), land);
        damage = Math.round(damage);

        float percent = baseDeflect(level, land);

        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_ROGUE_BONUS));

    }

    @Override
    public final void deflect(final WizardPlayer player, final int level, final char land,
                              final WizardPlayer wizThis) {

    }

    private float baseBackStab(final int level, final char land, final int count) {
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
    public final void backStab(final KnightPlayer player, final int level,
                               final char land, final int count) {
        int damage = Math.round(baseBackStab(level, land, count)
                * Constants.BACKSTAB_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final PyromancerPlayer player, final int level, final char land,
                               final int count) {
        int damage = Math.round(baseBackStab(level, land, count)
                * Constants.BACKSTAB_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final RoguePlayer player, final int level, final char land,
                               final int count) {
        int damage = Math.round(baseBackStab(level, land, count) * Constants.BACKSTAB_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final WizardPlayer player, final int level, final char land,
                               final int count) {
        int damage = Math.round(baseBackStab(level, land, count)
                * Constants.BACKSTAB_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    private float baseParalysis(final StandardPlayer player, final int level, final char land) {
        float damage = Constants.PARALYSIS + level * Constants.PARALYSIS_LEVEL_BONUS;
        if (land == 'W') {
            player.getDot(Constants.PARALYSIS_TIME_BONUS, Constants.PARALYSIS_TIME_BONUS,
                    damage * Constants.LAND_ROGUE_BONUS);
            return damage * Constants.LAND_ROGUE_BONUS;
        }
        player.getDot(Constants.PARALYSIS_TIME, Constants.PARALYSIS_TIME, damage);
        return damage;
    }

    @Override
    public final void paralysis(final KnightPlayer player, final int level, final char land) {
        int damage = Math.round(baseParalysis(player, level, land)
                * Constants.PARALYSIS_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_KNIGHT_BONUS));
    }

    @Override
    public final void paralysis(final PyromancerPlayer player, final int level, final char land) {
        int damage = Math.round(baseParalysis(player, level, land)
                * Constants.PARALYSIS_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage()
                * Constants.PARALYSIS_PYROMANCER_BONUS));

    }

    @Override
    public final void paralysis(final RoguePlayer player, final int level, final char land) {
        int damage = Math.round(baseParalysis(player, level, land)
                * Constants.PARALYSIS_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_ROGUE_BONUS));

    }

    @Override
    public final void paralysis(final WizardPlayer player, final int level, final char land) {
        int damage = Math.round(baseParalysis(player, level, land)
                * Constants.PARALYSIS_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_WIZARD_BONUS));
    }
}
