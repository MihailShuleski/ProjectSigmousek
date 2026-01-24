package Game;

import Characters.Spongebob;
import Command.*;
import Command.CommandManager;

import java.util.HashMap;

public class Hra {
    private Spongebob spongebob;
    private GameData world;
    private HashMap<String, Command> commands;


    public void inicialization(){
        commands=new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        commands.put("pohyb", new JdiCommand(spongebob));
        //TODO pridat metodu aby se hra zacala a nacetla commands do mapy
    }
    public void start(){
        inicialization();
        //Tohle bude fajn schovat do nějaké třídy, ve které budeme pracovat se všemi daty a hráčem
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");
//
//        //Zkouška, zdali načtení proběhlo v pořádku
        System.out.println("Items: " + data.items.size());
        System.out.println("Enemies: " + data.enemies.size());
        System.out.println("Planets: " + data.planets.size());
        System.out.println("NPCS: " + data.npcs.size());
//
//        //Nalezení konkrétní lokace, se kterou je pak možno dále pracovat
        System.out.println("Start planeta: " + data.findPlanet("terra_prime").getName());




    }
    static void processCommand(){
        //TODO pridat metodu aby hra upoznala jaky chce uzivateli pouzit prikaz
    }
    static boolean checkWin(){
        return false;
    }
}
