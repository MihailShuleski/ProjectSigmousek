package Items;

import Characters.Spongebob;

public class Medkit implements ItemBehaviour{


    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        spongebob.heal(30);
        System.out.println("Použil jsi: "+item.getName());
    }
}