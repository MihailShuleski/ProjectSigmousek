package Command;

public interface Command {
    default void execute(String[] parts){}
    boolean exit();

}
