package observer;

import gameterain.GameMap;
import main.InputOutputStream;

public class PlayerMyObserver extends MyObserver {
    public PlayerMyObserver(final GameMap subject, final InputOutputStream ioStream) {
        this.subject = subject;
        subject.setPlayerObservers(this);
        inputOutputStream = ioStream;
    }
}
