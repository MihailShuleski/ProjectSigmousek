package Command;

import Characters.Spongebob;

public class MluvCommand implements Command{
    Spongebob spongebob=new Spongebob();
    @Override
    public void execute(String[] parts) {
        return;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
