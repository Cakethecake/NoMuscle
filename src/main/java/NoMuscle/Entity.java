package NoMuscle;

public class Entity extends Event{
    public String name;
    public int HP;
    private int baseDmg;

    public String attackPlayer() {
        return toString("You took " + baseDmg + " damage." );
    }

    public void getAttacked(int dmg) {
        return "You took " + baseDmg + " from "
    }

    public Entity(String name, int HP, int baseDmg){
    }
}
