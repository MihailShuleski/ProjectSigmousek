package Puzzles;

import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Planets.Planet;

import java.util.Scanner;

/**
 * Třída reprezentující hádanku na planetách, se schopností zranit nepřítele
 * nebo hráče.
 *
 * @author Shuleski Mihail
 */
public class Puzzle {
    private String id;
    private String question;
    private String answer;
    private int damage; //kazda hadanka bude delat jiny pocet damage ig

    public Puzzle(String id,String question, String answer, int damage) {
        this.id=id;
        this.question = question;
        this.answer = answer;
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public String getAnswer(){
        return answer;
    }
    public String getQuestion(){
        return question;
    }

    /**
     * Zpracovává logiku odpovědi hráče a vyhodnocení udělení poškození / odebrání
     * hp.
     * Aplikuje násobič z Energy Crystal v případě výhry nad nepřítelem.
     *
     * @param puzzle    Konkrétní řešená hádanka
     * @param p         Aktuální planeta hráče
     * @param spongebob Odkaz na hrdinu kvůli stavu HP a inventáře
     */
    public void start(Puzzle puzzle, Planet p, Spongebob spongebob){
        System.out.println("Hádanka: ");
        System.out.println(question);
        Scanner sc = Game.Hra.scanner;
        System.out.print("Odpověď: ");
        String input = sc.nextLine();

        if (input != null && answer != null && input.trim().equalsIgnoreCase(answer.trim())) {
            System.out.println("Správně!");
            p.getPuzzles().remove(puzzle);

            int finalDamage = puzzle.getDamage();
            if (spongebob.getInventory().findItem("energy_crystal") != null) {
                System.out.println("Máš Energy Crystal! Poškození je dvojnásobné!");
                finalDamage *= 2;
            }

            if (p.getEnemyId() != null && !p.getEnemyId().isEmpty()) {
                Enemy enemy = spongebob.getData().findEnemy(p.getEnemyId());
                if (enemy != null) {
                    enemy.setHp(enemy.getHp() - finalDamage);
                    System.out.println("Udělal jsi nepříteli " + finalDamage + " poškození! Nepříteli zbývá "
                            + enemy.getHp() + " HP.");
                } else {
                    p.setConquered(true);
                }
            } else {
                p.setConquered(true);
            }
        } else {
            System.out.println("Špatně!");
            spongebob.damage(puzzle.getDamage());
            System.out.println("Ztratil jsi " + puzzle.getDamage() + " HP");
        }
    }




    }

