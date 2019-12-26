package angels;

import angelseffects.AngelEffects;
import players.StandardPlayer;

public class Spawner extends StandardAngel {
    Spawner(final String type, final int posR, final int posC) {
        super(type, posR, posC, " helped ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedBySpawner(angelEffects);
    }

    @Override
    public final boolean canInteract(final StandardPlayer player) {
        if (player.getCurrentHp() > 0) {
            return false;
        }
        return true;
    }
}
