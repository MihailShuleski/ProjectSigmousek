package Characters;

import Game.GameData;
import Inventory.Inventory;

public class Spongebob {
    private String name ;
    private int health;
    Inventory inventory;
    private String currentPlanet;
    GameData data = GameData.loadGameDataFromResources("/gamedata.json");

    public Spongebob() {
        this.name = "Spongebob";
        this.health = 100;
        this.currentPlanet = "terra_prime";
        this.inventory=new Inventory();
    }

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

    public String heal(int index){
        health+=index;
        return "HP: "+health;
    }
}
