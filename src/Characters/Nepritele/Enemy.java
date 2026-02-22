package Characters.Nepritele;

public class Enemy {
    private String id;
    private String name;
    private int hp;
    private String dialogue;

    public Enemy(String id, String name, int hp, String dialogue) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.dialogue = dialogue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getDialogue() {
        return dialogue;
    }
    public void vypisDialog() {
        System.out.println(getName() + " (" + getHp() + " HP):");
        System.out.println(getDialogue());
    }

    public void udelatDamage(){};


}