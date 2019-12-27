package players;

import java.util.Comparator;

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
