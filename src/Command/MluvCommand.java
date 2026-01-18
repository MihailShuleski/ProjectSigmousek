package Command;

import Characters.Spongebob;

public class MluvCommand implements Command{
    Spongebob spongebob=new Spongebob();
    @Override
    public void execute() {
        Command.super.execute();
    }
}
