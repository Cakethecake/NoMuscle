package NoMuscle;

public class Event {
    private int probCoefficient;
    public Entity containedFight;
    public Occurence containedOccurrence;

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
