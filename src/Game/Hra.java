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
        spongebob = new Spongebob(world, "terra_prime");


        commandManager.addCommand("jdi",new JdiCommand(spongebob));
        commandManager.addCommand("mluv",new MluvCommand(spongebob));
        commandManager.addCommand("prozkoumej",new ProzkoumejCommand(spongebob));
        commandManager.addCommand("vezmi",new VezmiCommand(spongebob));
        commandManager.addCommand("pouzij",new PouzijCommand(spongebob));
        commandManager.addCommand("hadanka",new HadankaCommand(spongebob));
        commandManager.addCommand("inventar",new InventarCommand(spongebob));
        Planet mechaon = world.findPlanet("mechaon");
        PuzzleLoader.loadPuzzle("/puzzles/mechano", mechaon.getPuzzles());
        Planet brutalis =world.findPlanet("brutalis");
        PuzzleLoader.loadPuzzle("/puzzles/kragg",brutalis.getPuzzles());
        Planet mentara= world.findPlanet("mentara");
        PuzzleLoader.loadPuzzle("/puzzles/myron",mentara.getPuzzles());
        Planet core=world.findPlanet("galactic_core");
        PuzzleLoader.loadPuzzle("/puzzles/nox",core.getPuzzles());


    }

    public void start(){
        inicialization();
        while (true) {
            if (spongebob.getHealth() <= 0) {
                System.out.println("Zemrel jsi. Konec hry.");
                break;
            }

            if (checkWin=false) {
                System.out.println("Vyhral jsi! Ovládl jsi galaxii!");
                break;
            }
            String input = scanner.nextLine();
            commandManager.processCommand(input);
        }




    }



}
