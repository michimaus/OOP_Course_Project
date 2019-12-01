package main;

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
               case "W":
                   players.add(new WizardPlayer(data.type, data.pozx, data.pozy));
                   break;
               case "P":
                   players.add(new PyromancerPlayer(data.type, data.pozx, data.pozy));
                   break;
               case "K":
                   players.add(new KnightPlayer(data.type, data.pozx, data.pozy));
                   break;
               case "R":
                   players.add(new RoguePlayer(data.type, data.pozx, data.pozy));
                   break;
           }
       }

      inputOutputStream.write(players);

    }
}
