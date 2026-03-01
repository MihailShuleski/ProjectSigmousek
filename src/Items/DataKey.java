package Items;

import Characters.Spongebob;

/**
 * Třída pro předmět DataKey, sloužící k vítězství ve hře po nalezení.
 * Ukonči hru
 *
 * @author Shuleski Mihail
 */
public class DataKey implements ItemBehaviour {

    /**
     * Zpracování použití datového klíče na konkrétní planetě.
     *
     * @param item      Aktuální předmět (Klíč)
     * @param spongebob Odkaz na hrdinu
     */
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        if (spongebob.getCurrentPlanet().equals("galactic_core")) {
            System.out.println("Aktivoval jsi hlavni system!");
            spongebob.setCheckWin(true);
        } else {
            System.out.println("Tady to nema efekt.");
        }
}}