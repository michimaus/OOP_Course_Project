package common;

public final class Constants {
    private Constants() {
    }

    public static final int KNIGHT_HP = 900;
    public static final int PYROMANCE_HP = 500;
    public static final int WIZARD_HP = 400;
    public static final int ROGUE_HP = 600;

    public static final int KNIGHT_HP_ON_LEVEL = 80;
    public static final int PYROMANCE_HP_ON_LEVEL = 50;
    public static final int WIZARD_HP_ON_LEVEL = 30;
    public static final int ROGUE_HP_ON_LEVEL = 40;

    public static final int INIT_LEVEL = 250;
    public static final int ENCEREASE_LEVEL = 50;
    public static final int XP_UPPER_BOUND = 200;
    public static final int XP_INTERVAL = 40;

    public static final int NUMBER_SPLIT = 3;

    public static final float LAND_ROGUE_BONUS = 1.15f;
    public static final float LAND_KNIGHT_BONUS = 1.15f;
    public static final float LAND_PYROMANCER_BONUS = 1.25f;
    public static final float LAND_WIZARD_BONUS = 1.1f;

    public static final int FIREBLAST = 350;
    public static final int FIREBLAST_LEVEL_BONUS = 50;
    public static final float FIREBLAST_ROGUE_BONUS = 0.8f;
    public static final float FIREBLAST_KNIGHT_BONUS = 1.2f;
    public static final float FIREBLAST_PYROMANCER_BONUS = 0.9f;
    public static final float FIREBLAST_WIZARD_BONUS = 1.05f;

    public static final int IGNITE = 150;
    public static final int IGNITE_TIME = 2;
    public static final int IGNITE_LEVEL_BONUS = 20;
    public static final int IGNITE_OVERTIME = 50;
    public static final int IGNITE_OVERTIME_BONUS = 30;
    public static final float IGNITE_ROGUE_BONUS = 0.8f;
    public static final float IGNITE_KNIGHT_BONUS = 1.2f;
    public static final float IGNITE_PYROMANCER_BONUS = 0.9f;
    public static final float IGNITE_WIZARD_BONUS = 1.05f;

    public static final int EXECUTE = 200;
    public static final int EXECUTE_LEVEL_BONUS = 30;
    public static final float EXECUTE_ROGUE_BONUS = 1.15f;
    public static final float EXECUTE_PYROMANCER_BONUS = 1.1f;
    public static final float EXECUTE_WIZARD_BONUS = 0.8f;
    public static final float MAX_EXECUTE_PROCENT = 0.4f;
    public static final float BASE_EXECUTE_PROCENT = 0.2f;
    public static final float BONUS_EXECUTE_PROCENT = 0.01f;

    public static final int SLAM = 100;
    public static final int SLAM_LEVEL_BONUS = 40;
    public static final float SLAM_ROGUE_BONUS = 0.8f;
    public static final float SLAM_KNIGHT_BONUS = 1.2f;
    public static final float SLAM_PYROMANCER_BONUS = 0.9f;
    public static final float SLAM_WIZARD_BONUS = 1.05f;

    public static final int BACKSTAB = 200;
    public static final int BACKSTAB_CRIT_TIME = 3;
    public static final int BACKSTAB_LEVEL_BONUS = 20;
    public static final float BACKSTAB_CRITICAL = 1.5f;
    public static final float BACKSTAB_ROGUE_BONUS = 1.2f;
    public static final float BACKSTAB_KNIGHT_BONUS = 0.9f;
    public static final float BACKSTAB_PYROMANCER_BONUS = 1.25f;
    public static final float BACKSTAB_WIZARD_BONUS = 1.25f;

    public static final int PARALYSIS = 40;
    public static final int PARALYSIS_TIME = 3;
    public static final int PARALYSIS_TIME_BONUS = 6;
    public static final int PARALYSIS_LEVEL_BONUS = 10;
    public static final float PARALYSIS_ROGUE_BONUS = 0.9f;
    public static final float PARALYSIS_KNIGHT_BONUS = 0.8f;
    public static final float PARALYSIS_PYROMANCER_BONUS = 1.2f;
    public static final float PARALYSIS_WIZARD_BONUS = 1.25f;

    public static final float DEFLECT = 0.35f;
    public static final float DEFLECT_LEVEL_BONUS = 0.02f;
    public static final float DEFLECT_ROGUE_BONUS = 1.2f;
    public static final float DEFLECT_KNIGHT_BONUS = 1.4f;
    public static final float DEFLECT_PYROMANCER_BONUS = 1.3f;
    public static final float DEFLECT_MAX_PERCENT = 0.7f;

    public static final float DRAIN = 0.2f;
    public static final float DRAIN_LEVEL_BONUS = 0.05f;
    public static final float DRAIN_PERCENT_BONUS = 0.3f;
    public static final float DRAIN_ROGUE_BONUS = 0.8f;
    public static final float DRAIN_KNIGHT_BONUS = 1.2f;
    public static final float DRAIN_PYROMANCER_BONUS = 0.9f;
    public static final float DRAIN_WIZARD_BONUS = 1.05f;

    public static final float DAMAGE_ANGEL_KNIGHT = 0.15f;
    public static final float DAMAGE_ANGEL_PYROMANCER = 0.20f;
    public static final float DAMAGE_ANGEL_ROGUE = 0.30f;
    public static final float DAMAGE_ANGEL_WIZARD = 0.40f;

    public static final int DARK_ANGEL_KNIGHT = 40;
    public static final int DARK_ANGEL_PYROMANCER = 30;
    public static final int DARK_ANGEL_ROGUE = 10;
    public static final int DARK_ANGEL_WIZARD = 20;

    public static final float DRACULA_DAMAGE_KNIGHT = 0.20f;
    public static final float DRACULA_DAMAGE_PYROMANCER = 0.30f;
    public static final float DRACULA_DAMAGE_ROGUE = 0.10f;
    public static final float DRACULA_DAMAGE_WIZARD = 0.40f;
    public static final int DRACULA_HP_KNIGHT = 60;
    public static final int DRACULA_HP_PYROMANCER = 40;
    public static final int DRACULA_HP_ROGUE = 35;
    public static final int DRACULA_HP_WIZARD = 20;

    public static final float GOODBOY_DAMAGE_KNIGHT = 0.40f;
    public static final float GOODBOY_DAMAGE_PYROMANCER = 0.50f;
    public static final float GOODBOY_DAMAGE_ROGUE = 0.40f;
    public static final float GOODBOY_DAMAGE_WIZARD = 0.30f;
    public static final int GOODBOY_HP_KNIGHT = 20;
    public static final int GOODBOY_HP_PYROMANCER = 30;
    public static final int GOODBOY_HP_ROGUE = 40;
    public static final int GOODBOY_HP_WIZARD = 50;

    public static final float LEVELUP_ANGEL_KNIGHT = 0.10f;
    public static final float LEVELUP_ANGEL_PYROMANCER = 0.20f;
    public static final float LEVELUP_ANGEL_ROGUE = 0.15f;
    public static final float LEVELUP_ANGEL_WIZARD = 0.25f;

    public static final int LIFEGIVER_KNIGHT = 100;
    public static final int LIFEGIVER_PYROMANCER = 80;
    public static final int LIFEGIVER_ROGUE = 90;
    public static final int LIFEGIVER_WIZARD = 120;

    public static final float SMALL_ANGEL_DAMAGE_KNIGHT = 0.10f;
    public static final float SMALL_ANGEL_DAMAGE_PYROMANCER = 0.15f;
    public static final float SMALL_ANGEL_DAMAGE_ROGUE = 0.5f;
    public static final float SMALL_ANGEL_DAMAGE_WIZARD = 0.10f;
    public static final int SMALL_ANGEL_HP_KNIGHT = 10;
    public static final int SMALL_ANGEL_HP_PYROMANCER = 15;
    public static final int SMALL_ANGEL_HP_ROGUE = 20;
    public static final int SMALL_ANGEL_HP_WIZARD = 25;

    public static final int SPAWNER_KNIGHT = 200;
    public static final int SPAWNER_PYROMANCER = 150;
    public static final int SPAWNER_ROGUE = 180;
    public static final int SPAWNER_WIZARD = 120;

    public static final int XP_ANGEL_KNIGHT = 45;
    public static final int XP_ANGEL_PYROMANCER = 50;
    public static final int XP_ANGEL_ROGUE = 40;
    public static final int XP_ANGEL_WIZARD = 60;

    public static final int DEFENSIVE_KNIGHT = 3;
    public static final int DEFENSIVE_PYROMANCER = 4;
    public static final int DEFENSIVE_ROGUE = 7;
    public static final int DEFENSIVE_WIZARD = 4;
    public static final int AGRESIVE_KNIGHT = 2;
    public static final int AGRESIVE_PYROMANCER = 3;
    public static final int AGRESIVE_ROGUE = 5;
    public static final int AGRESIVE_WIZARD = 2;

    public static final int BONUS_HP_DEFENSIVE_KNIGHT = 4;
    public static final int BONUS_HP_DEFENSIVE_PYROMANCER = 3;
    public static final int BONUS_HP_DEFENSIVE_ROGUE = 2;
    public static final int BONUS_HP_DEFENSIVE_WIZARD = 5;
    public static final int BONUS_HP_AGRESIVE_KNIGHT = 5;
    public static final int BONUS_HP_AGRESIVE_PYROMANCER = 4;
    public static final int BONUS_HP_AGRESIVE_ROGUE = 7;
    public static final int BONUS_HP_AGRESIVE_WIZARD = 10;

    public static final float MODIFIER_DEFENSIVE_KNIGHT = 0.2f;
    public static final float MODIFIER_DEFENSIVE_PYROMANCER = 0.3f;
    public static final float MODIFIER_DEFENSIVE_ROGUE = 0.1f;
    public static final float MODIFIER_DEFENSIVE_WIZARD = 0.2f;
    public static final float MODIFIER_AGRESIVE_KNIGHT = 0.5f;
    public static final float MODIFIER_AGRESIVE_PYROMANCER = 0.7f;
    public static final float MODIFIER_AGRESIVE_ROGUE = 0.4f;
    public static final float MODIFIER_AGRESIVE_WIZARD = 0.6f;
}
