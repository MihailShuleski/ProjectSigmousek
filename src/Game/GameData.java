package Game;

import Characters.NPC.NPC;
import Characters.Nepritele.Enemy;
import Items.Item;
import Planets.Planet;
import Puzzles.Puzzle;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Třída zodpovědná za držení načtených herních dat.
 * Obsahuje metody pro vyhledávání entit jako jsou planety, nepřátelé a další.
 *
 * @author Pani učitelka Meitnerova
 */
public class GameData {
    public ArrayList<Item> items;
    public ArrayList<Enemy> enemies;
    public ArrayList<Planet> planets;
    public ArrayList<NPC> npcs;
    public ArrayList<Puzzle> puzzles;

    /**
     * Načte data hry (lokace, předměty, atd.) ze souboru z resources.
     *
     * @param resourcePath Cesta k JSON souboru v resources
     * @return Zkonstruovanou instanci GameData obsahující všechny herní informace
     */
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

    /**
     * Vyhledá planetu v uložených datech podle jejího unikátního identifikátoru
     * (textového id).
     *
     * @param id Identifikátor planety
     * @return Nalezená planeta
     * @throws IllegalArgumentException Pokud planeta neexistuje
     */
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
    public Enemy findEnemy(String id) {
        if (enemies == null) return null;
        for (Enemy e : enemies) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }
    public Puzzle findPuzzle(String id){
        if (puzzles == null) return null;
        for (Puzzle puzzle:puzzles){
            if (puzzle.getQuestion().equalsIgnoreCase(id))return puzzle;
        }
        throw new IllegalArgumentException("Neexistuje takova hadanka s id : "+id);
    }
}