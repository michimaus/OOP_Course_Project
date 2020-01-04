package strategy;

import players.StandardPlayer;

/**
 * Class where it is structured the strategy signature.
 * This type will be defined for each hero, as a class parameter.
 * Each of the other classes that will implement this interface will be specific to each hero type
 * and will have a different implementation for "getStrategy".
 * Also those other classes will be singleton.
 */

public interface PlayerStrategy {
    void getStrategy(StandardPlayer player);
}
