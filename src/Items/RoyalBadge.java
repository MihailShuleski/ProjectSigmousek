package Items;

import Characters.Spongebob;

public class RoyalBadge implements ItemBehaviour{
    @Override
    public void pouzij(Item item, Spongebob spongebob) {
        System.out.println("Královský odznak září a v hlavě se ti ozve hlas rádce:");
        System.out.println();
        System.out.println("CÍL HRY:");
        System.out.println("- Dobej všechny klíčové planety a nakonec ovládni galaktické jádro.");
        System.out.println("- Postupuješ přes planety pomocí cest (příkaz jdi *planet*).");
        System.out.println();
        System.out.println("ZÁKLADNÍ PŘÍKAZY:");
        System.out.println("- jdi <planeta>       : cestování na sousední planetu");
        System.out.println("- prozkoumej          : informace o aktuální planetě, itemech a NPC");
        System.out.println("- vezmi <item>        : seber předmět z planety do inventáře");
        System.out.println("- inventar            : zobrazí věci, které neseš");
        System.out.println("- pouzij <item>       : použije předmět z inventáře");
        System.out.println("- mluv <npc>          : promluví s postavou na planetě");
        System.out.println("- hadanka             : spustí hádanku na aktuální planetě (pokud je k dispozici)");
        System.out.println();
        System.out.println("RADY PRO HRU:");
        System.out.println("- Hádanky ti mohou ubrat HP, ale také posunout příběh dál.");
        System.out.println("- Než vstoupíš do galaktického jádra, ujisti se, že jsi připraven.");
        System.out.println();
        System.out.println("Odznak můžeš kdykoli znovu použít pro připomenutí návodu.");
    }
    }

