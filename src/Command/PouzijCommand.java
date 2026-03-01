package Command;

import Characters.Spongebob;
import Items.Item;

/**
 * Příkaz pro použití itemu z inventáře hráče.
 *
 * @author Shuleski Mihail
 */
public class PouzijCommand implements Command{
    Spongebob spongebob;

    /**
     * Konstruktor pro příkaz použít.
     *
     * @param spongebob Objekt hráče
     */
    public PouzijCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Zformátuje zadaný text od uživatele tak, aby odpovídal vnitřnímu ID.
     *
     * @param input Název předmětu
     * @return Zformátované ID předmětu
     */
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }

    /**
     * Pokusí se použít zadaný předmět z inventáře. Pokud je použit, odebere se z
     * inventáře (pokud není definováno jinak).
     *
     * @param parts Příkaz a jeho parametry
     */
    @Override
    public void execute(String[] parts) {
        if (parts.length<2){
            System.out.println("Musíš napsat co chceš použít(Ex. pouzij *item*");
            return;
        }
        String itemID=parts[1];
        for (int i= 2;i<parts.length;i++){
            itemID += " "+ parts[i];
        }
        String id=normalizeInput(itemID);
        Item item=spongebob.getInventory().findItem(id);
        if (item == null){
            System.out.println("Tenhle item nemáš");
            return;
        }
        item.pouzij(spongebob);
        spongebob.getInventory().odebratItem(item);


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