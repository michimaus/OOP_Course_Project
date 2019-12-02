package players;

public interface PlayerVisitable {
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land);
}
