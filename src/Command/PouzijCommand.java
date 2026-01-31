package Command;

import Characters.Spongebob;

public class PouzijCommand implements Command{
    Spongebob spongebob=new Spongebob();
    @Override
    public void execute(String[] parts) {
        if (parts.length<2){
            System.out.println("Musíš napsat co chceš použít(Ex. pouzij *item*");
            return;
        }
        String Item=parts[1];
        System.out.println("Uspěšně jsi použil předmět: "+Item);

    }

    @Override
    public boolean exit() {
        return false;
    }
}
