package NoMuscle;
import java.util.Scanner;

public class GameMainDrive {

    public static void main(String[] args) {
        boolean keepPlaying = true;
        int roomChoice = 0;

        while (keepPlaying) {

            Player you = GameMainDrive.gameIntro();

            while (you.health > 0) {

                Room room1 = new Room();
                Room room2 = new Room();
                Room room3 = new Room();

                System.out.println("Three rooms are before you.");
                System.out.println();

                System.out.printf("1. %s\n2. %s\n 3. %s\n Where are you pulled to? (Enter the room number)", room1.getName(), room2.getName(), room3.getName());

                roomChoice = intChoice(3);


            }

            System.out.println("This is the end of everything... But not you.");
            System.out.println("Would you like to play again? (yes / no");

            if (strChoice().equals("no")) {
                keepPlaying = false;
            }

        }


    }

    /**
    This method plays the intro and asks for a name, this is called when the game starts or
    the player dies.
     */
    public static Player gameIntro() {

        System.out.println("---------NO-MUSCLE---------");
        System.out.println("A CLI game inspired by NO-SKIN by NOEYE SOFT");
        System.out.println("Made for CMSC 255 by Jax, Jamie, Lynn, Caique, Angelique, and Haya");
        System.out.println("");
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

        return choice;
    }

    public static String strChoice() {
        Scanner userIn = new Scanner(System.in);
        userIn.nextLine();
        return userIn.nextLine();
    }

    public void fight(Entity yourOpp) {

        boolean inFight = true;
        int turnAction = 0;

        while (inFight) {
            System.out.printf("%s Stands before you.\nWhat do you do\n", yourOpp.name);
            System.out.println("1. Use Knife\n2. Use Gun\n  3. Defend\n 4. Run");


        }
    }

    public void enterRoom(Room entered) {

    }
}
