package NoMuscle;
import java.util.Scanner;

public class GameMainDrive {

    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);

        while (true) {

            Player you = GameMainDrive.gameIntro();

            while (you.health > 0) {

                Room room1 = new Room();
                Room room2 = new Room();
                Room room3 = new Room();

                System.out.println("Three rooms are before you, where do you go? (Enter the room number)");
                System.out.println();
            }

            System.out.println("This is the end of everything... But not you.");
            System.out.println("Would you like to play again?");

        }


    }

    /**
    This method plays the intro and asks for a name, this is called when the game starts or
    the player dies.
     */
    public static Player gameIntro() {
        Scanner userIn = new Scanner(System.in);

        System.out.println("---------NO-MUSCLE---------");
        System.out.println("A CLI game inspired by NO-SKIN by NOEYE SOFT");
        System.out.println("Made for CMSC 255 by Jax, Jamie, Lynn, Caique, Angelique, and Haya");
        System.out.println("");
        System.out.print("Enter a player name to start: ");

        Player you = new Player(userIn.nextLine());

        return you;
    }
}
