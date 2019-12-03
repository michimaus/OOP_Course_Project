package main;

import gameterain.GameMap;
import players.StandardPlayer;
import players.WizardPlayer;
import players.PyromancerPlayer;
import players.RoguePlayer;
import players.KnightPlayer;


import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        InputOutputStream inputOutputStream = new InputOutputStream(args[0], args[1]);
        DataLoader dataLoader = inputOutputStream.load();
        List<StandardPlayer> players = new ArrayList<>();
        int playerId = 0;

        for (DataLoader.PlayerData data : dataLoader.getInputPlayers()) {
            switch (data.getType()) {
                case 'W':
                   players.add(new WizardPlayer(data.getType(), data.getPosR(),
                           data.getPosC(), playerId));
                   break;
                case 'P':
                   players.add(new PyromancerPlayer(data.getType(), data.getPosR(),
                           data.getPosC(), playerId));
                   break;
                case 'K':
                   players.add(new KnightPlayer(data.getType(), data.getPosR(),
                           data.getPosC(), playerId));
                   break;
                default:
                   players.add(new RoguePlayer(data.getType(), data.getPosR(),
                           data.getPosC(), playerId));
                   break;
            }
            ++playerId;
        }

        GameMap map = GameMap.getInstance();
        map.initMap(dataLoader.getN(), dataLoader.getM(), dataLoader.getMap(), players);

        for (int i = 0; i < dataLoader.getRounds(); ++i) {
            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                player.takeDotDamage();
            }

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                player.setHasAtacked(false);
                player.updatePlayerNewRound(dataLoader.getMoves()[i][player.getId()]);
            }

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                if (!player.isHasAtacked()) {
                        map.timeForFight(player.getPosR(), player.getPosC());
                }
            }
        }
        inputOutputStream.write(players);
    }
}
