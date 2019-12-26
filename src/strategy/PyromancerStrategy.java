package strategy;

import common.Constants;
import players.StandardPlayer;

public final class PyromancerStrategy implements PlayerStrategy {
    private static PyromancerStrategy instance = null;

    private PyromancerStrategy() {
    }

    public static PyromancerStrategy getInstance() {
        if (instance == null) {
            return new PyromancerStrategy();
        }
        return instance;
    }

    @Override
    public void getStrategy(final StandardPlayer player) {
        if (player.getCurrentHp() < player.getMaxHp() / Constants.DEFENSIVE_PYROMANCER) {
            player.addHp(player.getCurrentHp() / Constants.BONUS_HP_DEFENSIVE_PYROMANCER);
            player.addModifier(Constants.MODIFIER_DEFENSIVE_PYROMANCER * (-1));
        } else if (player.getCurrentHp() < player.getMaxHp() / Constants.AGRESIVE_PYROMANCER) {
            player.addHp((player.getCurrentHp() / Constants.BONUS_HP_AGRESIVE_PYROMANCER) * (-1));
            player.addModifier(Constants.MODIFIER_AGRESIVE_PYROMANCER);
        }
    }
}
