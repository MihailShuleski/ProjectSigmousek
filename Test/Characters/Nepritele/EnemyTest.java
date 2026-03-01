package Characters.Nepritele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    Enemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new Enemy("boss", "Velký Boss", 100, "Zemřeš!");
    }

    @Test
    void setHp() {
        enemy.setHp(50);
        assertEquals(50, enemy.getHp(), "Enemy's HP should be updated to 50.");
    }
}
