package NoMuscle;
/*
Name: Jamieson Moore
 */
import java.util.Random;

public class Room {

    private String name;
    private Event[] eventsInside;

    public Room(String name, Event[] eventsInside) {
        this.name = name;
        this.eventsInside = eventsInside;
    }

    public String getName() {
        return name;
    }

    public Event[] getEventsInside() {
        return eventsInside;
    }

    public Event enterRoom() {
        Random rand = new Random();
        int index = rand.nextInt(eventsInside.length);
        return eventsInside[index];
    }
}