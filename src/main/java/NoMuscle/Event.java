package NoMuscle;

public class Event {
    private int probCoefficient;
    public Entity containedFight;
    public Occurrence containedOccurrence;

    /**
     * Event class with no parameters - throws illegal argument exception
     * because event MUST have parameters
     */
    public Event() throws IllegalArgumentException {

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
