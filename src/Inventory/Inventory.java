package Inventory;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private int capacity=5;
    public ArrayList<Item> Inventory=new ArrayList<>(capacity);

    public void pridatItem(){
        //TODO pridat metodu pro pridani prvku do inventare
    }
    public void odebratItem(){
        //TODO pridat metodu pro odebrani itemu
    }
    public void inventar(){
        //TODO pridat metodu pro ukazovani aktualni stav inventare
    }
    public void hasItem(){
        //TODO pridat metodu pro kontrolovani zda inventar ma dany item
    }
}
