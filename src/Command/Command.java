package Command;

public interface Command {
    default void execute(String[] parts){}

    void execute();

    boolean exit();

}
