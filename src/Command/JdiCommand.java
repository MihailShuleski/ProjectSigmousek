package Command;

import Characters.Spongebob;
import Planets.Planet;


public class JdiCommand implements Command{
    private Spongebob spongebob;
    public JdiCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }

    @Override
    public void execute(String[] parts) {
        if(parts.length<2){
            System.out.println("Musíš napsat kam jít(Ex. jdi *planeta*");
            return;
        }
        String planet=parts[1];
        for (int i= 2;i<parts.length;i++){ //pokud ma planeta vice jak 1 slovo treba Terra Prime tak se z toho udela string z tech dvou slov
            planet += " "+ parts[i];
        }
        String planet1=normalizeInput(planet);
        Planet current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet());


        if (current.getNeighbours().contains(planet1)) {

            spongebob.setCurrentPlanet(planet1);

            Planet newPlanet = spongebob.getData().findPlanet(planet1);
            System.out.println("Dorazil jsi na: " + newPlanet.getName());

        } else {
            System.out.println("Na tuto planetu nemuzes cestovat.");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}