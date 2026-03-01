package Inventory;

import Items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void pridatItem() {
        Item item = new Item("test_item");
        inventory.pridatItem(item);
        assertNotNull(inventory.findItem("test_item"), "Inventory should contain the added item.");
    }

    @Test
    void odebratItem() {
        Item item = new Item("test_item");
        inventory.pridatItem(item);
        inventory.odebratItem(item);
        assertNull(inventory.findItem("test_item"), "Inventory should not contain the item after removal.");
    }
}
