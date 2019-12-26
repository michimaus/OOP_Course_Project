package main;

import angels.AngelFactory;
import angels.StandardAngel;
import gameterain.GameMap;
import observer.AngelMyObserver;
import observer.PlayerMyObserver;
import players.PlayerFactory;
import players.StandardPlayer;

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
        DataLoader dataLoader = DataLoader.getInstance();
        InputOutputStream inputOutputStream = new InputOutputStream(args[0], args[1], dataLoader);

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

        inputOutputStream.loadRoundsMoves();
        AngelFactory angelFactory = AngelFactory.getInstance();

        AngelMyObserver angelMyObserver = new AngelMyObserver(map, inputOutputStream);
        PlayerMyObserver playerMyObserver = new PlayerMyObserver(map, inputOutputStream);

        for (int i = 0; i < dataLoader.getRounds(); ++i) {
            inputOutputStream.writeRound(i);

            for (StandardPlayer player : players) {
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                player.takeDotDamage();
                if (player.getCurrentHp() <= 0) {
                    continue;
                }
                player.updateStrategy();
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

            inputOutputStream.loadNumAngelsRound();
            List<StandardAngel> angels = new ArrayList<>();

            System.out.println(dataLoader.getNumAngelsRound());
            for (int j = 0; j < dataLoader.getNumAngelsRound(); ++j) {
                inputOutputStream.loadAngel();
                angels.add(angelFactory.createAngel(dataLoader.getAngel()));
                System.out.println(dataLoader.getAngel().getType());
            }
            map.spawnAngels(angels);
            inputOutputStream.writeEmptyLine();

        }
        inputOutputStream.writeFinalStandings(players);
    }
}
