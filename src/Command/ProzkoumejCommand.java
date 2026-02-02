package Command;

import Characters.Spongebob;
import Planets.Planet;

public class ProzkoumejCommand implements Command{
    Spongebob spongebob;
    public ProzkoumejCommand(Spongebob spongebob){
        this.spongebob=spongebob;}
    @Override
    public void execute(String[] parts) {
        String planetId = spongebob.getCurrentPlanet();
        Planet planet = spongebob.getData().findPlanet(planetId);

        System.out.println("Prozkoumáváš planetu: " + planet.getName());
        System.out.println(planet.getInfo());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
