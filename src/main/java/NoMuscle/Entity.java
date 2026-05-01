package NoMuscle;

import java.util.Random;

public class Entity  {

    private final Random RNG = new Random();
    //                                                      IDs: 0        1        2                3       4                    5              6        7                8                  9
    private final static String[] possibleNames = new String[] {"Ratora","Resill","Lord Fardquaad","Kubis","A Hungry Caterpillar","A Strange Bird", "Rogue Fighter", "A Living Room", "Deer-headed Man", "Homunculus"};
    private final static int[] possibleBaseDMG = new int[] {    2,        3,       1,              2,       1,                   1,             2,       1,               3,                 1};
    private final static int[] possibleBaseHP = new int[] {     4,        5,       5,              3,       4,                   3,             3,       999,             5,                 4};

    public String name;
    public int baseDmg;
    public int baseHP;
    public int currentHP;
    private int ID;
    public boolean charging;

    public int attackPlayer() {

        if (((currentHP < 3) || (RNG.nextDouble() < .6)) && charging == false) {
            System.out.println(name + " Attacks dealing " + baseDmg + " DMG!\n");
            return baseDmg;
        }

        if ((GameMainDrive.you.difficulty > 2 && charging == false && (RNG.nextDouble() < .5)) && ID != 7) {
            System.out.println(name + " Is charging a powerful attack!\n");
            charging = true;
            return 0;
        }

        if (charging == true) {
            System.out.println(name + " unleashes a powerful attack dealing " + ((int) Math.ceil(baseDmg * 1.7)) + " DMG!!\n");
            if (ID == 4) {
                System.out.println(name + " heals for 2 HP!\n");
                currentHP += 2;
            }

            charging = false;

            return (int) Math.ceil(baseDmg * 1.7);
        }

        if (ID == 9) {
            System.out.println(name + " heals for 1 HP\n");
            currentHP += 1;
            return 0;
        }

        System.out.println(name + " is waiting...\n");
        return 0;

    }

    public void getAttacked(int dmg) {
        currentHP -= dmg;
    }

    public void printHP() {

        System.out.print("[");

        for(int HP = 0; HP < currentHP; HP++) {
            System.out.print("♥");
        }
        for(int missing = 0; missing < baseHP - currentHP; missing++) {
            System.out.print("♡");
        }

        System.out.println("]");
    }

    public Entity() {
        System.out.println("Cannot have a blank Entity !");
    }

    public Entity(int difficulty, boolean isFinalFight) {

        /**
         * This chooses a random enemy and assigns it to the created entity object, provided it is not the final fight
         */
        if (!isFinalFight) {

            // Selects an enemy ID, banning certain hard enemies at low difficulty
            do {
                ID = RNG.nextInt(possibleNames.length);
            } while ((ID == 1 || ID == 4 || ID == 7 || ID == 8) && difficulty < 8);

            name = possibleNames[ID];
            baseDmg = (int) Math.ceil(possibleBaseDMG[ID] * difficulty * .1);
            baseHP = (int) Math.ceil(possibleBaseHP[ID] * difficulty * .4);
            currentHP = baseHP;

        } else {

            name = "PlaceHolderFinalBoss";
            baseDmg = 10;
            baseHP = 20;

        }

    }
}

/**
 * entity will have random stats but difficulty will be ranked by a multiplier
 * main method will drive the attack
 */
