package angelseffects;

import players.StandardPlayer;

/**
 * Setting the interaction between an angel and a hero.
 * There will be a method for angel hero type that sets up the effect.
 */

public interface AngelVisitable {
    void applyEffect(AngelEffects angelEffects, StandardPlayer player);
}
