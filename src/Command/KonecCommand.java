package Command;

/**
 * Ukončí hru po potvrzení.
 *
 * @author Shuleski Mihail
 */
public class KonecCommand implements Command {
    private final Runnable onQuit;

    public KonecCommand(Runnable onQuit) {
        this.onQuit = onQuit;
    }

    /**
     * Vykoná proces samotného ukončení hry přes pro to určenou metodu.
     *
     * @param parts Zadaný příkaz z konzole.
     */
    @Override
    public void execute(String[] parts) {
        System.out.println("Konec hry. Nashledanou!");
        if (onQuit != null) {
            onQuit.run();
        }
    }

    /**
     * Zajišťuje, že tento příkaz ukončí hlavní herní smyčku programu.
     *
     * @return true
     */
    @Override
    public boolean exit() {
        return true;
    }
}