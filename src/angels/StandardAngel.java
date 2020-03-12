package angels;

import angelseffects.AngelEffects;
import angelseffects.AngelVisitable;
import players.StandardPlayer;

/**
 * Main class that contains the common data for any angel.
 * This class is extended by all the other classes belonging to a specific angel type,
 * coming up with their specific implementation for the methods, depending on the effect that
 * has to be applied.
 */

public abstract class StandardAngel implements AngelVisitable {
    private String type;
    private int posC;
    private int posR;
    private String angelOutAction;

    public final String getType() {
        return type;
    }

    public final int getPosC() {
        return posC;
    }

    public final int getPosR() {
        return posR;
    }

    public final String getAngelOutAction() {
        return angelOutAction;
    }

    StandardAngel(final String type, final int posR, final int posC, final String action) {
        this.type = type;
        this.posC = posC;
        this.posR = posR;
        angelOutAction = action;
    }

    public abstract void applyEffect(AngelEffects angelEffects, StandardPlayer player);

    public abstract boolean canInteract(StandardPlayer player);
}
