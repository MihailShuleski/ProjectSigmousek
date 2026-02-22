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
        Planet current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet());
        if (parts.length < 2) {
            System.out.println("Musíš napsat co chceš vzít(Ex. vezmi *item*");
            return;
        }
        String itemID=parts[1];

        for (int i= 2;i<parts.length;i++){
            itemID += " "+ parts[i];
        }
        String itemId1=normalizeInput(itemID);
        Item foundItem=null;
        for (Item item : current.getItems()) {
            if (item.getId().equals(itemId1)) {
                foundItem = item;
                break;
            }
        }
        if (foundItem == null) {
            System.out.println("Tento item tu není.");
            return;
        }

        current.getItems().remove(foundItem);
        spongebob.getInventory().pridatItem(foundItem);

        System.out.println("Vzal jsi: " + foundItem.getName());
    }

    @Override
    public boolean exit() {
        return false;
    }
}