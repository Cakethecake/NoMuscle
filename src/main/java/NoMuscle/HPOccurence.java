package NoMuscle;

import java.util.Random;

public class HPOccurrence extends Occurrence {

    private int amount;
    //lose, gain, or gamble
    private String type;

    private Random rand = new Random();

    public HPOccurrence(String name, int amount, String type) {
        super(name);
        this.amount = amount;
        this.type = type;
    }

    @Override
    public boolean canGive(Player player) {
        // only matters for loss/gamble
        if (type.equals("Lose HP") || type.equals("Gamble HP")) {
            return player.getHP() > amount;
        }
        return true;
    }

    @Override
    public void extractCost(Player player) {
        // only for loss
        if (type.equals("Lose HP")) {
            player.loseHP(amount);
            System.out.println("You lost " + amount + "HP");
        }
    }

    @Override
    public void giveReward(Player player) {

        if (type.equals("Gain HP")) {
            player.gainHP(amount);
            System.out.println("You gained " + amount + "HP");

        } else if (type.equals("Gamble HP")) {

            if (rand.nextBoolean()) {
                player.gainHP(amount);
                System.out.println("Lucky! You gained " + amount + "HP");
            } else {
                player.loseHP(amount);
                System.out.println("Unlucky! You lost " + amount + "HP");
            }
        }
    }
}

