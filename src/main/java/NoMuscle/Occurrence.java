package NoMuscle;

import java.util.Random;

public class Occurrence {
    /** Occurrence happenings:
     * Jax: Gives a chocolate that damages or heals the player for a random amt
     * Chess set: Reduces max ammo but increases accuracy
     * Gojo: Aura farms and does nothing
     * Final exam: get asked 3 questions about your current stats; gain rewards based on questions correct
     * The Alchemist: Exchange HP for DMG boost; exchange accuracy for HP
     * Hungry Car: Give HP to feed the cat, difficulty gets reduced by 1
     * Server Admin Lynn: Either doubles health, takes health, or leaves you alone
     */
    private String[] posNames = new String[]{"Jax", "An Incomplete Chess Set", "Gojo Satoru", "Your Final Exam", "The Alchemist", "A Hungry Cat", "Server Admin Lynn"};
    public int ID;
    protected String name;
    private static Random RNG = new Random();

    public Occurrence() {

        ID = RNG.nextInt(posNames.length - 1);
        this.name = posNames[ID];

    }

    public void Jax(Player you) {

        int playerChoice;

        System.out.println("You pass Jax as you explore, they hand you a small chocolate.");
        System.out.println("\"HEY HEY HEY, WHERE'S THE CHOCOLATE AT?\"");

        GameMainDrive.eepy(1000);

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

        GameMainDrive.eepy(1000);

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

        GameMainDrive.eepy(10000);

        System.out.println("You stand there in awe and waste your time glazing him. (Nothing happens)");

        GameMainDrive.eepy(500);

    }

    public void finalExam(Player you) {

        int latestChoice;
        int score = 0;

        System.out.println("As you walk in, everyone in the room turns to look at you.");
        GameMainDrive.eepy(200);
        System.out.println("Someone hands you a piece of paper labeled \"FINAL EXAM\" and points you to an empty desk.");
        GameMainDrive.eepy(2500);

        // Clears the terminal
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }

        System.out.println("Question 1:\nWhat is your current HP?");
        latestChoice = GameMainDrive.intChoice(you.getHealth() + 10);
        if (latestChoice == you.getHealth()) {
            score += 1;
        }

        System.out.println("Question 2:\nHow many bullets are in your gun?");
        latestChoice = GameMainDrive.intChoice(you.getAmmo() + 10);
        if (latestChoice == you.getAmmo()) {
            score += 1;
        }

        System.out.println("Question 3:\nHow many times have you fed the cat?");
        latestChoice = GameMainDrive.intChoice(you.catFood + 10);
        if (latestChoice == you.catFood) {
            score += 1;
        }

        GameMainDrive.eepy(500);

        switch (score) {
            case 0:
                System.out.println("You failed!");
                GameMainDrive.eepy(500);
                System.out.println("A crushing sense of guilt washes over you. You lose 90% of your HP!");
                you.changeHealth(-1 * (int)Math.floor(you.getHealth() * .9));
                break;
            case 3:
                System.out.println("You got everything correct! Well done!");
                GameMainDrive.eepy(500);
                System.out.println("You heal for 50% of your current HP and your DMG increases by 1!");
                you.changeHealth((int)Math.floor(you.getHealth() * .50));
                break;
            default:
                System.out.println("You got something correct...");
                GameMainDrive.eepy(500);
                System.out.println("You heal for 1 HP and increase your accuracy by 10%!");
                you.changeHealth(1);
                you.baseAcc += .1;
                break;
        }
        

    }

    public void theAlchemist(Player you) {

        int playerChoice;

        System.out.println("A mysterious alchemist looks at you bashfully, it's Sucrose from Genshin Impact???"); // you can change this if u want, i wasnt sure what to do

        GameMainDrive.eepy(500);

        System.out.println("\"I can make you stronger... for a price.\"");

        GameMainDrive.eepy(500);

        System.out.println("1. Trade 2 HP for +1 DMG\n Trade 10% accuracy for 2 HP\n Decline the offer");

        playerChoice = GameMainDrive.intChoice(3);

        // TODO: finish this stuff
        switch (playerChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public void hungryCat(Player you) {

        int playerChoice;
        int lostHp;

        System.out.println("A stray cat wanders toward you with an empty bowl, you hear its stomach growl.");

        GameMainDrive.eepy(500);

        System.out.println("1. Feed the cat (Lose 10% of your HP, reduce difficulty by 1).\n2. Don't feed the cat. (Nothing happens)");

        playerChoice = GameMainDrive.intChoice(2);

        // If first choice is chosen, lose 10% HP and reduce difficulty by 1
        if (playerChoice == 1) {

            lostHp = (int)Math.ceil(you.getHealth() * 0.1);

            System.out.println("You feed the cat and lose " + lostHp + " HP.");

            you.changeHealth(-1 * lostHp);

            System.out.println("The cat is very grateful and purrs at your leg. Your difficulty is reduced by 1.");

            you.catFood += 1;

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

        GameMainDrive.eepy(500);

        System.out.println("1. Let Lynn inspect you (Chance to gain 100% HP or lose 50% HP).\n2. Wave her off (Chance to lose 30% HP).");

        playerChoice = GameMainDrive.intChoice(2);

        if (playerChoice == 1) {

            // 50/50 chance to be healed or lose hp
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
                System.out.println("Lynn surprisingly shrugs it off and flies back up, your limbs are still in tact. You got lucky...");

            }

        }
    }
}
