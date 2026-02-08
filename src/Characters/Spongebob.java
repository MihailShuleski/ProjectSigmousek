package Characters;

import Game.GameData;
import Inventory.Inventory;
import Planets.Planet;

public class Spongebob {
    private GameData data;
    private int health;
    Inventory inventory;
    private Planet currentPlanet;

    public Spongebob(GameData data, Planet startPlanet) {
        this.data =data;
        this.currentPlanet=startPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }


    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public GameData getData() {
        return data;
    }

    public String heal(int index){
        health+=index;
        return "HP: "+health;
    }
    public void damage(int dmg){
        health -=dmg;
        System.out.println("Ztratil jsi: "+dmg+"HP ,zbývají ti: "+health);
        if(health<= 0){
            System.out.println("Zemřel jsi. Konec hry :(");
            System.exit(100);
        }
    }
    public void moveTo(Planet planet){
        currentPlanet=planet;
    }
}
