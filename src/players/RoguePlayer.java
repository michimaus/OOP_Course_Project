package players;

import common.Constants;

public class RoguePlayer extends StandardPlayer {

    public RoguePlayer(char type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.ROGUE_HP;
    }

    @Override
    public void accept(PlayerVisitor v) {

    }
}
