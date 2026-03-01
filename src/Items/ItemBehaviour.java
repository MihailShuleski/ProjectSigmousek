package Items;

import Characters.Spongebob;

/**
 * Rozhraní definující společnou strukturu pro chování předmětů po jejich
 * použití z inventáře hráče.
 * Lze flexibilně rozšiřovat pro implementaci dalších efektů itemů.
 *
 * @author Shuleski Mihail
 */
public interface ItemBehaviour {

    /**
     * Aplikuje předmět a jeho logiku daným třídám.
     *
     * @param item      Cílový předmět s načtenými údaji (jméno atd.)
     * @param spongebob Uživatel (Hráč), jenž ho aplikuje
     */
    void pouzij(Item item, Spongebob spongebob);
}