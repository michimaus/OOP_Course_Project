package angels;

import players.StandardPlayer;

public class TheDoomer extends StandardAngel {
    TheDoomer(final String type, final int posR, final int posC) {
        super(type, posR, posC, " hit ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedByTheDoomer(angelEffects);
    }
}
