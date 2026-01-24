package Command;

import Characters.Spongebob;

public class PouzijCommand implements Command{
    Spongebob spongebob=new Spongebob();
    @Override
    public void execute() {
        Command.super.execute();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
