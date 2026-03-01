package Command;

import Characters.Spongebob;
import Inventory.Inventory;

/**
 * Příkaz sloužící pro výpis předmětů v inventáři hráče.
 *
 * @author Shuleski Mihail
 */

public class InventarCommand implements Command{
    Spongebob spongebob;

    /**
     * Konstruktor pro příkaz inventáře.
     *
     * @param spongebob Odkaz na postavu hráče pro vypsání jejího inventáře
     */
    public InventarCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Vypíše všechny itemy obsažené v inventáři.
     *
     * @param parts Zadaný příkaz (volitelné argumenty nejsou zpracovávány)
     */
    @Override
    public void execute(String[] parts) {
        spongebob.getInventory().inventar();
    }

    /**
     * Určuje, zda tento příkaz ukončuje hru.
     *
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}
