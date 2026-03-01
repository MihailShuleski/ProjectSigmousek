package Items;

import Characters.Spongebob;

/**
 * Třída reprezentující herní předmět s vlastnostmi jako je ID, název, typ a
 * info.
 * Poskytuje metodu použití, která se odvíjí od konkrétního ItemBehaviour.
 *
 * @author Shuleski Mihail
 */
public class Item {
    private String id;
    private String name;
    private String type;
    private String info;

    /**
     * Vytvoří nový instanci předmětu pomocí jeho ID.
     *
     * @param id Hlavní identifikátor předmětu
     */
    public Item(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    /**
     * Zpracuje uživatelské použití předmětu přesunem na příslušný ItemBehaviour.
     *
     * @param spongebob Cílová postava
     */
    public void pouzij(Spongebob spongebob){
        ItemBehaviour behaviour=ChooseItem.getBehaviour(type);
        behaviour.pouzij(this,spongebob);
    }
};