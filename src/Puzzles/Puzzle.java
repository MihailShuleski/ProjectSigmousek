package Puzzles;

public class Puzzle {
    private String question;
    private String correctAnswer;
    private int damage; //kazda hadanka bude delat jiny pocet damage ig

    public Puzzle(String question, String correctAnswer, int damage) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void start(){
        System.out.println("Hádanka: ");
        System.out.println(question);

    }
    public boolean checkAnswer(String answer){
        return answer.equalsIgnoreCase(answer);
    }

}
