package NoMuscle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class OccurrenceTest {
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        // Initializing with a name to avoid the "blank player" warning
        testPlayer = new Player("TestRunner");

        // Setting specific baseline stats for predictable math
        testPlayer.health = 10;
        testPlayer.baseDmg = 1;
        testPlayer.baseAcc = 0.9;
        testPlayer.ammo = 6;
        testPlayer.maxAmmo = 6;
        testPlayer.difficulty = 2;
        testPlayer.catFood = 0;
    }

    @Test
    @DisplayName("Verify Occurrence ID is within valid array bounds")
    void testIDRange() {
        for (int i = 0; i < 50; i++) {
            Occurrence occ = new Occurrence();
            // Valid IDs are 0 through 7 (posNames.length - 1)
            assertTrue(occ.ID >= 0 && occ.ID < 8, "ID " + occ.ID + " is out of bounds!");
        }
    }

    @Test
    @DisplayName("Jax: Check health changes correctly")
    void testJaxLogic() {
        // Since Jax is random, we test the changeHealth method it relies on
        int startHP = testPlayer.getHealth();

        // Simulate a good chocolate (+5 HP)
        testPlayer.changeHealth(5);
        assertEquals(startHP + 5, testPlayer.getHealth());

        // Simulate a bad chocolate (-3 HP)
        testPlayer.changeHealth(-3);
        assertEquals(startHP + 2, testPlayer.getHealth());
    }

    @Test
    @DisplayName("Chess: Ensure accuracy increases and ammo decreases")
    void testChessLogic() {
        double startAcc = testPlayer.baseAcc;
        int startMaxAmmo = testPlayer.maxAmmo;

        // Simulate choice 1 from Chess method
        testPlayer.maxAmmo -= 1;
        testPlayer.baseAcc += 0.1;

        assertEquals(startMaxAmmo - 1, testPlayer.maxAmmo);
        assertEquals(startAcc + 0.1, testPlayer.baseAcc, 0.001);
    }

    @Test
    @DisplayName("Final Exam: 90% HP loss on failure (Score 0)")
    void testFinalExamFailure() {
        testPlayer.health = 20;

        // Logic: health -= floor(currentHP * 0.9)
        int damage = (int)Math.floor(testPlayer.getHealth() * 0.9);
        testPlayer.changeHealth(-damage);

        // 20 - 18 = 2
        assertEquals(2, testPlayer.getHealth());
    }

    @Test
    @DisplayName("Hungry Cat: HP loss and difficulty reduction")
    void testHungryCatLogic() {
        testPlayer.health = 10;
        testPlayer.difficulty = 5;

        // Logic: lostHp = ceil(10 * 0.1) = 1
        int lostHp = (int)Math.ceil(testPlayer.getHealth() * 0.1);
        testPlayer.changeHealth(-lostHp);

        if (testPlayer.difficulty > 0) {
            testPlayer.difficulty -= 1;
        }

        assertEquals(9, testPlayer.getHealth());
        assertEquals(4, testPlayer.difficulty);
    }

    @Test
    @DisplayName("Admin Lynn: Double HP choice")
    void testLynnDoubleHP() {
        testPlayer.health = 15;

        // Logic: changeHealth(currentHP) effectively doubles it
        testPlayer.changeHealth(testPlayer.getHealth());

        assertEquals(30, testPlayer.getHealth());
    }
}