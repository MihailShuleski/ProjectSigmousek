package Puzzles;

import Puzzles.Text.PuzzleLoader;

import java.util.ArrayList;

public class CombatPuzzle {

    PuzzleLoader puzzleLoader=new PuzzleLoader();
    ArrayList<Puzzle> combatPuzzles;
    public void loadPuzzles(){
        puzzleLoader.loadPuzzle("D:\\Shuleski C2c\\ProjectSigmousek\\res\\PuzzlesKragg",combatPuzzles);
    }

    public ArrayList<Puzzle> getCombatPuzzles() {
        return combatPuzzles;
    }
}
