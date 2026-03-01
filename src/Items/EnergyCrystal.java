package Items;

import Characters.Spongebob;

/**
 * Třída pro předmět EnergyCrystal, sloužící k dvojnásobení poškození hádanky.
 *
 * @author Shuleski Mihail
 */
public class EnergyCrystal implements ItemBehaviour {
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Předmět " + item.getName()
                + " nelze přímo použít. Funguje automaticky při správné odpovědi na hádanku, zdvojnásobuje poškození.");
    }
}


