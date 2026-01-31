package Command;

import Characters.Spongebob;
import Game.Hra;

import java.util.Scanner;

public class JdiCommand implements Command{
    private Spongebob spongebob;
    public JdiCommand(Spongebob spongebob){
        this.spongebob = spongebob;
    }

    @Override
    public void execute(String[] parts) {
      if(parts.length<2){
          System.out.println("Musíš napsat kam jít(Ex. jdi *planeta*");
          return;
      }
      String planet=parts[1];
      if (spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getNeighbours().contains(planet)){
          spongebob.setCurrentPlanet(planet);
          System.out.println("Úspěšně jste cestovali na planetu: " + planet);
      }else {
          System.out.println("Na tuto planetu nelze cestovat z aktualni planety: "+spongebob.getCurrentPlanet());
      }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
