package gameterain;

public class GameMap {

    private static GameMap instance = null;

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }
}
