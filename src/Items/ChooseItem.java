package Items;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída sloužící k mapování typu předmětu na jeho konkrétní chování
 * (ItemBehaviour).
 *
 * @author Shuleski Mihail
 */
public class ChooseItem {
    private static final Map<String,ItemBehaviour> behaviours=new HashMap<>();

    static {
        behaviours.put("info", new RoyalBadge());
        behaviours.put("heal", new Medkit());
        behaviours.put("key", new DataKey());
        behaviours.put("scanner",new HoloScanner());
        behaviours.put("crystal",new EnergyCrystal());
    }

    /**
     * Získá přiřazené chování předmětu podle jeho textového typu.
     *
     * @param type Řetězec identifikující typ itemu
     * @return Specifická implementace ItemBehaviour (nebo DefaultBehaviour)
     */
    public static ItemBehaviour getBehaviour(String type){
        return behaviours.getOrDefault(type,new DefaultBehaviour());
    }
}