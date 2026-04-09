package NoMuscle;
import java.util.Random;

public class HPOccurrence extends Occurrence {

    private int amount;
    //loss, gain, or gamble
    private String type;

    private Random rand = new Random();

    public HPOccurrence(String name, int costHP, Item reward) {
        super(name);
        this.amount = amount;
        thiis.type = type;
    }

    @Override
    public boolean canGive(Player player) {
        // only matters for loss/gamble
        if (type.equals("loss") || type.equals("Gamble")) {
            return player.getHP() > amount;
        }
        return true;
    }

    @Override
    public void extractCost(Player player) {
        // only for loss
        if (type.equals("Lost HP")) {
            player.loseHP(amount);
            System.out.println("You lost " + amount + "HP");
        }
    }
    @Override
    public void giveReward(Player player) {

        if (type.equals("Gain")) {
            player.gainHP(amount);
            System.out.println("You gained " + amount + "HP");

        } else if (type.equals("Gamble")) {

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
