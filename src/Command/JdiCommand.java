package Command;

import Characters.Spongebob;
import Planets.Planet;


public class JdiCommand implements Command{
    private Spongebob spongebob;
    public JdiCommand(){
    }
    public void setSpongebob(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    CommandManager commandManager=new CommandManager();
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
      Planet current=spongebob.getCurrentPlanet();


        if (!current.isConquered()) {
            System.out.println("Nejdřív dokonči tuto planetu.");
            return;
        }

        if (!current.getNeighbours().contains(planet1)) {
            System.out.println("Na tuto planetu se odsud nedá jít.");
            return;
        }

        Planet next = spongebob.getData().findPlanet(planet1);
        spongebob.moveTo(next);

        System.out.println("Dorazil jsi na planetu: " + next.getName());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
