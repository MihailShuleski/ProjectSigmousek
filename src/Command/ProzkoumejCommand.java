package Command;

import Characters.NPC.NPC;
import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Items.Item;
import Planets.Planet;

/**
 * Příkaz pro vypsání informací o aktuální planetě hráče.
 * Vypíše název planety, sousední planety, předměty na planetě a NPC (včetně
 * nepřítele).
 *
 * @author Shuleski Mihail
 */
public class ProzkoumejCommand implements Command{
    Spongebob spongebob;

    /**
     * Konstruktor pro příkaz prozkoumej.
     *
     * @param spongebob Cílový hráč
     */
    public ProzkoumejCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Převede formátovaný vstup z konzole na interní ID.
     *
     * @param input Vstupní řetězec
     * @return Upravený vstupní řetězec bez mezer a malými písmeny
     */
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }

    /**
     * Zpracuje příkaz "prozkoumej" a vypíše detailní informace o stávající planetě.
     *
     *
     */
    @Override
    public void execute(String[] parts) {
        Planet planet = spongebob.getData().findPlanet(spongebob.getCurrentPlanet());

        System.out.println("Planeta: " + planet.getName());

        System.out.println("Sousedni planety:");
        for (String n : planet.getNeighbours()) {
            System.out.println("- " + spongebob.getData().findPlanet(n).getName());
        }

        if (planet.getItems().size()!=0) {
            System.out.println("Itemy:");
            for (Item item : planet.getItems()) {
                if (item.getId().equals("datový_klíč_galaxie")) {
                    if (spongebob.getInventory().findItem("holographic_scanner") != null) {
                        System.out.println("- " + item.getName());
                    }
                } else {
                    System.out.println("- " + item.getName());
                }
            }
        }

        System.out.println("NPC:");
        for (NPC npc : planet.getNpcs()) {
            System.out.println("- " + npc.getName());
        }
        if (planet.getEnemyId() != null && !planet.getEnemyId().isEmpty()) {
            Enemy e = spongebob.getData().findEnemy(planet.getEnemyId());
            if (e != null && !planet.getPuzzles().isEmpty()) {
                System.out.println("Nepřítel: " + e.getName() + " (" + e.getHp() + " HP)");
            }
        }
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