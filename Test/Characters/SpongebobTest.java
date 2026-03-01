package Characters;

import Game.GameData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpongebobTest {

    Spongebob spongebob;
    GameData fakeWorld;

    @BeforeEach
    void setUp() {
        fakeWorld = new GameData();
        spongebob = new Spongebob(fakeWorld, "terra_prime");
    }

    @Test
    void getHealth() {
        assertEquals(100, spongebob.getHealth(), "Spongebob should start with 100 HP");
    }

    @Test
    void heal() {
        spongebob.heal(20);
        assertEquals(120, spongebob.getHealth(), "Spongebob should have 120 HP after healing 20");
    }
}
