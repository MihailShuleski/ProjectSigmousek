package Puzzles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PuzzleLoader {

    public static void loadPuzzle(String resourcePath,List<Puzzle> puzzles) {
        puzzles=new ArrayList<>();
        try (
                InputStream is = PuzzleLoader.class.getResourceAsStream(resourcePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
        ) {

            if (is == null) {
                System.out.println("Soubor " + resourcePath + " neexistuje");
                return;
            }

            String question;
            String answer;
            String damageLine;

            while ((question = br.readLine()) != null) {

                answer = br.readLine();
                damageLine = br.readLine();


                int damage = Integer.parseInt(damageLine);
                puzzles.add(new Puzzle(question, answer, damage));
            }

        } catch (IOException e) {
            System.out.println("Problém se souborem: " + resourcePath);
        }
    }

    };


