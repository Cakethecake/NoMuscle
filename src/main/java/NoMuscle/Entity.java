package NoMuscle;

import java.util.Random;

public class Entity  {

    private final Random RNG = new Random();
    private final static String[] possibleNames = new String[] {"Ratora","Resill","Lord Fardquaad","Kubis","Hungry Caterpillar","Strange Bird", "Jax", "A Living Room", "Deer-headed Man", "Homunculus"};
    private final static int[] possibleBaseDMG = new int[] {     1,             2,      1,               3,                 1};
    private final static int[] possibleBaseHP = new int[] {      2,             2,      999,             4,                 3};

    public String name;
    public int baseDmg;
    public int baseHP;
    public int currentHP;
    private int ID;

    public int attackPlayer() {
        return baseDmg;
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

            ID = RNG.nextInt(possibleNames.length);

            name = possibleNames[ID];
            baseDmg = (int) Math.ceil(possibleBaseDMG[ID] * difficulty * .8);
            baseHP = (int) Math.ceil(possibleBaseHP[ID] * difficulty * .8);
            currentHP = baseHP;

        } else {

            name = "PlaceHolderFinalBoss";
            baseDmg = 10;
            baseHP = 20;

        }

    }
}
