package Puzzles;

public class Puzzle {
    private String id;
    private String type;
    private String question;
    private String correctAnswer;
    private int damage; //kazda hadanka bude delat jiny pocet damage ig



    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public String getId() {
        return id;
    }


    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDamage() {
        return damage;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Puzzle(String id,String type, String question, String correctAnswer, int damage) {
        this.id = id;
        this.type=type;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.damage = damage;
    }

    public void showPuzzle(){
        //TODO metoda pro ukazovani hadanky
    }
    public void checkAnswer(){
        //TODO pridat metodu pro kontrolovani odpoved
    }
}
