package Puzzles.Text;
import Puzzles.CombatPuzzle;
import Puzzles.Puzzle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PuzzleLoader {

    public void loadPuzzle(String resourcePath,List<Puzzle> puzzles) {
        String question;
        String correctAnswer;
        int damage;
        puzzles=new ArrayList<>();
        try (BufferedReader br=new BufferedReader(new FileReader(resourcePath))) {
            do {
                question = br.readLine();
                correctAnswer = br.readLine();
                damage = Integer.parseInt(br.readLine());
                puzzles.add(new Puzzle(question, correctAnswer, damage));
            } while ((question = br.readLine()) != null);
            } catch (FileNotFoundException e) {
                System.out.println("Soubor " + resourcePath + " neexistuje");
            } catch (IOException e) {
                System.out.println("Problem se souborem: " + resourcePath);
            }
        }

    };


