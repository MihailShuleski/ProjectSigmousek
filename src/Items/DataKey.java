package Items;

import Characters.Spongebob;

public class DataKey implements ItemBehaviour {


    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Použil jsi: "+item.getName());
    }
}