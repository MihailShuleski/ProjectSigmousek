package Command;

import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Game.Hra;
import Planets.Planet;
import Puzzles.Puzzle;

import java.util.Random;
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
            if (enemy.getHp()<=0){
                System.out.println("Ovládl jsi planetu!!");
                p.setConquered(true);
                spongebob.setIndex(10);
            }
        }


        Random rd = new Random();


        Puzzle puzzle = p.getPuzzles().get(rd.nextInt(spongebob.getIndex()));
        puzzle.start(puzzle,p,spongebob);
        spongebob.setIndex(spongebob.getIndex()-1);


    }

    @Override
    public boolean exit() {
        return false;
    }
}