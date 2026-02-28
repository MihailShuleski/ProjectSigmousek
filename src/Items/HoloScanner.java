package Items;

import Characters.Spongebob;

public class HoloScanner implements ItemBehaviour{
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Předmět " + item.getName()
                + " nelze přímo použít. Funguje automaticky při dalším průchodu (skener odhaluje skryté předměty).");
    }
}
