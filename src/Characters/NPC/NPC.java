package Characters.NPC;

/**
 * Třída reprezentující nehráčskou postavu (NPC) ve hře.
 * Uchovává informace jako je ID, jméno a dialog.
 *
 * @author Shuleski Mihail
 */

public class NPC {
    private String id;
    private String name;
    private String dialogue;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        return dialogue;
    }

}