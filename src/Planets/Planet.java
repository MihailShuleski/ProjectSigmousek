package Planets;

import Characters.NPC.NPC;
import Items.Item;
import Puzzles.Puzzle;

import java.util.ArrayList;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setConquered(boolean conquered) {
        this.conquered = conquered;
    }

    public void setNeighbours(ArrayList<String> neighbours) {
        this.neighbours = neighbours;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Puzzle> getPuzzles() {
        if (puzzles == null) {
            puzzles = new ArrayList<>();
        }
        return puzzles;
    }
    public Item removeItem(String id){
        for (Item item :items ){
            if  (item.getId().equals(id)){
                items.remove(item);
                return item;
            }
        }
        return null;
    }
    public Item findItem(String id) {
        for (Item i : items) {
            if (i.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    public boolean hasUnsolved(){
        return !puzzles.isEmpty();
    }
}