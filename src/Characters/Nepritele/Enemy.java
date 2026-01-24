package Characters.Nepritele;

public class Enemy {
    private String id;
    private String name;
    private int hp;
    private String dialogue;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getHp() {
        return hp;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void udelatDamage(){
        //TODO pridat metodu pro delani Damage
    }
    public void utocit(){
        //TODO pridat metodu pro delani Damage Spongebobovi jestli Spongebob hadanku neda
    }
}
