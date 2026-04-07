package NoMuscle;

public class Event {

    private double probCoef;
    public Entity containedFight;
    public Occurence containedOcc;

    Event() {
        probCoef = 1;
        containedFight = new Entity();
        containedOcc = new Occurence();

    }


}
