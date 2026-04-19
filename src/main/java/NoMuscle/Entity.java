package NoMuscle;

import java.util.Random;

public class Entity  {

    private final Random RNG = new Random();
    private final static String[] possibleNames = new String[] {"Strange Bird", "Jax", "A Living Room", "Deer-headed Man", "Homunculus"};
    private final static int[] possibleBaseDMG = new int[] {     1,             2,      1,               3,                 1};
    private final static int[] possiblebaseHP = new int[] {      2,             2,      999,             4,                 3};

    public String name;
    public int baseDmg;
    public int baseHP;
    private int ID;

    public int attackPlayer() {
        return baseDmg;
    }

    public void getAttacked(int dmg) {

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
            baseHP = (int) Math.ceil(possiblebaseHP[ID] * difficulty * .8);

        } else {

            name = "PlaceHolderFinalBoss";
            baseDmg = 10;
            baseHP = 20;

        }

    }
}
