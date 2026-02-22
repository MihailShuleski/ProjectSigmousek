package Command;

import Characters.NPC.NPC;
import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Items.Item;
import Planets.Planet;

public class ProzkoumejCommand implements Command{
    Spongebob spongebob;
    public ProzkoumejCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }
    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        Planet planet = spongebob.getData().findPlanet(spongebob.getCurrentPlanet());

        System.out.println("Planeta: " + planet.getName());

        System.out.println("Sousedni planety:");
        for (String n : planet.getNeighbours()) {
            System.out.println("- " + spongebob.getData().findPlanet(n).getName());
        }

        if (planet.getItems().size()!=0) {
            System.out.println("Itemy:");
            for (Item item : planet.getItems()) {
                System.out.println("- " + item.getName());
            }
        }

        System.out.println("NPC:");
        for (NPC npc : planet.getNpcs()) {
            System.out.println("- " + npc.getName());
        }
        if (planet.getEnemyId() != null && !planet.getEnemyId().isEmpty()) {
            Enemy e = spongebob.getData().findEnemy(planet.getEnemyId());
            if (e != null && !planet.getPuzzles().isEmpty()) {
                System.out.println("Nepřítel: " + e.getName() + " (" + e.getHp() + " HP)");
            }
        }
    }


    @Override
    public boolean exit() {
        return false;
    }
}