package Puzzles;

import Puzzles.Text.PuzzleLoader;

import java.util.ArrayList;

public class Puzzle {
    private String question;
    private String correctAnswer;
    private int damage; //kazda hadanka bude delat jiny pocet damage ig


    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDamage() {
        return damage;
    }

    public Puzzle(String question, String correctAnswer, int damage) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.damage = damage;
    }


}
