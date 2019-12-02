package main;

import common.Constants;
import gameterain.GameMap;
import players.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        InputOutputStream inputOutputStream = new InputOutputStream(args[0], args[1]);
        DataLoader dataLoader = inputOutputStream.load();
        List<StandardPlayer> players = new ArrayList<>();

        int playerId = 0;

        for (DataLoader.PlayerData data : dataLoader.getInputPlayers()) {
            switch (data.type) {
                case 'W':
                   players.add(new WizardPlayer(data.type, data.posR, data.posC, playerId));
                   break;
                case 'P':
                   players.add(new PyromancerPlayer(data.type, data.posR, data.posC, playerId));
                   break;
                case 'K':
                   players.add(new KnightPlayer(data.type, data.posR, data.posC, playerId));
                   break;
                case 'R':
                   players.add(new RoguePlayer(data.type, data.posR, data.posC, playerId));
                   break;
            }
            ++playerId;
        }

        GameMap map = GameMap.getInstance();
        map.initMap(dataLoader.getN(), dataLoader.getM(), dataLoader.getMap(), players);


        for (int i = 0; i < dataLoader.getRounds(); ++i) {
//            checked = new boolean [dataLoader.getNoPlayers()];
            for (StandardPlayer player : players) {
                player.setHasAtacked(false);
                player.updatePlayerNewRound(dataLoader.getMoves()[i][player.getId()]);
            }

            for (StandardPlayer player : players) {

                if (!player.isHasAtacked()) {
                    if (player.getCurrentHp() > 0)
                        map.timeForFight(player.getPosR(), player.getPosC());
                }

            }

            for (StandardPlayer player : players) {
                player.printData();
            }
            System.out.println("-----------END ROUND--------");
        }
        inputOutputStream.write(players);

//        map.nulTest();
        for (StandardPlayer player : players) {
            System.out.println(player.getType());
        }

//        int ceva = 234;
//        int altceva = 645;
//        float currentProcent = ((float) ceva / (float) altceva) * Constants.ONE_HUNDRED;
//        System.out.println(currentProcent);
    }
}
