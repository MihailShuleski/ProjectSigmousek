package Command;

import Game.Hra;

public class HadankaCommand implements Command{
    Hra hra =new Hra();
    @Override
    public void execute() {
        Command.super.execute();
    }
}
