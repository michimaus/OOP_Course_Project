package angels;

import main.DataLoader;

/**
 * Factory class where the angels are created.
 * The method "createAngel" is the one that return the new instance of an angel,
 * depending on its type.
 */

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public StandardAngel createAngel(final DataLoader.AngelData angelData) {
        switch (angelData.getType()) {
            case "DamageAngel":
                return new DamageAngel(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "DarkAngel":
                return new DarkAngel(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "Dracula":
                return new Dracula(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "GoodBoy":
                return new GoodBoy(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "LevelUpAngel":
                return new LevelUpAngel(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "LifeGiver":
                return new LifeGiver(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "SmallAngel":
                return new SmallAngel(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "Spawner":
                return new Spawner(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            case "XPAngel":
                return new XPAngel(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
            default:
                return new TheDoomer(angelData.getType(),
                        angelData.getPosR(), angelData.getPosC());
        }
    }
}
