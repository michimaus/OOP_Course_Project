package players;

import common.Constants;

public class KnightPlayer extends StandardPlayer {

    public KnightPlayer(char type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.KNIGHT_HP;
    }

    @Override
    public void accept(PlayerVisitor v) {

    }
}
