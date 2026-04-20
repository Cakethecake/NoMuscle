package NoMuscle;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    public String name;
    public int health;
    public int baseDmg;
    public double baseAcc;
    public int difficulty;
    public int ammo;
    public int maxAmmo;
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

        if (name.equals("Debug")) {
            System.out.println("Debug mode activated !!!!!!!!!!!!!!!!!!");
            health = 999;
            baseDmg = 999;
            ammo = 999;
            maxAmmo = 999;
            baseAcc = 1;
            difficulty = 1;
        } else {
            health = 5;
            baseDmg = 1;
            ammo = 6;
            maxAmmo = 6;
            baseAcc = .9;
            difficulty = 1;
        }


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

    public int getAmmo() {
        return ammo;
    }

    public void reload() {
        ammo = maxAmmo;
    }

    public double getBaseAcc() {
        return baseAcc;
    }

    public int getDifficulty() { return  difficulty;}

    public int attackKnife(Entity opp) {
        if (RNG.nextDouble() < this.getBaseAcc()) {
            System.out.printf("Dealt %d", baseDmg);
            return this.baseDmg;
        }
        System.out.println("Missed!");
        return 0;
    }

    public int attackGun(Entity opp) {
        if ((RNG.nextDouble() < this.getBaseAcc() - .1) && ammo > 0) {

            System.out.printf("Dealt %d", (int) Math.ceil(baseDmg * 1.8));

            ammo -= 1;

            return (int) Math.ceil(baseDmg * 1.8);

        } else if (ammo == 0) {

            System.out.println("Out of ammo! You need to reload!");
            return 0;

        }

        System.out.println("Missed!");
        return 0;
    }


}
