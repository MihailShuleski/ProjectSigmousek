package Inventory;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private int capacity=3;
    public ArrayList<Item> items=new ArrayList<>(capacity);

    public void pridatItem(Item item){
        items.add(item);
        System.out.println("Byl přidán item: "+item.getName());

    }
    public void odebratItem(Item item){
        items.remove(item);
        System.out.println("Byl odebran item: "+item.getName());
    }
    public void inventar(){
        if(items.isEmpty()){
            System.out.println("Inventář je prázdný :(");
        }else {
            System.out.println("Inventář: ");
            for(int i=0;i<items.size();i++){
                System.out.println("- "+items.get(i).getName());
            }
        }
    }
    public void hasItem(Item item){
        if (items.contains(item)){
            System.out.println("Ano,máte tenhle item,chtěli byste ho použít? ");
        }else {
            System.out.println("Bohužel tenhle item nemáte :(");
        }
    }
}
