package Puzzles;

import Puzzles.Text.PuzzleLoader;

import java.util.ArrayList;

public class Puzzle {
    PuzzleLoader puzzleLoader=new PuzzleLoader();
    private final String question;
    private final String correctAnswer;
    private final int damage; //kazda hadanka bude delat jiny pocet damage ig


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

    public void loadPuzzle(String res) {

    }

}
