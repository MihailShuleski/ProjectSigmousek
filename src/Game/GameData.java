package Game;

import Characters.NPC.NPC;
import Characters.Nepritele.Enemy;
import Items.Item;
import Planets.Planet;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameData {
    public ArrayList<Item> items;
    public ArrayList<Enemy> enemies;
    public ArrayList<Planet> planets;
    public ArrayList<NPC> npcs;


    public static GameData loadGameDataFromResources(String resourcePath){
        Gson gson= new Gson();

        try (InputStream is=GameData.class.getResourceAsStream(resourcePath)){
            if (is == null){
                throw new IllegalStateException("Nenalezen resource: "+ resourcePath + "(zkontrolujte, že soubor je v src/main/resources).");
            }
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );
        } catch (Exception e){
            throw new RuntimeException("Chyba při načítání JSON"+e.getMessage());
        }
    }
    //finds a planet by its text ID
    public Planet findPlanet(String id){
        for (Planet p : planets) {
            if (p.getId().equals(id)) return p;
        }
        throw new IllegalArgumentException("Neexistuje planeta s id: "+id);
    }
    public NPC findNpc(String id){
        for (NPC npc : npcs) {
            if(npc.getId().equals(id)) return npc;
        }
        throw new IllegalArgumentException("Neexistuje npc s id: "+id);
    }
}
