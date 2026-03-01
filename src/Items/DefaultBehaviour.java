package Items;


import Characters.Spongebob;

/**
 * Základní (výchozí) chování pro předměty, které nemají specifický účinek na
 * použití.
 *
 * @author Shuleski Mihail
 */
public class DefaultBehaviour implements ItemBehaviour{

    /**
     * Vykoná základní logiku pro nepoužitelné itemy.
     *
     * @param item      Konkrétní předmět
     * @param spongebob Hráč, který se objekt pokusil použít
     */
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Tento předmět nelze použít.");
    }
}