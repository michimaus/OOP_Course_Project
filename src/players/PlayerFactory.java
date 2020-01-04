package players;

import main.DataLoader;

/**
 * Factory class where the heroes are created.
 * The method "creatPlayer" is the one that return the new instance of a player,
 * depending on his type.
 */

public final class PlayerFactory {
    private int playerId;
    private static PlayerFactory instance = null;

    private PlayerFactory() {
        playerId = -1;
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            return new PlayerFactory();
        }
        return instance;
    }

    public StandardPlayer creatPlayer(final DataLoader.PlayerData data) {
        ++playerId;
        switch (data.getType()) {
            case 'W':
                return new WizardPlayer("Wizard", data.getPosR(),
                        data.getPosC(), playerId);
            case 'P':
                return new PyromancerPlayer("Pyromancer", data.getPosR(),
                        data.getPosC(), playerId);
            case 'K':
                return new KnightPlayer("Knight", data.getPosR(),
                        data.getPosC(), playerId);
            default:
                return new RoguePlayer("Rogue", data.getPosR(),
                        data.getPosC(), playerId);
        }
    }
}
