package NoMuscle;
import java.util.ArrayList;

public class Player {
    public String name;
    public int health;
    public int baseDmg;
    public double baseAcc;

    public Player() {
        System.out.println("please do not use a blank player!!!");
        name = "test";
        health = 5;
        baseDmg = 1;
        baseAcc = .9;
    }

    public Player(String pName) {
        name = pName;
        health = 5;
        baseDmg = 1;
        baseAcc = .9;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public double getBaseAcc() {
        return baseAcc;
    }


}
