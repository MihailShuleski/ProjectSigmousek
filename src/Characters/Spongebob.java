package Characters;

import Game.GameData;
import Inventory.Inventory;
import Planets.Planet;

public class Spongebob {
    private GameData data;
    private int health=100;
    Inventory inventory=new Inventory();
    private String currentPlanet;

    public Spongebob(GameData data, String startPlanet) {
        this.data =data;
        this.currentPlanet=startPlanet;
    }

    public void setCurrentPlanet(String currentPlanet) {
        this.currentPlanet = currentPlanet;
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
    public void damage(int dmg){
        health -=dmg;
        System.out.println("Ztratil jsi: "+dmg+"HP ,zbývají ti: "+health);
        if(health<= 0){
            System.out.println("Zemřel jsi. Konec hry :(");
            System.exit(100);
        }
    }
    public void moveTo(String planet){
        currentPlanet=planet;
    }
}