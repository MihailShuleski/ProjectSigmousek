package Command;

import Characters.Spongebob;
import Inventory.Inventory;

public class InventarCommand implements Command{
    Spongebob spongebob;
    public InventarCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    Inventory inventory=new Inventory();

    @Override
    public void execute(String[] parts) {
        inventory.inventar();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
