package NoMuscle;
/*
Name: Jamieson Moore
 */
import java.util.Random;

public class Room {

    private String name;
    private Event[] eventsInside;
    private double[] eventProbs;

    //  Default constructor (for driver obv)
    public Room() throws IllegalArgumentException {
        this.name = "Default Room";

        Event e1 = new Event();
        Event e2 = new Event();
        Event e3 = new Event();

        this.eventsInside = new Event[]{e1, e2, e3};
        this.eventProbs = new double[]{0.33, 0.33, 0.34};
    }

    // Main constructor
    public Room(String name, Event[] eventsInside, double[] eventProbs) {
        this.name = name;
        this.eventsInside = eventsInside;
        this.eventProbs = eventProbs;
    }

    public String getName() {
        return name;
    }

    public Event[] getEventsInside() {
        return eventsInside;
    }

    public double[] getEventProbs() {
        return eventProbs;
    }

    public Event enterRoom() {
        Random rand = new Random();
        double randomValue = rand.nextDouble();

        double cumulative = 0;

        for (int i = 0; i < eventProbs.length; i++) {
            cumulative += eventProbs[i];
            if (randomValue <= cumulative) {
                return eventsInside[i];
            }
        }

        return eventsInside[0]; // fallback
    }
}