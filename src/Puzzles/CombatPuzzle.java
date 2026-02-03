package Puzzles;

import Puzzles.Text.PuzzleLoader;

import java.util.ArrayList;

public class CombatPuzzle extends Puzzle{
    public CombatPuzzle( String question, String correctAnswer, String type, int damage) {
        super(question, correctAnswer, damage);
    }
    PuzzleLoader puzzleLoader=new PuzzleLoader();
    ArrayList<Puzzle> combatPuzzles;
    String res="/PuzzlesKragg.text";
    public void loadPuzzles(){
        puzzleLoader.loadPuzzle(res,combatPuzzles);
    }

}
