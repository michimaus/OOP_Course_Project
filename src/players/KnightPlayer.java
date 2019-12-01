package players;

import common.Constants;

public class KnightPlayer extends StandardPlayer {

    public KnightPlayer(String type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.KNIGHT_HP;
    }
}
