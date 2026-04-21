package NoMuscle;

public class Entity extends Event{
    public String name;
    public int HP;
    private int baseDmg;

    public int attackPlayer() {
        return baseDmg;
    }

    public void getAttacked(int dmg) {
        return baseDmg;
    }

    public Entity(String name, int HP, int baseDmg){
    }
}

/**
 * entity will have random stats but difficulty will be ranked by a multiplier
 * main method will drive the attack
 */
