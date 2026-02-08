package Command;

import Characters.Spongebob;
import Items.Item;
import Planets.Planet;

public class ProzkoumejCommand implements Command{
    Spongebob spongebob;
    public ProzkoumejCommand(){
    }
    public void setSpongebob(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        Planet current=spongebob.getCurrentPlanet();
        String planetId=parts[1];
        for (int i= 2;i<parts.length;i++){ //pokud ma planeta vice jak 1 slovo treba Terra Prime tak se z toho udela string z tech dvou slov
            planetId += " "+ parts[i];
        }
        String planet1=normalizeInput(planetId);

        System.out.println("Prozkoumáváš planetu: " + current.getName());
        System.out.println(current.getInfo());
        if (current.hasUnsolved()) {
            System.out.println("Na planetě jsou furt hadanky");
        }
        if (!current.getItems().isEmpty()){
            System.out.println("Vidíš itemy: ");
            for (Item item:current.getItems()){
                System.out.println("- "+current.getName());
            }
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
