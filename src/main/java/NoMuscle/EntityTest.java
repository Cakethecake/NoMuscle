package NoMuscle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    @Test
    public void testBossInitialization() {
        Entity boss = new Entity(10, true);
        assertEquals("NoMuscle Man", boss.name);
        assertEquals(10, boss.baseDmg);
        assertEquals(20, boss.baseHP);
    }

    @Test
    public void testGetAttacked() {
        Entity enemy = new Entity(1, false);
        int initialHP = enemy.currentHP;

        enemy.getAttacked(2);

        assertEquals(initialHP - 2, enemy.currentHP);
    }

    @Test
    public void testChargingLogic() {
        Entity enemy = new Entity(10, true);
        enemy.charging = true;

        int dmg = enemy.attackPlayer();

        assertEquals(17, dmg);
        assertFalse(enemy.charging, "Charging should be reset to false after attacking");
    }
}
