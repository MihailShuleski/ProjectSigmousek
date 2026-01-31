package Characters;

import Game.GameData;
import Inventory.Inventory;

public class Spongebob {
    private String name="Spongebob" ;
    private int health=100;
    Inventory inventory=new Inventory();
    private String currentPlanet="terra_prime";
    GameData data = GameData.loadGameDataFromResources("/gamedata.json");

    public void setCurrentPlanet(String currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getCurrentPlanet() {
        return currentPlanet;
    }

    public GameData getData() {
        return data;
    }
}
