package players;

public interface PlayerVisitable {
    void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land);
}
