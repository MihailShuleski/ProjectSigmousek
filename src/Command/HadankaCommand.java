package Command;

import Characters.Spongebob;
import Game.Hra;

public class HadankaCommand implements Command{
    Spongebob spongebob;
    public HadankaCommand(){
    }
    public void setSpongebob(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    @Override
    public void execute(String[] parts) {
        System.out.println("Zacala se boj na planetě: "+spongebob.getCurrentPlanet());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
