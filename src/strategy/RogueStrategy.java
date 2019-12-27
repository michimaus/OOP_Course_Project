package strategy;

import common.Constants;
import players.StandardPlayer;

public final class RogueStrategy implements PlayerStrategy {
    private static RogueStrategy instance = null;

    private RogueStrategy() {
    }

    public static RogueStrategy getInstance() {
        if (instance == null) {
            return new RogueStrategy();
        }
        return instance;
    }

    @Override
    public void getStrategy(final StandardPlayer player) {
        if (player.getCurrentHp() < player.getMaxHp() / Constants.DEFENSIVE_ROGUE) {
            player.addHp(player.getCurrentHp() / Constants.BONUS_HP_DEFENSIVE_ROGUE);
            player.addModifier(Constants.MODIFIER_DEFENSIVE_ROGUE * (-1));
        } else if (player.getCurrentHp() < player.getMaxHp() / Constants.AGRESIVE_ROGUE
                && player.getCurrentHp() > player.getMaxHp() / Constants.DEFENSIVE_ROGUE) {
            player.addHp((player.getCurrentHp() / Constants.BONUS_HP_AGRESIVE_ROGUE) * (-1));
            player.addModifier(Constants.MODIFIER_AGRESIVE_ROGUE);
        }
    }
}
