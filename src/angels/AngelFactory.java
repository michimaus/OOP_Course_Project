package angels;

import players.StandardPlayer;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            return new AngelFactory();
        }
        return instance;
    }

    public void applyAngelEffect(final String type, final StandardPlayer player) {
        switch (type) {
            case "DamageAngel":
                System.out.println("yaaaaaaa");
                break;
            case "DarkAngel":
                System.out.println("yaaaaaaa");
                break;
            case "GoodBoy":
                break;
            case "LevelUpAngel":
                break;
            case "LifeGiver":
                break;
            case "SmallAngel":
                break;
            case "Spawner":
                break;
            case "XPAngel":
                System.out.println("yaaaaaaa");
                break;
            default:
//                System.out.println("yaaaaaaa");
                break;
        }
    }
}
