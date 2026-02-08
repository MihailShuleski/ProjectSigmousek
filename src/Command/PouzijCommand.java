package Command;

import Characters.Spongebob;
import Items.Item;

public class PouzijCommand implements Command{
    Spongebob spongebob;
    public PouzijCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        if (parts.length<2){
            System.out.println("Musíš napsat co chceš použít(Ex. pouzij *item*");
            return;
        }
        String itemID=parts[1];
        for (int i= 2;i<parts.length;i++){
            itemID += " "+ parts[i];
        }
        Item item=spongebob.getInventory().getItem(itemID);
        if (item.equals(null)){
            System.out.println("Tenhle item nemáš");
            return;
        }
        



    }

    @Override
    public boolean exit() {
        return false;
    }
}
