package angels;

import angelseffects.AngelEffects;
import players.StandardPlayer;

public class LifeGiver extends StandardAngel {
    LifeGiver(final String type, final int posR, final int posC) {
        super(type, posR, posC, " helped ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedByLifeGiver(angelEffects);
    }

    @Override
    public final boolean canInteract(final StandardPlayer player) {
        if (player.getCurrentHp() <= 0) {
            return false;
        }
        return true;
    }
}
