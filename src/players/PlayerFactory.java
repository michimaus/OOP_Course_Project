package players;

import main.DataLoader;

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
                return new WizardPlayer(data.getType(), data.getPosR(),
                        data.getPosC(), playerId);
            case 'P':
                return new PyromancerPlayer(data.getType(), data.getPosR(),
                        data.getPosC(), playerId);
            case 'K':
                return new KnightPlayer(data.getType(), data.getPosR(),
                        data.getPosC(), playerId);
            default:
                return new RoguePlayer(data.getType(), data.getPosR(),
                        data.getPosC(), playerId);
        }
    }
}
