package NoMuscle;

import java.util.Random;

public class Occurrence {
    /** Occurance happenings:
     * Jax: Gives a chocolate that damages or heals the player for a random amt
     * Chess set: Reduces max ammo but increases accuracy
     * Gojo: Aura farms and does nothing
     * Final exam: get asked 3 questions about your current stats; gain rewards based on questions correct
     * The Alchemist: Exchange HP for DMG boost
     * Hungry Car: Give HP to feed the cat, difficulty gets reduced by 1
     */
    private String[] posNames = new String[]{"Jax", "Incomplete Chess Set", "Gojo Satoru", "Final Exam", "The Alchemist", "A Hungry Cat"};
    private int ID;
    protected String name;
    private static Random RNG = new Random();

    public Occurrence() {

        ID = RNG.nextInt(posNames.length - 1);
        this.name = posNames[ID];



    }

    public boolean canGive(Player player) {
        return true;
    }


    public void extractCost(Player player) {

    }

    public void giveReward(Player player) {

    }

    public void doThing(Player player) {

        System.out.println("Encounter:" + name);

        if (canGive(player)) {
            extractCost(player);
            giveReward(player);

        } else {
            System.out.println("Cannot afford");
        }
    }

    public void Jax(Player you) {

        int playerChoice;

        System.out.println("You pass Jax as you explore, they hand you a small chocolate.");
        System.out.println("\"HEY HEY HEY, WHERES'S THE CHOCOLATE AT?\"");
        you.printHP();

        System.out.println("1. Eat the chocolate (lose or gain random HP)\n2. Pocket the chocolate (Lose 1 HP)");

        playerChoice = GameMainDrive.intChoice(2);

        if (playerChoice == 1) {

            int hpRestore = RNG.nextInt(5) + 1;

            if (RNG.nextBoolean()) {

                System.out.println("The chocolate melts in your mouth, healing " + hpRestore + " HP");
                you.changeHealth(hpRestore);

            } else {

                System.out.println("The chocolate was in Jax's pocket all day, your stomach turns and you lose " + hpRestore + " HP");
                you.changeHealth(-1 * hpRestore);

            }
        } else {

            System.out.println("Jax glares at you, your heart is broken");
            you.changeHealth(-1);

        }
    }
}
