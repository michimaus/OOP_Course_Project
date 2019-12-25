package angels;

import players.StandardPlayer;

public interface AngelVisitable {
    void applyEffect(AngelEffects angelEffects, StandardPlayer player);
}
