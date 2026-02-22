package Items;

import java.util.HashMap;
import java.util.Map;

public class ChooseItem {
    private static final Map<String,ItemBehaviour> behaviours=new HashMap<>();

    static {
        behaviours.put("info", new RoyalBadge());
        behaviours.put("heal", new Medkit());
        behaviours.put("key", new DataKey());
        behaviours.put("hint", new HoloScanner());
    }

    public static ItemBehaviour getBehaviour(String type){
        return behaviours.getOrDefault(type,new DefaultBehaviour());
    }
}