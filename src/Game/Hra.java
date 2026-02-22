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

    private void checkWinCondition() {
        Planet core = world.findPlanet("galactic_core");
        if (core != null && core.isConquered()) {
            checkWin = true;
        }
    }

    public void start(){
        inicialization();
        System.out.println();
        System.out.println("Spongebob, Ovládnutí galaxie");
        System.out.println("---------------");
        System.out.println("Jsi na: " + world.findPlanet(spongebob.getCurrentPlanet()).getName());
        System.out.println("Prikazy: jdi, mluv, prozkoumej, vezmi, pouzij, hadanka, inventar");
        System.out.println();
        while (true) {
            if (spongebob.getHealth() <= 0) {
                System.out.println("Zemrel jsi. Konec hry.");
                break;
            }
            if (checkWin) {
                System.out.println("Vyhral jsi! Ovládl jsi galaxii!");
                break;
            }
            Planet p = world.findPlanet(spongebob.getCurrentPlanet());
            System.out.print("HP: " + spongebob.getHealth() + " | " + p.getName() + " > ");
            String input = scanner.nextLine();
            if (input != null) input = input.trim();
            if (input != null && !input.isEmpty()) {
                commandManager.processCommand(input);
            }
            checkWinCondition();
        }




    }



}
