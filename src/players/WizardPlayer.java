package players;

import common.Constants;

public class WizardPlayer extends StandardPlayer {

    public WizardPlayer(String type, int posX, int posY) {
        super(type, posX, posY);
        hp = Constants.WIZARd_HP;
    }
}
