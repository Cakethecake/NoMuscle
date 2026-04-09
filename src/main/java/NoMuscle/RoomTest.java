package NoMuscle;

public class RoomTest {
    public static void main(String[] args) {
        Event e1  = new Event("Combat");
        Event e2  = new Event("Encounter");
        Event e3  = new Event("Item");

        Event[] events = {e1,e2,e3};

        Room room = new Room("test room", events);

        //Test Values
        System.out.println("room Name: " + room.getName());

        System.out.println("Events inside room:");
        for (Event e : room.getEventsInside()) {
            System.out.println(e.getName());
        }
        //Test method
        Event triggered = room.enterRoom();

        System.out.println("triggered Event: " + triggered.getName());
    }
}
