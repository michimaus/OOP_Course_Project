package angels;

import angelseffects.AngelEffects;
import angelseffects.AngelVisitable;
import players.StandardPlayer;

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
