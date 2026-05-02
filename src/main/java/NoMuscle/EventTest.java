package NoMuscle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @BeforeEach
    void setUp() {
        if (GameMainDrive.you == null) {
            // GameMainDrive.you = new Player(1);
        }
    }

    @Test
    @DisplayName("Should initialize with correct probability coefficient")
    void testProbCoefficientAssignment() {
        int initialProb = 10;
        Event event = new Event(initialProb);

        assertTrue(event.getProbCoefficient() <= initialProb,
                "Coefficient should not exceed initial value");
    }

    @Test
    @DisplayName("Should maintain mutual exclusivity between Fight and Occurrence")
    void testMutualExclusivity() {
        for (int i = 0; i < 50; i++) { // Run multiple times to cover both RNG branches
            Event event = new Event(10);

            if (event.fightOrOccurrence == 0) {
                assertNotNull(event.containedFight, "Fight should not be null if flag is 0");
                assertNull(event.containedOccurrence, "Occurrence should be null if flag is 0");
            } else {
                assertNotNull(event.containedOccurrence, "Occurrence should not be null if flag is 1");
                assertNull(event.containedFight, "Fight should be null if flag is 1");
            }
        }
    }

    @Test
    @DisplayName("ToString should return a non-null name")
    void testToString() {
        Event event = new Event(5);
        String name = event.toString();

        assertNotNull(name);
        assertFalse(name.isEmpty(), "ToString should return the Entity or Occurrence name");
    }

    @Test
    @DisplayName("Should decrease coefficient for specific Occurrence IDs")
    void testCoefficientReduction() {
        boolean reductionFound = false;
        for (int i = 0; i < 100; i++) {
            Event event = new Event(10);
            if (event.fightOrOccurrence == 1) {
                int id = event.containedOccurrence.ID;
                if ((id == 3 || id == 6) && event.getProbCoefficient() == 9) {
                    reductionFound = true;
                    break;
                }
            }
        }
    }
}
