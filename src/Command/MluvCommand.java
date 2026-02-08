package Command;

import Characters.Spongebob;

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
        if(parts.length<2){
            System.out.println("Musíš napsat s kym chces mluvit(Ex. mluv *NPC*");
            return;
        }
        String npc=parts[1];
        for (int i= 2;i<parts.length;i++){ //pokud ma npc vice jak 1 slovo treba Kralovsky Radce tak se z toho udela string z tech dvou slov
            npc += " "+ parts[i];
        }
        String npc1=normalizeInput(npc);
        if(spongebob.getData().findPlanet(spongebob.getCurrentPlanet()).getNpcs().contains(npc1)){
            System.out.println(spongebob.getData().findNpc(npc1).getName()+" říka: "+spongebob.getData().findNpc(npc1).getDialogue());
        }else {
            System.out.println("Na tady té planetě neexistuje žádný takový NPC");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
