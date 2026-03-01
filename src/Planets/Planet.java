package Planets;

import Characters.NPC.NPC;
import Characters.Spongebob;
import Items.Item;
import Puzzles.Puzzle;

import java.util.ArrayList;

/**
 * Třída reprezentující herní lokaci (Planetu), její sousedy, inventář a
 * nepřátele.
 *
 * @author Shuleski Mihail
 */
public class Planet {
    private String id;
    private String name;
    private String info;
    private boolean conquered= false;
    private ArrayList<String> neighbours=new ArrayList<>();
    private ArrayList<Item> items=new ArrayList<>();
    private ArrayList<NPC> npcs=new ArrayList<>();
    private ArrayList<Puzzle> puzzles=new ArrayList<>();
    private String enemyId;

    /**
     * Konstruktor pro planetu.
     *
     * @param id   Identifikátor planety
     * @param name Cílový název planety
     * @param info Kratší popis dané planety
     */
    public Planet(String id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public String getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(String enemyId) {
        this.enemyId = enemyId;
    }


    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    /**
     * Indikuje, zda-li je planeta obsazená hráčem a má poraženého nepřítele.
     *
     * @return true pokud ano
     */
    public boolean isConquered() {
        return conquered;
    }

    public ArrayList<String> getNeighbours() {
        return neighbours;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setConquered(boolean conquered) {
        this.conquered = conquered;
    }


    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    /**
     * Umožňuje zisk a manipulaci s hádankami přiřazenými na planetě.
     *
     * @return Seznam hádanek na planetě
     */
    public ArrayList<Puzzle> getPuzzles() {
        if (puzzles == null) {
            puzzles = new ArrayList<>();
        }
        return puzzles;
    }

    /**
     * Pokud se zde vyskytuje hledaný item, vymaže ho ze seznamu.
     *
     * @param id Textové iD itemu
     * @return Odstraněný item, případně null.
     */
    public Item removeItem(String id){
        for (Item item :items ){
            if  (item.getId().equals(id)){
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    /**
     * Vyhledá item podle identifikátoru, pokud tu existuje.
     *
     * @param id ID předmětu
     * @return Hledaný předmět, jinak null
     */
    public Item findItem(String id) {
        for (Item i : items) {
            if (i.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Upozorňuje, zdali je nezodpovězena nějaká hádanka pro tohoto nepřítele.
     *
     * @return True pokud je na planetě alespoň jedna hádanka
     */
    public boolean hasUnsolved(){
        return !puzzles.isEmpty();
    }
}