package observer;

import angels.StandardAngel;
import gameterain.GameMap;
import main.InputOutputStream;
import players.StandardPlayer;

/**
 * The main observer of the game in a singleton.
 * It has implementation for all the observer methods.
 * The observer gets linked with the game map, as that is the place where all the
 * interactions and all the events are defined.
 */

public final class GreatMage implements MyObserver {

    private GameMap subject;
    private InputOutputStream inputOutputStream;
    private static GreatMage instance;

    private GreatMage() {
        subject = null;
        inputOutputStream = null;
    }

    public void setObserver(final GameMap newSubject, final InputOutputStream ioStream) {
        subject = newSubject;
        subject.setObserver(this);
        inputOutputStream = ioStream;
    }

    public static GreatMage getInstance() {
        if (instance == null) {
            instance = new GreatMage();
        }
        return instance;
    }

    public void updatePlayerKillingOther(final StandardPlayer killer,
                                              final StandardPlayer player) {
        inputOutputStream.writePlayerKillingOther(killer, player);
    }

    public void updatePlayerLevel(final StandardPlayer player, final int level) {
        inputOutputStream.writePlayerReachLevel(player, level);
    }

    public void updateAngelKillingPlayer(final StandardPlayer player) {
        inputOutputStream.writeAngelKillingPlayer(player);
    }

    public void updatePlayerRespawned(final StandardPlayer player) {
        inputOutputStream.writePlayerRespawned(player);
    }

    public void updateAngelSpawn(final StandardAngel angel) {
        inputOutputStream.writeAngelSpawn(angel);
    }

    public void updatePlayerInteraction(final StandardAngel angel,
                                              final StandardPlayer player) {
        inputOutputStream.writePlayerInteraction(angel, player);
    }
}
