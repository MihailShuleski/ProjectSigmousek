package Puzzles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PuzzleLoader {

    public static void loadPuzzle(String resourcePath, List<Puzzle> puzzles) {
        InputStream is = PuzzleLoader.class.getResourceAsStream(resourcePath);
        if (is == null) {
            System.out.println("Soubor nenalezen: " + resourcePath);
            return;
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String question;
            while ((question = br.readLine()) != null) {
                String answer = br.readLine();
                String damageLine = br.readLine();
                if (answer == null || damageLine == null) {
                    System.out.println("Chybný formát souboru: " + resourcePath);
                    break;
                }
                int damage = Integer.parseInt(damageLine.trim());
                puzzles.add(new Puzzle(question.trim(), answer.trim(), damage));
            }
        } catch (Exception e) {
            System.out.println("Chyba při čtení hádanek: " + e.getMessage());
        }
    }
}