package main;

import common.Constants;
import gameterain.GameMap;
import players.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        class CoordsPair {
            private final int posR;
            private final int posC;

            public CoordsPair(final int posR, final int posC) {
                this.posR = posR;
                this.posC = posC;
            }

            @Override
            public boolean equals(final Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof CoordsPair)) {
                    return false;
                }
                final CoordsPair pair = (CoordsPair) o;

                if (posR != pair.posR) {
                    return false;
                }
                if (posC != pair.posC) {
                    return false;
                }
                return true;
            }

            @Override
            public int hashCode() {
                int result = posR;
                result = Constants.PRIME_NUMBER * result + posC;
                return result;
            }
        }

        Map<CoordsPair, StandardPlayer> playerEvidence = new HashMap<>();

        for (int i = 0; i < dataLoader.getRounds(); ++i) {
            playerEvidence.clear();

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }

                player.setHasAtacked(false);
                player.updatePlayerNewRound(dataLoader.getMoves()[i][player.getId()]);
//                System.out.print(dataLoader.getMoves()[i][player.getId()]);
//                if (playerEvidence.get(new CoordsPair(player.getPosR(), player.getPosR())) != null) {
//                    StandardPlayer.fight(playerEvidence.get(new CoordsPair(player.getPosR(), player.getPosR())), player);
//                } else {
//                    playerEvidence.put(new CoordsPair(player.getPosR(), player.getPosR()), player);
//                }
            }
//            System.out.println(" ");

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() > 0) {
                    if (!player.isHasAtacked())
                        map.timeForFight(player.getPosR(), player.getPosC(), i);
                }
            }
            System.out.println("Round: " + i);
            for (StandardPlayer player : players) {
                player.printData();
            }
            System.out.println("-----------END ROUND--------");
        }
//
//
        System.out.println(" ");
        map.testPrint();
//
////        map.nulTest();
//        for (StandardPlayer player : players) {
//            System.out.println(player.getType());
//        }




        inputOutputStream.write(players);
    }
}
