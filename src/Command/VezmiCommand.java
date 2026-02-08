package Command;

import Characters.Spongebob;
import Items.Item;
import Planets.Planet;

public class VezmiCommand implements Command{
    Spongebob spongebob;
    public VezmiCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Musíš napsat co chceš vzít(Ex. vezmi *item*");
            return;
        }
        String itemID=parts[1];
        for (int i= 2;i<parts.length;i++){
            itemID += " "+ parts[i];
        }
        String itemID1=normalizeInput(itemID);
        Planet current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet());
        Item item= current.removeItem(itemID1);
        if (item.equals(null)){
            System.out.println("Tento item není na planetě: "+current.getName());
        }
        spongebob.getInventory().pridatItem(item);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
