package Command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String,Command> commands;
    public CommandManager(){
        commands=new HashMap<>();
    }
    public void addCommand(String name,Command command){
        commands.put(name,command);
    }
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