package monopoly.componentigioco.carte;

public class ModificaBudget extends Carta{
    private int valore;
    public ModificaBudget(String descrizione, String terzaInformazione) {
        super(descrizione);
        try {
            this.valore=Integer.parseInt(terzaInformazione.trim().toLowerCase());
        } catch (NumberFormatException e){
           this.valore=1;
        }
    }

    public int getValore() {
        return valore;
    }
}
