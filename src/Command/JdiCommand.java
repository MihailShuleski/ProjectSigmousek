package Command;

import Characters.Spongebob;
import Game.Hra;

public class JdiCommand implements Command{
    private Spongebob spongebob;
    public JdiCommand(Spongebob spongebob){
        this.spongebob = spongebob;
    }

    @Override
    public void execute() {
        Command.super.execute();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
