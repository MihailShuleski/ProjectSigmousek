package Items;

import java.util.HashMap;
import java.util.Map;

public class ChooseItem {
    private static final Map<String,ItemBehaviour> behaviours=new HashMap<>();

    static {
        behaviours.put("medkit",new Medkit());
        behaviours.put("datový_klíč_galaxie",new DataKey());
        behaviours.put("holografický_skener",new HoloScanner());
    }

    public static ItemBehaviour getBehaviour(String type){
        return behaviours.getOrDefault(type,new DefaultBehaviour());
    }
}