package Game;

import Characters.Spongebob;
import Command.*;
import Command.CommandManager;
import Puzzles.CombatPuzzle;

import java.util.Scanner;

public class Hra {
    private Spongebob spongebob;
    private GameData world;
    Scanner scanner=new Scanner(System.in);
    CommandManager commandManager = new CommandManager();
    boolean checkWin=false;
    CombatPuzzle combatPuzzle=new CombatPuzzle();


    public void inicialization(){
        world = GameData.loadGameDataFromResources("/gamedata.json");
        commandManager.addCommand("jdi",new JdiCommand());
        commandManager.addCommand("mluv",new MluvCommand(spongebob));
        commandManager.addCommand("prozkoumej",new ProzkoumejCommand());
        commandManager.addCommand("vezmi",new VezmiCommand(spongebob));
        commandManager.addCommand("pouzij",new PouzijCommand(spongebob));
        commandManager.addCommand("hadanka",new HadankaCommand());

    }
    public void start(){
        inicialization();
        combatPuzzle.loadPuzzles();
        System.out.println(combatPuzzle.getCombatPuzzles());
        while (checkWin == false){
            System.out.print("Zadejte příkaz: ");
            String input= scanner.nextLine();
            commandManager.processCommand(input);
        }




    }



}
