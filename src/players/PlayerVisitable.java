package players;

public interface PlayerVisitable {
    public void strike(PlayerVisitor v);
    public void calculateStrike(PlayerVisitor heroSpells, StandardPlayer opponent, char land);

}
