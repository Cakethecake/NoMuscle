package NoMuscle;
import java.util.Scanner;

public class GameMainDrive {

    static Player you = new Player("first player run");

    public static void main(String[] args) {

        you = GameMainDrive.gameIntro(); // Fixed a bug where it kept looping yes/no question + intro
        boolean keepPlaying = true;
        int roomChoice = 0;

        while (keepPlaying) {

            boolean playerWon = false; // fixes scoping
            while (you.health > 0) {

                you.printProgress();

                eepy(1000);

                Room[] roomList = new Room[]{new Room(), new Room(), new Room()};

                System.out.println("Three rooms are before you. Each has three possibilities within.");
                System.out.println();
                eepy(200);

                for (int i = 0; i < 3; i++) {
                    System.out.print((i + 1) + ") " + roomList[i].getName());

                    for (int j = 0; j < 3; j++) {
                        System.out.printf("\n\t%.0f%%: ", roomList[i].getEventProbs()[j] * 100);
                        if (roomList[i].getEventsInside()[j].fightOrOccurrence == 0) {
                            System.out.print("Fight ");
                        } else {
                            System.out.print("Encounter ");
                        }
                        System.out.print(roomList[i].getEventsInside()[j].toString());

                    }

                    System.out.println();

                }

                System.out.println("Where are you pulled to? (Enter room number)");


                roomChoice = intChoice(3);

                System.out.printf("You go to the %s...\n", roomList[roomChoice - 1].getName());
                eepy(1000);

                // Enter a room and check if it is a fight or occurrence
                Event thisEvent = roomList[roomChoice - 1].enterRoom();
                if (thisEvent.fightOrOccurrence == 0) {
                    fight(thisEvent.containedFight);
                } else {
                    occur(thisEvent.containedOccurrence);
                }

                eepy(1000);

                // Increases the difficulty and increments game progress when the player finishes a room.
                // These must be tracked separately because of the Hungry Cat occurrence
                you.difficulty += 1;
                you.progress += 1;

                // Heals the player or increases their DMG every 3 and 4 stages respectively.
                // This is the only thing holding back awful balancing issues.
                if (you.progress % 3 == 0) {

                    System.out.println("You stop and rest, healing 2 HP");
                    you.changeHealth(2);

                }
                if (you.progress % 4 == 0) {

                    System.out.println("You feel yourself getting stronger, DMG increased by 1");
                    you.baseDmg += 1;

                }

                playerWon = false;

                // Boss battle when progress is at 100%
                if (you.progress == 16) {
                    System.out.println("You feel an overwhelming presence ahead... there is no turning back.");

                    eepy(500);

                    fight(new Entity((you.difficulty), true));

                    if (you.health > 0) {
                        System.out.println("The boss grunts in defeat as he falls to the floor, you did it...");

                        eepy(500);

                        System.out.println("It's finally over, you survived!");
                        playerWon = true;
                    }
                    break;
                }

                eepy(1000);

            }

            if (!playerWon) {

                System.out.println("This is the end of everything... But not you."); // so you dont get this message when u win

            }
            System.out.println("Would you like to play again? (yes / no)");

            if (strChoice().equals("no")) {
                System.out.println("Thank you for playing!");
                keepPlaying = false;
            } else {
                you = GameMainDrive.gameIntro(); // Should properly reset the player
            }

        }

    }

    /**
     * Helper method that makes the game pause for x milliseconds
     */
    public static void eepy(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {

        }
    }

    /**
    This method plays the intro and asks for a name, this is called when the game starts or
    the player dies.
     */
    public static Player gameIntro() {

        System.out.println("---------NO-MUSCLE---------");
        eepy(1000);
        System.out.println("A CLI game inspired by NO-SKIN by NOEYE SOFT");
        System.out.println("Made for CMSC 255 by Jax, Jamie, Lynn, Caique, and Haya");
        System.out.println("");
        eepy(1000);
        System.out.print("Enter a player name to start: ");

        Player you = new Player(strChoice());

        return you;
    }

    public static int intChoice(int numCanMake) {

        Scanner userIn = new Scanner(System.in);
        int choice;

        do {
            choice = userIn.nextInt();
        } while (choice < 1 || choice > numCanMake);
        userIn.nextLine(); // fixes bug with final exam

        return choice;
    }

    public static String strChoice() {
        Scanner userIn = new Scanner(System.in);
        return userIn.nextLine();
    }

    /**
     * This plays when entering a fight
     * @param yourOpp
     */
    public static void fight(Entity yourOpp) {

        boolean inFight = true;
        int turnAction = 0;
        int turnsTaken = 0;


        //Loop through this on every turn of the fight
        while (inFight) {

            System.out.print("\n===========================================================");
            System.out.printf("\n%s stands before you. ", yourOpp.name);
            yourOpp.printHP();

            // ONLY SHOWS IF IN DEBUG MODE
            if (you.debug) {
                System.out.println("Debug: Enemy has " + yourOpp.baseDmg + " base dmg");
            }

            eepy(500);

            // Present player options
            System.out.print("\nWhat do you do? ");
            you.printHP();
            eepy(500);

            System.out.printf("1. Use Knife (%d Damage, %.0f Accuracy)\n2. Use Gun (%d Damage, %.0f Accuracy)\n3. Reload Gun (%d/%d Ammo)\n4. Defend (Reduce damage taken to 1 this turn)\n5. Run\n",
                    you.getBaseDmg(), you.getBaseAcc() * 100, (int)Math.ceil(you.getBaseDmg() * 1.8), (you.getBaseAcc() - .1) * 100, you.getAmmo(), you.maxAmmo);

            turnAction = intChoice(5);
            boolean playerActed = false; // fixes double attack bug

            // Take the player's action
            switch (turnAction) {
                case 1:
                    yourOpp.getAttacked(you.attackKnife());
                    break;
                case 2:
                    yourOpp.getAttacked(you.attackGun());
                    break;
                case 3:
                    you.reload();
                    break;
                case 4:
                    System.out.println("You ready yourself for an attack...");

                    eepy(500);

                    you.changeHealth(-1 * you.defend(yourOpp));
                    playerActed = true;

                    break;
                case 5:
                    if (you.escape()) {
                        return;
                    }
                    break;
            }

            eepy(1000);

            // Checks if your enemy is dead. If not, they can act
            if (yourOpp.currentHP <= 0) {

                inFight = false;

            } else if (!playerActed) { // avoids being attacked twice when defend

                you.changeHealth(-1* yourOpp.attackPlayer());
                turnsTaken += 1;

            } else {

                you.changeHealth(-1 * yourOpp.attackPlayer());
                turnsTaken += 1;

            }


            // Checks if you are dead and ends the battle if so
            if (you.getHealth() <= 0) {
                return;
            }
        }


        // Uses a mediocre formula to determine the difficulty of the battle and rewards the player based on it
        System.out.printf("%s defeated!\n", yourOpp.name);

        int fightDiff = (int)Math.ceil((yourOpp.baseDmg + yourOpp.baseHP) + (turnsTaken / 2));

        if (fightDiff < (3 * you.getDifficulty())) {

            System.out.println("The fight was a breeze, healed 1 HP");
            you.changeHealth(1);

        }
    }

    public static void occur(Occurrence gambleRoom) {

        eepy(500);

        // Chooses the occurrence based on the ID it has.
        switch (gambleRoom.ID) {
            case 0:
                gambleRoom.Jax(you);
                break;

            case 1:
                gambleRoom.Chess(you);
                break;

            case 2:
                gambleRoom.Gojo(you);
                break;

            case 3:
                gambleRoom.finalExam(you);
                break;

            case 4:
                gambleRoom.theAlchemist(you);
                break;

            case 5:
                gambleRoom.hungryCat(you);
                break;

            case 6:
                gambleRoom.adminLynn(you);
                break;
            case 7:
                gambleRoom.dumpsterDiver(you);
                break;
        }


    }




}
