package Planets;

import Characters.Nepritele.Enemy;

import java.util.ArrayList;

public class Planet {
    private String id;
    private String name;
    private String info;
    private String enemy;
    private boolean conquered;
    private ArrayList<String> neighbours;
    private ArrayList<String> items;
    private ArrayList<String> npcs;

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getEnemy() {
        return enemy;
    }

    public boolean isConquered() {
        return conquered;
    }

    public ArrayList<String> getNeighbours() {
        return neighbours;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<String> getNpcs() {
        return npcs;
    }

    public void prozkoumej(){
        //TODO pridat metodu pro prozkoumani planety
    }
    public void zacitBoj(){
        //TODO pridat metodu pro zacinani fightu
    }
    public void ovladni(){
        //TODO pridat metodu pro ovladnuti dane planety
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

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public void setConquered(boolean conquered) {
        this.conquered = conquered;
    }

    public void setNeighbours(ArrayList<String> neighbours) {
        this.neighbours = neighbours;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public void setNpcs(ArrayList<String> npcs) {
        this.npcs = npcs;
    }
}
