package NoMuscle;
/*
Name: Jamieson Moore
 */
import java.util.Random;

public class Room {

    private Random RNG = new Random();
    private RoomNames name;
    private Event[] eventsInside;
    private double[] eventProbs;

    //  Default constructor (for driver obv)
    public Room() {
        this.name = RoomNames.values()[RNG.nextInt(RoomNames.values().length - 1)];

        Event e1 = new Event(RNG.nextInt(4));
        Event e2 = new Event(RNG.nextInt(4));
        Event e3 = new Event(RNG.nextInt(4));

        this.eventsInside = new Event[]{e1, e2, e3};
        this.eventProbs = new double[]{0.33, 0.33, 0.34};
    }

    // Main constructor
    public Room(Event[] eventsInside, double[] eventProbs) {
        this.name = RoomNames.values()[RNG.nextInt(RoomNames.values().length - 1)];
        this.eventsInside = eventsInside;
        this.eventProbs = eventProbs;
    }

    public RoomNames getName() {
        return name;
    }

    public Event[] getEventsInside() {
        return eventsInside;
    }

    public double[] getEventProbs() {
        return eventProbs;
    }

    public Event enterRoom() {
        double randomValue = RNG.nextDouble();

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