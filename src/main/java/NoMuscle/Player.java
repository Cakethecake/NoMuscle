package NoMuscle;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    public String name;
    public int health;
    public int baseDmg;
    public double baseAcc;
    public int difficulty;
    private Random RNG;

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
        difficulty = 1;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int diff) {
        this.health += diff;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public double getBaseAcc() {
        return baseAcc;
    }

    public int getDifficulty() { return  difficulty;}

    public int attack(Entity opp) {
        if (RNG.nextDouble() < this.getBaseAcc()) {
            System.out.printf("Dealt %d", baseDmg);
            return this.baseDmg;
        }
        System.out.println("Missed!");
        return 0;
    }


}
