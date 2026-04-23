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
     * Server Admin Lynn: Heals player to max health
     */
    private String[] posNames = new String[]{"Jax", "Incomplete Chess Set", "Gojo Satoru", "Final Exam", "The Alchemist", "A Hungry Cat", "Server Admin Lynn"};
    public int ID;
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
        System.out.println("\"HEY HEY HEY, WHERE'S THE CHOCOLATE AT?\"");
        you.printHP();

        System.out.println("1. Eat the chocolate (lose or gain random HP)\n2. Pocket the chocolate (Lose 1 HP)");

        // Asks the player for their choice
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

    public void Chess(Player you) {

        int playerChoice;

        System.out.println("In the room, you see a sad looking chess set with missing pieces.");
        System.out.println("You look in your bag, the closes thing to a chess piece is your ammo.");
        System.out.println("Your current max ammo is " + you.maxAmmo + " and your current accuracy is " + (int)(you.baseAcc * 100));
        System.out.println("1. Fill in the missing pieces with bullets (Lose 1 max ammo, gain 10 accuracy)\n2. Leave");

        playerChoice = GameMainDrive.intChoice(2);
        if (you.maxAmmo > 0 && playerChoice == 1) {
            System.out.println("It matches well enough.");
            you.maxAmmo -= 1;
            you.baseAcc += .1;
        } else {
            System.out.println("You walk away");
        }
    }

    public void Gojo(Player you) {

        System.out.println("Gojo stands before you, his really awesome aura is quite overwhelming.");
        System.out.println("You stand there in awe and waste your time glazing him. (Nothing happens)");

    }

    public void finalExam(Player you) {

    }

    public void theAlchemist(Player you) {

    }

    public void hungryCat(Player you) {

        int playerChoice;
        int lostHp;

        System.out.println("A stray cat wanders toward you with an empty bowl, you hear its stomach growl.");
        System.out.println("1. Feed the cat (Lose 10% of your HP, reduce difficulty by 1).\n2. Don't feed the cat. (Nothing happens)");

        playerChoice = GameMainDrive.intChoice(2);

        // If first choice is chosen, lose 10% HP and reduce difficulty by 1
        if (playerChoice == 1) {

            lostHp = (int)Math.ceil(you.getHealth() * 0.1);

            System.out.println("You feed the cat and lose " + lostHp + " HP.");

            you.changeHealth(-1 * lostHp);

            System.out.println("The cat is very grateful and purrs at your leg. Your difficulty is reduced by 1.");

            // Avoids game crash if difficulty is 1
            if (you.difficulty > 0) {
                you.difficulty -= 1;
            }

        } else {
            System.out.println("The cat faints from hunger and you move on... (how could you).");
        }

    }

    public void adminLynn(Player you) {

        int playerChoice;
        int lostHp;

        System.out.println("You are graced with the angelic presence of Lynn... the background music suddenly plays.");
        System.out.println("1. Let Lynn inspect you (Chance to gain 100% HP or lose 50% HP). 2. Wave her off (Chance to lose 30% HP).");

        playerChoice = GameMainDrive.intChoice(2);

        if (playerChoice == 1) {

            // 50/50 chance to be healed or lose hp - MIGHT change to 75/25 but not sure
            if (RNG.nextBoolean()) {

                // If true
                System.out.println("Lynn seems to like you, she patches you up! Gained 2x HP");
                you.changeHealth(you.getHealth());

            } else {
                lostHp = (int)Math.ceil(you.getHealth() * 0.5);
                System.out.println("Lynn gives you a nasty look, she finds something deeply wrong with you. You lose " + lostHp + " HP.");

                you.changeHealth(-1 * lostHp);
            }
        } else {

            if (RNG.nextBoolean()) {

                // If true
                lostHp = (int)Math.ceil(you.getHealth() * 0.3);
                System.out.println("She looks offended and smacks you, you lose " + lostHp + " HP.");

                you.changeHealth(-1 * lostHp);
            } else {
                System.out.println("Lynn surprisingly shrugs it off and flies back up, lose 0 HP. You got lucky...");

            }

        }
    }
}
