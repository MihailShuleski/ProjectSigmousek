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

    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
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
    public void addNeighbour(String id){
        neighbours.add(id);
    }
    public boolean hasUnsolved(){
        return !puzzles.isEmpty();
    }
}
