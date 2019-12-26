package observer;

import angels.StandardAngel;
import gameterain.GameMap;
import main.InputOutputStream;
import players.StandardPlayer;

public class AngelMyObserver extends MyObserver {
    public AngelMyObserver(final GameMap subject, final InputOutputStream ioStream) {
        this.subject = subject;
        subject.setAngelObservers(this);
        inputOutputStream = ioStream;
    }

    public final void updateAngelSpawn(final StandardAngel angel) {
        inputOutputStream.writeAngelSpawn(angel);
    }

    public final void updatePlayerInteraction(final StandardAngel angel,
                                              final StandardPlayer player) {
        inputOutputStream.writePlayerInteraction(angel, player);
    }
}
