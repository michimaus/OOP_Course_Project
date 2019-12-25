package angels;

import players.StandardPlayer;

public class LevelUpAngel extends StandardAngel {
    LevelUpAngel(final String type, final int posR, final int posC) {
        super(type, posR, posC, " helped ");
    }

    @Override
    public final void applyEffect(final AngelEffects angelEffects, final StandardPlayer player) {
        player.visitedByLevelUpAngel(angelEffects);
    }
}
