package Items;

import Characters.Spongebob;

/**
 * Třída pro předmět HoloScanner, sloužící k nálezení itemu DATAKEY.
 *
 *
 * @author Shuleski Mihail
 */
public class HoloScanner implements ItemBehaviour{
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Předmět " + item.getName()
                + " nelze přímo použít. Funguje automaticky při dalším průchodu (skener odhaluje skryté předměty).");
    }
}
