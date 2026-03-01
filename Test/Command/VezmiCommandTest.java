package Command;

import Characters.Spongebob;
import Game.GameData;
import Items.Item;
import Planets.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class VezmiCommandTest {

    Spongebob spongebob;
    Planet location;
    VezmiCommand vezmiCommand;

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
            return map.get(id);
        }
    }

    FakeWorld fakeWorld;

    @BeforeEach
    void setUp() {
        location = new Planet("terra_prime", "Terra Prime", "Start");

        Item lekarnicka = new Item("lekarnicka");
        location.getItems().add(lekarnicka);

        fakeWorld = new FakeWorld();
        fakeWorld.add(location);

        spongebob = new Spongebob(fakeWorld, "terra_prime");
        vezmiCommand = new VezmiCommand(spongebob);
    }

    @Test
    void execute() {
        String[] parts = { "vezmi", "lekarnicka" };
        vezmiCommand.execute(parts);
        assertNotNull(spongebob.getInventory().findItem("lekarnicka"));
        assertNull(location.findItem("lekarnicka"));
    }
}
