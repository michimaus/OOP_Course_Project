package players;

import common.Constants;

public class RoguePlayer extends StandardPlayer {

    public RoguePlayer(String type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.ROGUE_HP;
    }
}
