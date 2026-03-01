package Command;

import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Game.Hra;
import Planets.Planet;
import Puzzles.Puzzle;

import java.util.Random;
import java.util.Scanner;

/**
 * Příkaz pro spuštění hádanky s nepřítelem na dané planetě.
 * Pokud je hádanka zodpovězena správně, udělí nepříteli zranění.
 *
 * @author Shuleski Mihail
 */
public class HadankaCommand implements Command{
    Spongebob spongebob;

    /**
     * Konstruktor pro příkaz hádanky.
     *
     * @param spongebob Odkaz na hlavního hrdinu
     */
    public HadankaCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    /**
     * Spustí proces hádání. Vybere náhodnou hádanku a vyhodnotí útok.
     *
     * @param parts Zadaný příkaz
     */
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
                if (enemy.getHp() <= 0) {
                    System.out.println("Nepřítel na této planetě (" + enemy.getName() + ") je již poražen!");
                    System.out.println("Planeta je už ovládnuta a není třeba odpovídat na další hádanky.");
                    return;
                }

                System.out.println("Před tebou stojí " + enemy.getName() + " (" + enemy.getHp() + " HP).");
                enemy.vypisDialog();
                System.out.println();
            }
        }

        Random rd = new Random();

        Puzzle puzzle = p.getPuzzles().get(rd.nextInt(spongebob.getIndex()));
        puzzle.start(puzzle,p,spongebob);
        spongebob.setIndex(spongebob.getIndex()-1);

        if (p.getEnemyId() != null && !p.getEnemyId().isEmpty()) {
            Enemy enemy = spongebob.getData().findEnemy(p.getEnemyId());
            if (enemy != null && enemy.getHp() <= 0 && !p.isConquered()) {
                System.out.println("Porazil jsi nepřítele a ovládl jsi planetu!!");
                p.setConquered(true);
                spongebob.setIndex(10);
            }
        }
    }

    /**
     * Určuje, zda tento příkaz ukončuje hru.
     *
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}