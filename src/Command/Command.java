package Command;

public interface Command {


    void execute(String[] parts);

    boolean exit();

}