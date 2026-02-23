package Puzzles;

import Characters.Spongebob;
import Command.JdiCommand;
import Game.GameData;
import Planets.Planet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleTest {
    Spongebob spongebob;
    Puzzle puzzle;
    JdiCommand jdiCommand;

    private static class FakeWorld extends GameData{
        private final ArrayList<Puzzle> puzzles=new ArrayList<>();
        void add(Puzzle puzzle){
            puzzles.add(puzzle);
        }
    }


    @Test
    void start() {
    }
}