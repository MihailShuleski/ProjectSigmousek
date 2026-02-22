package Command;

import Characters.Spongebob;
import Inventory.Inventory;

public class InventarCommand implements Command{
    Spongebob spongebob;
    public InventarCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    @Override
    public void execute(String[] parts) {
        spongebob.getInventory().inventar();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
