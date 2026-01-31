package Command;

import Characters.Spongebob;
import Items.Item;

public class VezmiCommand implements Command{
    Spongebob spongebob=new Spongebob();
    @Override
    public void execute(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Musíš napsat co chceš vzít(Ex. vezmi *item*");
            return;
        }

        Item item = new Item(parts[1]) {
            @Override
            public void pouzij(Spongebob spongebob) {//zatim takhle, nez pridam logiku cele hry
            }
        };
        spongebob.getInventory().pridatItem(item);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
