package NoMuscle;

/*
Name: Jamieson Moore
*/

import java.util.Random;

public class Room {

    private final Random RNG = new Random();
    private final RoomNames name;
    private final Event[] eventsInside;
    private final double[] eventProbs;

    // Default constructor (used by driver)
    public Room() {
        // FIXED: removed "- 1" so all room names are possible
        this.name = RoomNames.values()[RNG.nextInt(RoomNames.values().length)];

        Event e1 = new Event(RNG.nextInt(4));
        Event e2 = new Event(RNG.nextInt(4));
        Event e3 = new Event(RNG.nextInt(4));

        this.eventsInside = new Event[]{e1, e2, e3};
        this.eventProbs = new double[]{0.33, 0.33, 0.34};
    }

    // Main constructor (clean and safe I hope)
    public Room(Event[] eventsInside, double[] eventProbs) {

        if (eventsInside == null || eventProbs == null) {
            throw new IllegalArgumentException("Events or probabilities cannot be null");
        }

        if (eventsInside.length != 3 || eventProbs.length != 3) {
            throw new IllegalArgumentException("Room must have exactly 3 events");
        }

        this.name = RoomNames.values()[RNG.nextInt(RoomNames.values().length)];
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
        double randomValue = Math.random();
        double cumulative = 0;

        for (int i = 0; i < eventProbs.length; i++) {
            cumulative += eventProbs[i];
            if (randomValue <= cumulative) {
                return eventsInside[i];
            }
        }

        return eventsInside[0]; // fallback
    }

    @Override
    public String toString() {
        return "Room: " + name + " | Events: " + eventsInside.length;
    }
}