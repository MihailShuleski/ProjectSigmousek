package Puzzles.Text;
import Puzzles.Puzzle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleLoader {
    ArrayList<Puzzle> puzzles=new ArrayList<>();

    public void loadPuzzle(String resourcePath) {
        String question;
        String correctAnswer;
        int damage;
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


