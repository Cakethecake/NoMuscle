package NoMuscle;
/*
Name: Jamieson Moore
Room Test Class
 */

public class RoomTest {

    public static void main(String[] args) {

        try {
            // Create room using default constructor
            Room room = new Room();

            // Test name
            System.out.println("Room Name: " + room.getName());

            // Test events array
            System.out.println("Number of events: " + room.getEventsInside().length);

            // Test probabilities
            System.out.println("Event probabilities:");
            for (double p : room.getEventProbs()) {
                System.out.println(p);
            }

            // Test enterRoom()
            Event triggered = room.enterRoom();

            System.out.println("Event triggered successfully.");

            // Optional: check type of event
            if (triggered.containedFight != null) {
                System.out.println("Combat event.");
            } else if (triggered.containedOccurrence != null) {
                System.out.println("Encounter event.");
            } else {
                System.out.println("Other event.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating room: " + e.getMessage());
        }
    }
}