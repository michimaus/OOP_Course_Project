package angels;

import players.StandardPlayer;

public class DamageAngel extends StandardAngel {
    DamageAngel(final String type, final int posR, final int posC) {
        super(type, posR, posC, " helped ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedByDamageAngel(angelEffects);
    }
}
