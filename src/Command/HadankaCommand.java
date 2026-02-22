package Command;

import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Game.Hra;
import Planets.Planet;
import Puzzles.Puzzle;

import java.util.Scanner;

public class HadankaCommand implements Command{
    Spongebob spongebob;
    public HadankaCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    @Override
    public void execute(String[] parts) {

        Planet p = spongebob.getData().findPlanet(spongebob.getCurrentPlanet());

        if (p.getPuzzles().isEmpty()) {
            System.out.println("Na této planetě už žádná hádanka není.");
            return;
        }
        if (p.getEnemyId() != null && !p.getEnemyId().isEmpty()) {
            Enemy enemy = spongebob.getData().findEnemy(p.getEnemyId());
            if (enemy != null) {
                System.out.println("Před tebou stojí " + enemy.getName() + " (" + enemy.getHp() + " HP).");
                enemy.vypisDialog();
                System.out.println();
            }
        }


        Puzzle puzzle = p.getPuzzles().get(0);
        puzzle.start();

        Scanner sc = new Scanner(System.in);
        System.out.print("Odpověď: ");
        String input = sc.nextLine();

        if (puzzle.checkAnswer(input)) {
            System.out.println("Správně!");
            p.getPuzzles().remove(puzzle);
            p.setConquered(true);
        } else {
            System.out.println("Špatně!");
            spongebob.damage(puzzle.getDamage());
            System.out.println("Ztratil jsi " + puzzle.getDamage() + " HP");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}