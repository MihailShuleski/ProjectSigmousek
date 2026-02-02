package Game;

import Characters.Spongebob;
import Command.*;
import Command.CommandManager;
import java.util.Scanner;

public class Hra {
    private Spongebob spongebob;
    private GameData world;
    Scanner scanner=new Scanner(System.in);
    CommandManager commandManager = new CommandManager();
    boolean checkWin=false;


    public void inicialization(){
        spongebob=new Spongebob();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        commandManager.addCommand("jdi",new JdiCommand(spongebob));
        commandManager.addCommand("mluv",new MluvCommand(spongebob));
        commandManager.addCommand("prozkoumej",new ProzkoumejCommand(spongebob));
        commandManager.addCommand("vezmi",new VezmiCommand(spongebob));
        commandManager.addCommand("pouzij",new PouzijCommand(spongebob));
        commandManager.addCommand("hadanka",new HadankaCommand(spongebob));

    }
    public void start(){
        inicialization();
        while (checkWin == false){
            System.out.print("Zadejte příkaz: ");
            String input= scanner.nextLine();
            commandManager.processCommand(input);
        }









    }



}
