package angels;

import players.StandardPlayer;

public class Dracula extends StandardAngel {
    Dracula(final String type, final int posR, final int posC) {
        super(type, posR, posC, " hit ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedByDracula(angelEffects);
    }
}
