package Items;

import Characters.Spongebob;

public class DefaultBehaviour implements ItemBehaviour{
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Tento předmět nelze použít.");
    }
}
