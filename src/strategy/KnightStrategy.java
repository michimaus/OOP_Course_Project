package strategy;

import common.Constants;
import players.StandardPlayer;

public final class KnightStrategy implements PlayerStrategy {
    private static KnightStrategy instance = null;

    private KnightStrategy() {
    }

    public static KnightStrategy getInstance() {
        if (instance == null) {
            return new KnightStrategy();
        }
        return instance;
    }

    @Override
    public void getStrategy(final StandardPlayer player) {
        if (player.getCurrentHp() < player.getMaxHp() / Constants.DEFENSIVE_KNIGHT) {
            player.addHp(player.getCurrentHp() / Constants.BONUS_HP_DEFENSIVE_KNIGHT);
            player.addModifier(Constants.MODIFIER_DEFENSIVE_KNIGHT * (-1));
        } else if (player.getCurrentHp() < player.getMaxHp() / Constants.AGRESIVE_KNIGHT
                && player.getCurrentHp() > player.getMaxHp() / Constants.DEFENSIVE_KNIGHT) {
            player.addHp((player.getCurrentHp() / Constants.BONUS_HP_AGRESIVE_KNIGHT) * (-1));
            player.addModifier(Constants.MODIFIER_AGRESIVE_KNIGHT);
        }
    }
}
