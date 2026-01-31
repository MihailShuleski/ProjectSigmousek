package Command;

import Characters.Spongebob;


public class JdiCommand implements Command{
    private final Spongebob spongebob;
    public JdiCommand(Spongebob spongebob){
        this.spongebob = spongebob;
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
      String current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getName();//String aby se napsala nazev current planety a ne id

      if (spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getNeighbours().contains(planet1)){
          spongebob.setCurrentPlanet(planet1);
          current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getName();
          System.out.println("Úspěšně jste cestovali na planetu: " + current);
      } else if (spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getId().equals(planet1)) {
          System.out.println("Nemužete cestovat na danou planetu,jelikož už tam jste :)");
      } else {
          System.out.println("Na tuto planetu nelze cestovat z aktualni planety: "+current);
      }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
