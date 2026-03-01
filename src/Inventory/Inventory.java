package Inventory;

import Items.Item;

import java.util.ArrayList;

/**
 * Třída spravující inventář hráče a jeho kapacitu.
 *
 * @author Shuleski Mihail
 */
public class Inventory {
    private int capacity = 5;
    public ArrayList<Item> items = new ArrayList<>(capacity);

    /**
     * Přidá předmět do inventáře, pokud je k dispozici dostatečná kapacita.
     *
     * @param item Pokládaný předmět
     */
    public void pridatItem(Item item) {
        if (items.size() >= capacity) {
            System.out.println("Inventář je plný. Nemůžeš nic dalšího vzít.");
            return;
        }
        items.add(item);
        System.out.println("Vzal jsi: " + item.getName());
    }

    /**
     * Odstraní dříve uložený item z inventáře.
     *
     * @param item Předmět, který má být odstraněn
     */
    public void odebratItem(Item item) {
        if (items.remove(item)) {
        }}

    /**
     * Vypíše stávající obsah inventáře do konzole na pohled hráče.
     */
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

    /**
     * Zkontroluje a vypíše informaci o tom, zda hráč tento předmět drží.
     *
     * @param item Předmět obsažený v ověření
     */
    public void hasItem(Item item) {
        if (items.contains(item)) {
            System.out.println("Ano,máte tenhle item,chtěli byste ho použít? ");
        } else {
            System.out.println("Bohužel tenhle item nemáte :(");
        }
    }

    /**
     * Vrátí uložený item na základě specifického identifikátoru (ID), pro interní
     * použití aplikací.
     *
     * @param id Textový identifikátor
     * @return Platný Item z inventáře, jinak null
     */
    public Item findItem(String id) {
        for (Item i : items) {
            if (i.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }}