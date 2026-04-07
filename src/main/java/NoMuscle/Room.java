package NoMuscle;

public class Room {

    public String name;
    public Event[] eventsInside;
    public double[] eventProbs;

    Room() {
        name = "Test";
        eventsInside = new Event[3];
        eventProbs = new double[] {20, 10, 70};

    }

    Room(String name) {

        this.name = name;



    }
}
