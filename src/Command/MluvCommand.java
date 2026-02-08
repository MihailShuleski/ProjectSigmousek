package Command;

import Characters.NPC.NPC;
import Characters.Spongebob;
import Planets.Planet;

public class MluvCommand implements Command{
    Spongebob spongebob;
    public MluvCommand(){
    }

    private String normalizeInput(String input){
        return input.trim().toLowerCase().replace(" ","_");
    }
    @Override
    public void execute(String[] parts) {
        Planet current=spongebob.getCurrentPlanet();
        if(parts.length<2){
            System.out.println("Musíš napsat s kym chces mluvit(Ex. mluv *NPC*");
            System.out.println("Dostupné NPCs: ");
            for (NPC npc:current.getNpcs()){
                System.out.println("- "+npc.getName());
            }
            return;
        }
        String npcId=parts[1];
        for (int i= 2;i<parts.length;i++){ //pokud ma npc vice jak 1 slovo treba Kralovsky Radce tak se z toho udela string z tech dvou slov
            npcId += " "+ parts[i];
        }
        String npc1=normalizeInput(npcId);
        for (NPC npc :current.getNpcs()) {
            if (npc.getId().equals(npcId)) {
                System.out.println(npc.getName() + ":");
                System.out.println(npc.getDialogue());
                return;
            }
        }
        System.out.println("Tenhle NPC neexistuje na planetě: "+current.getName());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
