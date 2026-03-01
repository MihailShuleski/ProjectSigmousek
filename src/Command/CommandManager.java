package Command;

import java.util.HashMap;

/**
 * Správce všech dostupných příkazů.
 * Uchovává příkazy a spouští je na základě vstupu hráče.
 *
 * @author Shuleski Mihail
 */

public class CommandManager {
    private HashMap<String,Command> commands;

    /**
     * Konstruktor inicializující prázdný seznam příkazů.
     */
    public CommandManager(){
        commands=new HashMap<>();
    }

    /**
     * Přidá nový příkaz do správce.
     *
     * @param name    Název příkazu
     * @param command Instance příkazu
     */
    public void addCommand(String name,Command command){
        commands.put(name,command);
    }

    /**
     * Zpracuje uživatelský vstup a zavolá příslušný příkaz.
     *
     * @param input Celý řetězec zadaný uživatelem
     */
    public void processCommand(String input){
        String[] parts= input.split(" ");
        String commandName=parts[0];
        if(!commands.containsKey(commandName)){
            System.out.println("Neznamy prikaz. ");
            return;
        }else {
            commands.get(commandName).execute(parts);
        }
    }
}