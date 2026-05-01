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
    private Random RNG = new Random();
    public int progress;
    public boolean debug;
    public int catFood;

    public Player() {
        System.out.println("please do not use a blank player!!!");
        name = "test";
        health = 5;
        baseDmg = 1;
        baseAcc = .9;
    }

    public Player(String pName) {

        name = pName;
        progress = 0;

        if (name.equals("Silver Wolf")) {
            health = 999;
            baseDmg = 999;
            ammo = 999;
            maxAmmo = 999;
            baseAcc = 1;
            difficulty = 1;
        } else if (name.equals("debug")) {
            System.out.println("Debug mode activated !!");
            debug = true;
            health = 999;
            baseDmg = 999;
            ammo = 999;
            maxAmmo = 999;
            baseAcc = 1;
            difficulty = 1;
        }
        else {
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

    public void printHP() {

        System.out.print("[");

        if (health < 20) {
            for (int HP = 0; HP < health; HP++) {
                System.out.print("♥");
            }
        } else {
            System.out.print("♥ x " + health);
        }

        System.out.println("]");

    }

    public int getDifficulty() { return  difficulty;}

    public int attackKnife() {
        if (RNG.nextDouble() < this.getBaseAcc()) {
            System.out.printf("Dealt %d damage\n\n", baseDmg);
            return this.baseDmg;
        }
        System.out.println("Missed!\n\n");
        return 0;
    }

    public int attackGun() {
        if ((RNG.nextDouble() < this.getBaseAcc() - .1) && ammo > 0) {

            System.out.printf("Dealt %d damage\n\n", (int) Math.ceil(baseDmg * 1.8));

            ammo -= 1;

            return (int) Math.ceil(baseDmg * 1.8);

        } else if (ammo == 0) {

            System.out.println("Out of ammo! You need to reload!\n\n");
            return 0;

        }

        System.out.println("Missed!\n\n");
        return 0;
    }

    public boolean escape() {

        if (RNG.nextDouble() < Math.pow(10, (-1 * (difficulty / 10)))) {

            System.out.println("Escape successful!");
            return true;

        } else {

            System.out.println("Escape failed!");
            return false;

        }
    }

    public void printProgress() {

        System.out.println("\nProgress:");

        System.out.print("=");

        for (int i = 0; i < progress; i++) {

            System.out.print("//");

        }
        for (int i = 16; i > progress; i--) {

            System.out.print("--");

        }
        System.out.println("=");

        System.out.println((progress * 6.25) + "%\n");
    }


}
