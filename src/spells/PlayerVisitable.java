package spells;

import players.StandardPlayer;

/**
 * Setting the interaction between two characters.
 * Specific method for every races that sets the applied spells.
 */

public interface PlayerVisitable {
    void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land);
}
