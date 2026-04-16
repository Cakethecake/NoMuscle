package NoMuscle;

public class Entity extends Event{
    public String name;
    public int HP;
    private int baseDmg;

    public int attackPlayer() {
        return 0;
    }

    public void getAttacked(int dmg) {

    }
    public Entity(String name, int HP, int baseDmg){

    }
}
