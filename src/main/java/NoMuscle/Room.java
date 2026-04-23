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

        // Changed: 0 does not apply.
        Event e1 = new Event(RNG.nextInt(3) + 1);
        Event e2 = new Event(RNG.nextInt(3) + 1);
        Event e3 = new Event(RNG.nextInt(3) + 1);

        this.eventsInside = new Event[]{e1, e2, e3};

        // Properly calculates the percentage
        double totalCoef = e1.getProbCoefficient() + e2.getProbCoefficient() + e3.getProbCoefficient();
        this.eventProbs = new double[]{
                e1.getProbCoefficient() / totalCoef,
                e2.getProbCoefficient() / totalCoef,
                e3.getProbCoefficient() / totalCoef
        };
    }

    // Main constructor (clean and safe I hope)
    public Room(Event[] eventsInside) {

        if (eventsInside == null) {
            throw new IllegalArgumentException("Events or probabilities cannot be null");
        }

        if (eventsInside.length != 3) {
            throw new IllegalArgumentException("Room must have exactly 3 events");
        }

        this.name = RoomNames.values()[RNG.nextInt(RoomNames.values().length)];
        this.eventsInside = eventsInside;

        // Properly calculates the percentage
        double totalCoef = eventsInside[0].getProbCoefficient() + eventsInside[1].getProbCoefficient() + eventsInside[2].getProbCoefficient();
        this.eventProbs = new double[]{
                eventsInside[0].getProbCoefficient() / totalCoef,
                eventsInside[1].getProbCoefficient() / totalCoef,
                eventsInside[2].getProbCoefficient() / totalCoef
        };
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