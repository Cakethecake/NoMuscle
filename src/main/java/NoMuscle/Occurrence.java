package NoMuscle;

public class Occurrence extends Event {

    protected String name;

    public Occurrence(String name) {

        this.name =name;
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
}
