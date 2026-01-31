package Items;

import Characters.Spongebob;

public abstract class Item {
    private String id;
    private String name;
    private String type;
    private String info;

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

    public abstract void pouzij(Spongebob spongebob);

}
