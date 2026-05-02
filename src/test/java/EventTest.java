import NoMuscle.Event;
import NoMuscle.GameMainDrive;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {

    @Before
    public void setUp() {
        // GameMainDrive.you is never null so nothing needed here
    }

    @Test
    public void testProbCoefficientAssignment() {
        int initialProb = 10;
        Event event = new Event(initialProb);
        assertTrue("Coefficient should not exceed initial value",
                event.getProbCoefficient() <= initialProb);
    }

    @Test
    public void testMutualExclusivity() {
        for (int i = 0; i < 50; i++) {
            Event event = new Event(10);
            if (event.fightOrOccurrence == 0) {
                assertNotNull(event.containedFight);
                assertNull(event.containedOccurrence);
            } else {
                assertNotNull(event.containedOccurrence);
                assertNull(event.containedFight);
            }
        }
    }

    @Test
    public void testToString() {
        Event event = new Event(5);
        String name = event.toString();
        assertNotNull(name);
        assertFalse("ToString should return the Entity or Occurrence name", name.isEmpty());
    }

    @Test
    public void testCoefficientReduction() {
        boolean reductionFound = false;
        for (int i = 0; i < 100; i++) {
            Event event = new Event(10);
            if (event.fightOrOccurrence == 1) {
                int id = event.containedOccurrence.ID;
                if ((id == 3 || id == 6) && event.getProbCoefficient() == 10) {
                    reductionFound = true;
                    break;
                }
            }
        }
        assertTrue("Coefficient reduction not found", reductionFound);
    }
}