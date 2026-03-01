package Command;

import Characters.Spongebob;
import Game.GameData;
import Planets.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JdiCommandTest {

    Spongebob spongebob;
    Planet location;
    Planet location2;
    JdiCommand jdiCommand;

    private static class FakeWorld extends GameData {
        private final HashMap<String, Planet> map = new HashMap<>();

        void add(Planet loc) {
            map.put(loc.getId(), loc);
            if (planets == null)
                planets = new ArrayList<>();
            planets.add(loc);
        }

        @Override
        public Planet findPlanet(String id) {
            Planet loc = map.get(id);
            if (loc == null) {
                throw new IllegalArgumentException("Neexistuje planeta s id: " + id);
            }
            return loc;
        }
    }

    FakeWorld fakeWorld;

    @BeforeEach
    void setUp() {
        location = new Planet("terra_prime", "Terra Prime", "Start");
        location2 = new Planet("mechaon", "Mechaon", "Tovarny");
        location.getNeighbours().add("mechaon");

        fakeWorld = new FakeWorld();
        fakeWorld.add(location);
        fakeWorld.add(location2);

        spongebob = new Spongebob(fakeWorld, "terra_prime");
        jdiCommand = new JdiCommand(spongebob);
    }

    @Test
    void execute() {
        String[] parts = { "jdi", "mechaon" };
        jdiCommand.execute(parts);
        assertEquals("mechaon", spongebob.getCurrentPlanet());
    }
}
