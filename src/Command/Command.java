package Command;
/**
 * Rozhraní pro všechny herní příkazy.
 * Zajišťuje, že každý příkaz lze jednotně spustit a doptat se na ukončení.
 *
 * @author Shuleski Mihail
 */

public interface Command {

    /**
     * Spustí logiku daného příkazu.
     *
     * @param parts Zadaný příkaz od uživatele rozdělený na pole slov.
     */
    void execute(String[] parts);

    /**
     * Určuje, zda tento příkaz ukončuje celou hru.
     *
     * @return true, pokud má hra po spuštění skončit, jinak false.
     */
    boolean exit();

}