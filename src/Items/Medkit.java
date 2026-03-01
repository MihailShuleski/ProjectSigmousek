package Items;

import Characters.Spongebob;

/**
 * Chování pro předmět Medkit (lékárnička).
 * Při použití navýší HP vlastníkům.
 *
 * @author Shuleski Mihail
 */
public class Medkit implements ItemBehaviour{

    /**
     * Přidá hráči (Spongebob) zdraví (HP) po použití předmětu Medkit.
     *
     * @param item      Používaný Medkit
     * @param spongebob Cílový hráč k uzdravení
     */
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        spongebob.heal(30);
        System.out.println("Použil jsi: "+item.getName()+", +30 HP!!!");
    }
}