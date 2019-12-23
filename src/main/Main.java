package main;

import gameterain.GameMap;
import players.PlayerFactory;
import players.StandardPlayer;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Main game runner where the logic of the game gets implemented.
 * First the data gets processed -getting the players and the map elements-
 * and then are implemented the game rules for every round -checking for DoT damage,
 * making the players move around the map, and then looking at the map if is the case for a fight.
 */

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        InputOutputStream inputOutputStream = new InputOutputStream(args[0], args[1]);
        DataLoader dataLoader = DataLoader.getInstance();

        inputOutputStream.loadMap();
        GameMap map = GameMap.getInstance();
        map.initLand(dataLoader.getN(), dataLoader.getM(), dataLoader.getMap());

        inputOutputStream.loadNumPlayers();
        List<StandardPlayer> players = new ArrayList<>();
        PlayerFactory playerFactory = PlayerFactory.getInstance();

        for (int i = 0; i < dataLoader.getP(); ++i) {
            inputOutputStream.loadPlayer();
            players.add(playerFactory.creatPlayer(dataLoader.getPlayer()));
        }
        map.initPlayers(players);


        LinkedList<LinkedList<DataLoader.AngelData>> angels = dataLoader.getInputAngels();
        int i = 0;

        for (LinkedList<DataLoader.AngelData> angelsThisRound : angels) {

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
                player.setHasAttacked(false);
                player.updatePlayerNewRound(dataLoader.getMoves()[i][player.getId()]);
            }

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                if (!player.isHasAttacked()) {
                        map.timeForFight(player.getPosR(), player.getPosC());
                }
            }

            if (angelsThisRound.size() != 0) {
                for (DataLoader.AngelData angel : angelsThisRound) {
                    map.spawnAngel(angel);
                }
            }
            ++i;
        }
        inputOutputStream.writeFinalStandings(players);
    }
}
