package Command;

import Characters.Spongebob;
import Planets.Planet;

/**
 * Příkaz pro přesun hráče na jinou planetu.
 * Kontroluje propojitelnost planet a stav nepřítele na aktuální planetě (musí
 * být poražen).
 *
 * @author Shuleski Mihail
 */
public class JdiCommand implements Command{
    private Spongebob spongebob;

    /**
     * Konstruktor pro příkaz jdi.
     *
     * @param spongebob Instance hráče
     */
    public JdiCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Normalizuje název planety (ořeže mezery, převede na malá písmena, mezery
     * nahradí podtržítkem).
     *
     * @param input Uživatelský název planety
     * @return Normalizovaný systémový identifikátor planety(id planety jak je v json souboru)
     */
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }

    /**
     * Zpracuje přesun hráče z aktuální planety na vybranou sousední.
     *
     * @param parts Zadaný příkaz obsahující cílovou lokaci (např. "jdi mechaon")
     */
    @Override
    public void execute(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Musíš napsat kam jít(Ex. jdi *planeta*");
            return;
        }
        String planet = parts[1];
        for (int i = 2; i < parts.length; i++) {  // Pokud ma planeta více jak 1 slovo,třeba Terra Prime, tak se z toho
                                                  // udela string z tech dvou slov
            planet += " " + parts[i];
        }
        String planet1 = normalizeInput(planet);
        Planet current = spongebob.getData().findPlanet(spongebob.getCurrentPlanet());


        if (!current.getNeighbours().contains(planet1)) {
            System.out.println("Na tuto planetu odtud nemůžeš cestovat.");
            return;
        }
        Planet planet2 = spongebob.getData().findPlanet(planet1);
        if (current.getEnemyId() != null && !current.getEnemyId().isEmpty() && !current.isConquered()) {
            System.out.println("Na " + current.getName() + " vládne nepřítel. Nejprve ho poraz (příkaz hadanka).");
            return;
        }
        spongebob.setCurrentPlanet(planet1);
        System.out.println("Dorazil jsi na: " + planet2.getName());
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