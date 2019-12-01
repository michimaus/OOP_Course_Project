package players;

import common.Constants;

public class PyromancerPlayer extends StandardPlayer {
    public PyromancerPlayer(String type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.PYROMANCE_HP;
    }
}
