package Game;

import Characters.Spongebob;
import Command.*;
import Command.CommandManager;
import Planets.Planet;

import java.util.Scanner;

/**
 * Třída implementující hlavní herní smyčku, zpracovává vstupy a řídí průběh
 * hry.
 *
 * @author Shuleski Mihail
 */
public class Hra {
    private Spongebob spongebob;
    private GameData world;
    private Scanner scanner = new Scanner(System.in);
    private CommandManager commandManager = new CommandManager();
    private boolean checkWin = false;
    private boolean running = true;

    /**
     * Inicializuje herní data a vytváří instanci hráče.
     * Načítá GameData z JSON konfigurace, a nastaví příkazy do CommandManageru.
     */
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
        commandManager.addCommand("konec", new KonecCommand(() -> running = false));
    }

    /**
     * Prověřuje, zda se podařilo shromáždit podmínky k výhře hry (získání klíče a
     * obsazení Galactic Core).
     */
    private void checkWinCondition() {
        Planet core = world.findPlanet("galactic_core");
        if (core != null && core.isConquered()) {
            checkWin = true;
        }
    }

    /**
     * Zapíná hlavní herní smyčku, ve které vypisuje stav hry a akceptuje
     * uživatelské příkazy.
     */
    public void start(){
        inicialization();
        System.out.println();
        System.out.println("Spongebob, Ovládnutí galaxie");
        System.out.println("---------------");
        System.out.println("Jsi na: " + world.findPlanet(spongebob.getCurrentPlanet()).getName());
        System.out.println("Prikazy: jdi, mluv, prozkoumej, vezmi, pouzij, hadanka, inventar,konec");
        System.out.println();
        while (running) {
            if (spongebob.getHealth() <= 0) {
                System.out.println("Zemrel jsi. Konec hry.");
                break;
            }
            if (checkWin && spongebob.isCheckWin()) {
                System.out.println("Vyhral jsi! Ovládl jsi galaxii!");
                break;
            }
            Planet p = world.findPlanet(spongebob.getCurrentPlanet());
            System.out.print("HP: " + spongebob.getHealth() + " | " + p.getName() + " > ");

            try {
                String input = scanner.nextLine();
                if (input != null)
                    input = input.trim();
                if (input != null && !input.isEmpty()) {
                    commandManager.processCommand(input);
                } else {
                    System.out.println("Zadal jsi prázdný příkaz. Zkus to znovu.");
                }
            } catch (Exception e) {
                System.out.println("Došlo k chybě při čtení vstupu. Ukončuji hru.");
                break;
            }
            checkWinCondition();
        }
    }



}
