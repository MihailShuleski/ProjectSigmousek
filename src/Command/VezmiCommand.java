package Command;

import Characters.Spongebob;
import Items.Item;
import Planets.Planet;

/**
 * Příkaz pro sebrání předmětu z aktuální planety a jeho přidání do hráčova
 * inventáře.
 *
 * @author Shuleski Mihail
 */
public class VezmiCommand implements Command{
    Spongebob spongebob;

    /**
     * Konstruktor příkazu vezmi.
     *
     * @param spongebob Objekt hráče
     */
    public VezmiCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Normalizuje text na text použitelný jako ID předmětu (lowercase, místo mezer
     * potržítka).
     *
     * @param input Neupravený název předmětu z konzole
     * @return Interní ID
     */
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }

    /**
     * Zpracuje příkaz pro položení itemu z planety do hráčova inventáře. V případě
     * datových klíčů prověřuje potřebu Skeneru.
     *
     * @param parts Zadaný příkaz (první argument je příkaz, zbytek název předmětu)
     */
    @Override
    public void execute(String[] parts) {
        Planet current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet());
        if (parts.length < 2) {
            System.out.println("Musíš napsat co chceš vzít(Ex. vezmi *item*");
            return;
        }
        String itemID=parts[1];

        for (int i= 2;i<parts.length;i++){
            itemID += " "+ parts[i];
        }
        String itemId1=normalizeInput(itemID);
        Item foundItem=null;
        for (Item item : current.getItems()) {
            if (item.getId().equals(itemId1)) {
                foundItem = item;
                break;
            }
        }
        if (foundItem == null) {
            System.out.println("Tento item tu není.");
            return;
        }


        if (foundItem.getId().equals("datový_klíč_galaxie")) {
            if (spongebob.getInventory().findItem("holographic_scanner") == null) {
                System.out.println("Tento item tu není (možná je neviditelný, potřebuješ skener).");
                return;
            }
        }

        current.getItems().remove(foundItem);
        spongebob.getInventory().pridatItem(foundItem);

    }

    /**
     * Určuje, zda tento příkaz má za následek ukončení hry.
     *
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}