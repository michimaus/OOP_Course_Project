package main;

import gameterain.GameMap;
import players.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        InputOutputStream inputOutputStream = new InputOutputStream(args[0], args[1]);
        DataLoader dataLoader = inputOutputStream.load();
        List<StandardPlayer> players = new ArrayList<>();

        for (DataLoader.PlayerData data : dataLoader.getInputPlayers()) {
            switch (data.type) {
                case 'W':
                   players.add(new WizardPlayer(data.type, data.posR, data.posC));
                   break;
                case 'P':
                   players.add(new PyromancerPlayer(data.type, data.posR, data.posC));
                   break;
                case 'K':
                   players.add(new KnightPlayer(data.type, data.posR, data.posC));
                   break;
                case 'R':
                   players.add(new RoguePlayer(data.type, data.posR, data.posC));
                   break;
            }
        }
        GameMap map = GameMap.getInstance();
        map.initMap(dataLoader.getN(), dataLoader.getM(), dataLoader.getMap(), players);
        boolean [] checked = new boolean [dataLoader.getNoPlayers()];
        for (int i = 0; i < dataLoader.getRounds(); ++i) {
            int playerId = 0;

            for (int j = 0; j < dataLoader.getNoPlayers(); ++j) {
                checked[j] = false;
            }
//            checked = new boolean [dataLoader.getNoPlayers()];
            for (StandardPlayer player : players) {
                player.movePosition(dataLoader.getMoves()[i][playerId]);

                ++playerId;
            }
        }
        inputOutputStream.write(players);

//        map.nulTest();
        for (StandardPlayer player : players) {
            System.out.println(player.getType());
        }
    }
}
