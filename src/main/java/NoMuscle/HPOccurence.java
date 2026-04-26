/** this code not used + i checked and it doesnt cause bug but i forgot how to delete it for everyone
 * package NoMuscle;

import java.util.Random;

class HPOccurrence extends Occurrence {

    private int amount;
    //lose, gain, or gamble
    private String type;

    private Random rand = new Random();

    public HPOccurrence(String name, int amount, String type) {
        super();
        this.amount = amount;
        this.type = type;
    }

    @Override
    public boolean canGive(Player player) {
        // only matters for loss/gamble
        if (type.equals("Lose HP") || type.equals("Gamble HP")) {
            return player.getHealth() > amount;
        }
        return true;
    }

    @Override
    public void extractCost(Player player) {
        // only for loss
        if (type.equals("Lose HP")) {
            player.changeHealth(-1 * amount);
            System.out.println("You lost " + amount + "HP");
        }
    }

    @Override
    public void giveReward(Player player) {

        if (type.equals("Gain HP")) {
            player.changeHealth(amount);
            System.out.println("You gained " + amount + "HP");

        } else if (type.equals("Gamble HP")) {

            if (rand.nextBoolean()) {
                player.changeHealth(amount);
                System.out.println("Lucky! You gained " + amount + "HP");
            } else {
                player.changeHealth(-1 * amount);
                System.out.println("Unlucky! You lost " + amount + "HP");
            }
        }
    }
}
 */

