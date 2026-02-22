package Inventory;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private int capacity = 4;
    public ArrayList<Item> items = new ArrayList<>(capacity);

    public void pridatItem(Item item) {
        if (items.size() >= capacity) {
            System.out.println("Inventář je plný. Nemůžeš nic dalšího vzít.");
            return;
        }
        items.add(item);
        System.out.println("Vzal jsi: " + item.getName());
    }

    public void odebratItem(Item item) {
        if (items.remove(item)) {
        }}

    public void inventar() {
        if (items.isEmpty()) {
            System.out.println("Inventář je prázdný :(");
        } else {
            System.out.println("Inventář: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.println("- " + items.get(i).getName());
            }
        }
    }

    public void hasItem(Item item) {
        if (items.contains(item)) {
            System.out.println("Ano,máte tenhle item,chtěli byste ho použít? ");
        } else {
            System.out.println("Bohužel tenhle item nemáte :(");
        }
    }

    public Item findItem(String id) {
        for (Item i : items) {
            if (i.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }}