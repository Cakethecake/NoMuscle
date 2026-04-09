package NoMuscle;

public class Event {
    Event thisEvent; // idk what this is
    private int probCoeficient;
    public Item getItem;

    /**
     * Event class with no parameters - normal events are 60%
     */
    public Event() {
        this.probCoeficient = 60;
    }

    public int getProbCoeficient() {
        return probCoeficient;
    }


    public void applyEvent(){
        thisEvent.doThing();
    } // this too

    public void doThing() {
    }
}
