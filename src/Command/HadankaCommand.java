package Command;

import Game.Hra;

public class HadankaCommand implements Command{
    Hra hra =new Hra();
    @Override
    public void execute(String[] parts) {
        return;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
