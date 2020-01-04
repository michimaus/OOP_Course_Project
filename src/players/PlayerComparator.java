package players;

import java.util.Comparator;

/**
 * Sorting players by the ID for the situation when players are dead and it's the case of
 * interaction with th respawn angel.
 */

public final class PlayerComparator implements Comparator<StandardPlayer> {
    public int compare(final StandardPlayer p1, final StandardPlayer p2) {
        if (p1.getId() < p2.getId()) {
            return -1;
        } else if (p1.getId() > p2.getId()) {
            return 1;
        }
        return 0;
    }
}
