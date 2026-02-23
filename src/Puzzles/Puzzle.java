package Puzzles;

import Characters.Spongebob;
import Planets.Planet;

import java.util.Scanner;

public class Puzzle {
    private String id;
    private String question;
    private String correctAnswer;
    private int damage; //kazda hadanka bude delat jiny pocet damage ig

    public Puzzle(String id,String question, String correctAnswer, int damage) {
        this.id=id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
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

        if (input != null && correctAnswer != null && input.trim().equalsIgnoreCase(correctAnswer.trim())) {
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

