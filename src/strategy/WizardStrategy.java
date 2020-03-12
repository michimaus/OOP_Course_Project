package strategy;

import common.Constants;
import players.StandardPlayer;

public final class WizardStrategy implements PlayerStrategy {
    private static WizardStrategy instance = null;

    private WizardStrategy() {
    }

    public static WizardStrategy getInstance() {
        if (instance == null) {
            instance = new WizardStrategy();
        }
        return instance;
    }

    @Override
    public void getStrategy(final StandardPlayer player) {
        if (player.getCurrentHp() < player.getMaxHp() / Constants.DEFENSIVE_WIZARD) {
            player.addHp(player.getCurrentHp() / Constants.BONUS_HP_DEFENSIVE_WIZARD);
            player.addModifier(Constants.MODIFIER_DEFENSIVE_WIZARD * (-1));
        } else if (player.getCurrentHp() < player.getMaxHp() / Constants.AGRESIVE_WIZARD
                && player.getCurrentHp() > player.getMaxHp() / Constants.DEFENSIVE_WIZARD) {
            player.addHp((player.getCurrentHp() / Constants.BONUS_HP_AGRESIVE_WIZARD) * (-1));
            player.addModifier(Constants.MODIFIER_AGRESIVE_WIZARD);
        }
    }
}
