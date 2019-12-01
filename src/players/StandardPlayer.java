package players;

public class StandardPlayer implements PlayerVisitor{
    protected String type;
    protected int posX;
    protected int posY;
    protected int hp;
    protected int xp;
    protected int level;
    protected int hasDotFor;

    public String getType() {
        return type;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public StandardPlayer(String type, int posX, int posY) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.xp = 0;
        this.level = 0;
        this.hasDotFor = 0;
    }

}
