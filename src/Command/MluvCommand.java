package Command;

import Characters.NPC.NPC;
import Characters.Nepritele.Enemy;
import Characters.Spongebob;
import Planets.Planet;

public class MluvCommand implements Command{
    Spongebob spongebob;
    public MluvCommand(Spongebob spongebob){
        this.spongebob=spongebob;
    }

    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        Planet current=spongebob.getData().findPlanet(spongebob.getCurrentPlanet());
        if(parts.length<2){
            System.out.println("Musíš napsat s kým chceš mluvit (např. mluv *jméno*)");
            System.out.println("Dostupné postavy:");
            for (NPC npc : current.getNpcs()) {
                System.out.println("- " + npc.getName());
            }
            if (current.getEnemyId() != null && !current.getEnemyId().isEmpty()) {
                Enemy e = spongebob.getData().findEnemy(current.getEnemyId());
                if (e != null && !current.getPuzzles().isEmpty()) {
                    System.out.println("- " + e.getName() + " (nepřítel)");
                }
            }
            return;
        }
        String npcId=parts[1];
        for (int i= 2;i<parts.length;i++){ //pokud ma npc vice jak 1 slovo treba Kralovsky Radce tak se z toho udela string z tech dvou slov
            npcId += " "+ parts[i];
        }
        String npc1=normalizeInput(npcId);
        for (NPC npc :current.getNpcs()) {
            if (npc.getId().equals(npc1)) {
                System.out.println(npc.getName() + ":");
                System.out.println(npc.getDialogue());
                return;
            }
        }

        if (current.getEnemyId() != null && spongebob.getData().findEnemy(current.getEnemyId()) != null
                && spongebob.getData().findEnemy(current.getEnemyId()).getId().equals(npc1)) {
            Enemy enemy = spongebob.getData().findEnemy(current.getEnemyId());
            enemy.vypisDialog();
            return;
        }

        System.out.println("Tato postava na planetě není: " + current.getName());
    }


    @Override
    public boolean exit() {
        return false;
    }
}