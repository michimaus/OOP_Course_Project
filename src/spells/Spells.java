package spells;

import common.Constants;
import players.KnightPlayer;
import players.PyromancerPlayer;
import players.RoguePlayer;
import players.WizardPlayer;
import players.StandardPlayer;

public class Spells implements PlayerVisitor {

    /**
     * baseFireBlast.
     * @param caster = Pyromancer that is casting the spell
     * @return Tha base damage that the player is going to take.
     */

    private float baseFireBlast(final PyromancerPlayer caster) {
        float damage = Constants.FIREBLAST + caster.getLevel() * Constants.FIREBLAST_LEVEL_BONUS;
        if (caster.getPieceOfLand() == 'V') {
            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        return damage;
    }

    @Override
    public final void fireBlast(final KnightPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseFireBlast(caster)
                * Constants.FIREBLAST_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final RoguePlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseFireBlast(caster)
                * Constants.FIREBLAST_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final PyromancerPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseFireBlast(caster)
                * Constants.FIREBLAST_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void fireBlast(final WizardPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseFireBlast(caster)
                * Constants.FIREBLAST_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    /**
     * baseIgnite.
     * @param player = gets the effect of the Dot of the ability.
     * @param caster = Pyromancer that is casting the spell
     * @return The base damage that the player is going to take.
     */

    private float baseIgnite(final StandardPlayer player, final PyromancerPlayer caster) {
        float damage = Constants.IGNITE + caster.getLevel() * Constants.IGNITE_LEVEL_BONUS;

        if (caster.getPieceOfLand() == 'V') {
            player.getDot(0, Constants.IGNITE_TIME,
                    (Constants.IGNITE_OVERTIME + caster.getLevel()
                            * Constants.IGNITE_OVERTIME_BONUS) * Constants.LAND_PYROMANCER_BONUS);

            return damage * Constants.LAND_PYROMANCER_BONUS;
        }
        player.getDot(0, Constants.IGNITE_TIME, (Constants.IGNITE_OVERTIME
                + caster.getLevel() * Constants.IGNITE_OVERTIME_BONUS));
        return damage;
    }

    @Override
    public final void ignite(final KnightPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseIgnite(player, caster) * Constants.IGNITE_KNIGHT_BONUS);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_KNIGHT_BONUS));
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void ignite(final PyromancerPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseIgnite(player, caster)
                * Constants.IGNITE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_PYROMANCER_BONUS));
    }

    @Override
    public final void ignite(final RoguePlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseIgnite(player, caster) * Constants.IGNITE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_ROGUE_BONUS));

    }

    @Override
    public final void ignite(final WizardPlayer player, final PyromancerPlayer caster) {
        int damage = Math.round(baseIgnite(player, caster) * Constants.IGNITE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.IGNITE_WIZARD_BONUS));

    }

    /**
     * baseExecute.
     * @param player = needs to get that percent of the remaining life in order to apply effects.
     * @param caster = Knight that is cansi=ting the spell
     * @return  The base damage that the player is going to take.
     */

    private float baseExecute(final StandardPlayer player, final KnightPlayer caster) {
        float procent = Constants.BASE_EXECUTE_PROCENT + caster.getLevel()
                * Constants.BONUS_EXECUTE_PROCENT;
        if (procent > Constants.MAX_EXECUTE_PROCENT) {
            procent = Constants.MAX_EXECUTE_PROCENT;
        }

        if ((float) player.getCurrentHp() / (float) player.getMaxHp() < procent) {
            player.setIncomingDamage(player.getIncomingDamage() + player.getCurrentHp());
            return 0;
        } else {
            if (caster.getPieceOfLand() == 'L') {
                return (float) (Constants.EXECUTE
                        + Constants.EXECUTE_LEVEL_BONUS * caster.getLevel())
                        * Constants.LAND_KNIGHT_BONUS;
            } else {
                return (Constants.EXECUTE + Constants.EXECUTE_LEVEL_BONUS * caster.getLevel());
            }
        }
    }

    @Override
    public final void execute(final KnightPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseExecute(player, caster));
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final PyromancerPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseExecute(player, caster)
                * Constants.EXECUTE_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final RoguePlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseExecute(player, caster) * Constants.EXECUTE_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void execute(final WizardPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseExecute(player, caster) * Constants.EXECUTE_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    /**
     * baseSlam.
     * @param player = gets the effect of the Dot of the ability.
     * @param caster = knight casting the spell
     * @return The base damage that the player is going to take.
     */

    private float baseSlam(final StandardPlayer player, final KnightPlayer caster) {
        float damage = Constants.SLAM + caster.getLevel() * Constants.SLAM_LEVEL_BONUS;
        player.getDot(1, 0, 0);
        if (caster.getPieceOfLand() == 'L') {
            return damage * Constants.LAND_KNIGHT_BONUS;
        }
        return damage;
    }

    @Override
    public final void slam(final KnightPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseSlam(player, caster) * Constants.SLAM_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final PyromancerPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseSlam(player, caster) * Constants.SLAM_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final RoguePlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseSlam(player, caster) * Constants.SLAM_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void slam(final WizardPlayer player, final KnightPlayer caster) {
        int damage = Math.round(baseSlam(player, caster) * Constants.SLAM_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    /**
     * baseDrain.
     * @param player = needs to get that percent of the remaining life in order to apply effects.
     * @param caster = Wizard that is casting the spell
     * @return The base damage that the player is going to take.
     */

    private float baseDrain(final StandardPlayer player, final WizardPlayer caster) {
        float percent = Constants.DRAIN + caster.getLevel() * Constants.DRAIN_LEVEL_BONUS;
        float damage;
        if ((float) player.getCurrentHp() < (float) player.getMaxHp()
                * Constants.DRAIN_PERCENT_BONUS) {
            damage = percent * player.getCurrentHp();
        } else {
            damage = percent * player.getMaxHp() * Constants.DRAIN_PERCENT_BONUS;
        }

        if (caster.getPieceOfLand() == 'D') {
            return damage * Constants.LAND_WIZARD_BONUS;
        }
        return damage;
    }

    @Override
    public final void drain(final KnightPlayer player, final WizardPlayer caster) {
        int damage = Math.round(baseDrain(player, caster) * Constants.DRAIN_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);

    }

    @Override
    public final void drain(final PyromancerPlayer player, final WizardPlayer caster) {
        int damage = Math.round(baseDrain(player, caster) * Constants.DRAIN_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void drain(final RoguePlayer player, final WizardPlayer caster) {
        int damage = Math.round(baseDrain(player, caster) * Constants.DRAIN_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void drain(final WizardPlayer player, final WizardPlayer caster) {
        int damage = Math.round(baseDrain(player, caster) * Constants.DRAIN_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    /**
     * baseDeflect.
     * @param caster = Wizard that is deflecting the damage
     * @return The base damage that the player is going to take.
     */

    private float baseDeflect(final WizardPlayer caster) {
        float percent = Constants.DEFLECT + caster.getLevel() * Constants.DEFLECT_LEVEL_BONUS;
        if (percent > Constants.DEFLECT_MAX_PERCENT) {
            percent = Constants.DEFLECT_MAX_PERCENT;
        }
        if (caster.getPieceOfLand() == 'D') {
            percent *= Constants.LAND_WIZARD_BONUS;
        }
        return percent;
    }

    @Override
    public final void deflect(final KnightPlayer player, final WizardPlayer caster) {
        float damage = baseSlam(caster, player);
        damage = Math.round(damage);
        damage += baseExecute(caster, player);
        damage = Math.round(damage);

        float percent = baseDeflect(caster);
        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_KNIGHT_BONUS));
    }

    @Override
    public final void deflect(final PyromancerPlayer player, final WizardPlayer caster) {
        float damage = baseFireBlast(player);
        damage = Math.round(damage);
        damage += baseIgnite(caster, player);
        damage = Math.round(damage);

        float percent = baseDeflect(caster);

        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_PYROMANCER_BONUS));
    }

    @Override
    public final void deflect(final RoguePlayer player, final WizardPlayer caster) {
        float damage;
        if ((player.isHasAttacked() && player.getBackStabCount() == 0
                && player.getPieceOfLand() == 'W')
                || (!player.isHasAttacked() && player.getBackStabCount() == 2
                && player.getPieceOfLand() == 'W')) {
            damage = baseBackStab(player) * Constants.BACKSTAB_CRITICAL;
        } else {
            damage = baseBackStab(player);
        }

        damage = Math.round(damage);
        damage += baseParalysis(caster, player);
        damage = Math.round(damage);

        float percent = baseDeflect(caster);

        player.setIncomingDamage(player.getIncomingDamage()
                + Math.round(damage * percent * Constants.DEFLECT_ROGUE_BONUS));

    }

    @Override
    public final void deflect(final WizardPlayer player, final WizardPlayer caster) {

    }

    /**
     * baseBackStab.
     * @param caster = the rogue that is applying the backstab
     * @return The base damage that the player is going to take.
     */

    private float baseBackStab(final RoguePlayer caster) {
        float damage = Constants.BACKSTAB + caster.getLevel() * Constants.BACKSTAB_LEVEL_BONUS;
        if (caster.getBackStabCount() == Constants.BACKSTAB_CRIT_TIME
                && caster.getPieceOfLand() == 'W') {
            damage *= Constants.BACKSTAB_CRITICAL;
        }

        if (caster.getPieceOfLand() == 'W') {
            return damage * Constants.LAND_ROGUE_BONUS;
        }
        return damage;
    }

    @Override
    public final void backStab(final KnightPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseBackStab(caster)
                * Constants.BACKSTAB_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final PyromancerPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseBackStab(caster)
                * Constants.BACKSTAB_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final RoguePlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseBackStab(caster) * Constants.BACKSTAB_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    @Override
    public final void backStab(final WizardPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseBackStab(caster)
                * Constants.BACKSTAB_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
    }

    /**
     * baseParalysis.
     * @param player = gets the effect of the DoT.
     * @param caster = the rogue that is applying the DoT
     * @return The base damage that the player is going to take.
     */

    private float baseParalysis(final StandardPlayer player, final RoguePlayer caster) {
        float damage = Constants.PARALYSIS + caster.getLevel() * Constants.PARALYSIS_LEVEL_BONUS;
        if (caster.getPieceOfLand() == 'W') {
            player.getDot(Constants.PARALYSIS_TIME_BONUS, Constants.PARALYSIS_TIME_BONUS,
                    damage * Constants.LAND_ROGUE_BONUS);
            return damage * Constants.LAND_ROGUE_BONUS;
        }
        player.getDot(Constants.PARALYSIS_TIME, Constants.PARALYSIS_TIME, damage);
        return damage;
    }

    @Override
    public final void paralysis(final KnightPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseParalysis(player, caster)
                * Constants.PARALYSIS_KNIGHT_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_KNIGHT_BONUS));
    }

    @Override
    public final void paralysis(final PyromancerPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseParalysis(player, caster)
                * Constants.PARALYSIS_PYROMANCER_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage()
                * Constants.PARALYSIS_PYROMANCER_BONUS));

    }

    @Override
    public final void paralysis(final RoguePlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseParalysis(player, caster)
                * Constants.PARALYSIS_ROGUE_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_ROGUE_BONUS));

    }

    @Override
    public final void paralysis(final WizardPlayer player, final RoguePlayer caster) {
        int damage = Math.round(baseParalysis(player, caster)
                * Constants.PARALYSIS_WIZARD_BONUS);
        player.setIncomingDamage(player.getIncomingDamage() + damage);
        player.setDotDamage(Math.round(player.getDotDamage() * Constants.PARALYSIS_WIZARD_BONUS));
    }
}
