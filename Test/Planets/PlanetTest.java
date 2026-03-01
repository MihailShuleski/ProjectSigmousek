package Planets;

import Items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    Planet planet;

    @BeforeEach
    void setUp() {
        planet = new Planet("terra_prime", "Terra Prime", "Start");
    }

    @Test
    void removeItem() {
        planet.getItems().add(new Item("klic"));
        Item removed = planet.removeItem("klic");
        assertNotNull(removed, "Removed item should not be null.");
        assertNull(planet.findItem("klic"), "Planet should no longer contain the removed item.");
    }

    @Test
    void setConquered() {
        assertFalse(planet.isConquered(), "Planet should not be conquered initially.");
        planet.setConquered(true);
        assertTrue(planet.isConquered(), "Planet should be conquered after setConquered(true).");
    }
}