package Command;

/**
 * Ukončí hru po potvrzení.
 */
public class KonecCommand implements Command {
    private final Runnable onQuit;

    public KonecCommand(Runnable onQuit) {
        this.onQuit = onQuit;
    }

    @Override
    public void execute(String[] parts) {
        System.out.println("Konec hry. Nashledanou!");
        if (onQuit != null) {
            onQuit.run();
        }
    }

    @Override
    public boolean exit() {
        return true;
    }
}