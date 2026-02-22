package Items;

import Characters.Spongebob;

public class DataKey implements ItemBehaviour {


    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        if (spongebob.getCurrentPlanet().equals("galactic_core")) {
            System.out.println("Aktivoval jsi hlavni system!");
        } else {
            System.out.println("Tady to nema efekt.");
        }
}}