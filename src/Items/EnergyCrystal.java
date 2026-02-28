package Items;

import Characters.Spongebob;

public class EnergyCrystal implements ItemBehaviour {
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Předmět " + item.getName()
                + " nelze přímo použít. Funguje automaticky při správné odpovědi na hádanku, zdvojnásobuje poškození.");
    }
}


