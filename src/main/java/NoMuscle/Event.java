package NoMuscle;

import java.util.Random;

public class Event {
    private int probCoefficient;
    public Entity containedFight;
    public Occurrence containedOccurrence;
    private final Random RNG = new Random();
    public int fightOrOccurrence;

    /**
     * Event class with no parameters - throws illegal argument exception
     * because event MUST have parameters
     */
    public Event() throws IllegalArgumentException {
        throw new IllegalArgumentException("Event must have parameter >:(");
    }

    /**
     *
     * just stores and returns the coefficient
     *
     * @param probCoefficient
     */
    public Event(int probCoefficient) {
        this.probCoefficient = probCoefficient;

        /**
         * determines if the new event will have a fight or occurrence
         */

        this.fightOrOccurrence = RNG.nextInt(2);
        if (fightOrOccurrence == 0) {
            containedFight = new Entity();
            containedOccurrence = null;
        } else {
            containedOccurrence = new Occurrence();
            containedFight = null;
        }
    }

    /**
     * getProbCoefficient
     *
     * gets the probability coefficient for the event
     *
     * @return probability coefficient
     */
    public int getProbCoefficient() {
        return probCoefficient;
    }

}
