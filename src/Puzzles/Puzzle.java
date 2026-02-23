package Puzzles;

import Characters.Spongebob;
import Planets.Planet;

import java.util.Scanner;

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
    public void start(Puzzle puzzle, Planet p, Spongebob spongebob){
        System.out.println("Hádanka: ");
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        System.out.print("Odpověď: ");
        String input = sc.nextLine();

        if (input != null && answer != null && input.trim().equalsIgnoreCase(answer.trim())) {
            System.out.println("Správně!");
            p.getPuzzles().remove(puzzle);
            p.setConquered(true);
        } else {
            System.out.println("Špatně!");
            spongebob.damage(puzzle.getDamage());
            System.out.println("Ztratil jsi " + puzzle.getDamage() + " HP");
        }
    }




    }

