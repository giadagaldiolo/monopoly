package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.componentigioco.Dado;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;

import java.util.LinkedList;

public class Prigione extends Casella {

    public Prigione() {
        super();
        setCoordinate(new Coordinate(Costanti.RIGHE-1,0));
    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo = NomiCaselle.SINGOLE;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());
    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(Costanti.IMPORTO_PER_USCIRE_PRIGIONE);
    }

    @Override
    public String infoCasella() {
        return "";
    }

    @Override
    public void azioneCasella(Giocatore giocatoreCorrente) {
        if (super.isGiocatore(giocatoreCorrente) && giocatoreCorrente.isImprigionato() ){
            giocatoreCorrente.riduciTurniPrigione();
            boolean uscita= Dado.confrontaDadi();
            if (!uscita){
                if (giocatoreCorrente.getTentativiPerPrigione() <= 0) {
                    super.azioneCasella(giocatoreCorrente);
                } else{
                    System.out.println("Turni per uscire dalla prigione " + giocatoreCorrente.getTentativiPerPrigione());
                    return;
                }
            }
            giocatoreCorrente.setImprigionato(false);
            ordinaLinkedList(giocatoreCorrente);
            System.out.println("Sei uscito dalla prigione");
        }
    }

    private void ordinaLinkedList(Giocatore giocatore){
        LinkedList<String> giocatori=super.getGiocatoriPresenti();
        giocatori.remove(giocatore.getSimbolo());
        giocatori.addLast(giocatore.getSimbolo());
    }
}
