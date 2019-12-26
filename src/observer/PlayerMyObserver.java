package observer;

import gameterain.GameMap;
import main.InputOutputStream;
import players.StandardPlayer;

public class PlayerMyObserver extends MyObserver {
    public PlayerMyObserver(final GameMap subject, final InputOutputStream ioStream) {
        this.subject = subject;
        subject.setPlayerObservers(this);
        inputOutputStream = ioStream;
    }

    public final void updatePlayerKillingOther(final StandardPlayer killer,
                                              final StandardPlayer player) {
        inputOutputStream.writePlayerKillingOther(killer, player);
    }

    public final void updatePlayerLevel(final StandardPlayer player, final int level) {
        inputOutputStream.writePlayerReachLevel(player, level);
    }

    public final void updateAngelKillingPlayer(final StandardPlayer player) {
        inputOutputStream.writeAngelKillingPlayer(player);
    }

    public final void updatePlayerRespawned(final StandardPlayer player) {
        inputOutputStream.writePlayerRespawned(player);
    }
}
