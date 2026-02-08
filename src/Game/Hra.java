package Game;

import Characters.Spongebob;
import Command.*;
import Command.CommandManager;
import Planets.Planet;
import Puzzles.PuzzleLoader;

import java.util.Scanner;

public class Hra {
    private Spongebob spongebob;
    private GameData world;
    Scanner scanner=new Scanner(System.in);
    CommandManager commandManager = new CommandManager();
    boolean checkWin=false;


    public void inicialization(){
        world = GameData.loadGameDataFromResources("/gamedata.json");
        commandManager.addCommand("jdi",new JdiCommand());
        commandManager.addCommand("mluv",new MluvCommand());
        commandManager.addCommand("prozkoumej",new ProzkoumejCommand());
        commandManager.addCommand("vezmi",new VezmiCommand());
        commandManager.addCommand("pouzij",new PouzijCommand());
        commandManager.addCommand("hadanka",new HadankaCommand());
        Planet mechaon = world.findPlanet("mechaon");
        PuzzleLoader.loadPuzzle("PuzzlesMechano.txt", mechaon.getPuzzles());
        Planet brutalis =world.findPlanet("brutalis");
        PuzzleLoader.loadPuzzle("/PuzzlesKragg.txt",brutalis.getPuzzles());
        Planet mentara= world.findPlanet("mentara");
        PuzzleLoader.loadPuzzle("/PuzzlesMyron.txt",mentara.getPuzzles());
        Planet core=world.findPlanet("galactic_core");
        PuzzleLoader.loadPuzzle("/PuzzlesMyron.txt",core.getPuzzles());

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
