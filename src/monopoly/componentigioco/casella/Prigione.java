package monopoly.componentigioco.casella;


import monopoly.Coordinate;
import monopoly.componentigioco.Dado;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;
import monopoly.Gioco;

import java.util.LinkedList;

public class Prigione extends Casella {

    private final PrintCasellaPrigione print= new PrintCasellaPrigione();

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
    public void azioneCasella(Giocatore giocatoreCorrente) {
        if (super.isGiocatore(giocatoreCorrente) && giocatoreCorrente.isImprigionato() ){
            giocatoreCorrente.riduciTurniPrigione();
            boolean uscita= Dado.confrontaDadi();
            if (!uscita){
                if (giocatoreCorrente.getTentativiPerPrigione() <= 0) {
                    super.azioneCasella(giocatoreCorrente);
                } else {
                    System.out.println("Turni per uscire dalla prigione " + giocatoreCorrente.getTentativiPerPrigione());
                    return;
                }
            }
            giocatoreCorrente.setImprigionato(false);
            System.out.println("Sei uscito dalla prigione");
        }
        ordinaLinkedList(giocatoreCorrente);
    }

    private void ordinaLinkedList(Giocatore giocatore){
        LinkedList<String> giocatori = super.getGiocatoriPresenti();
        if (!giocatore.isImprigionato()) giocatori.remove(giocatore.getSimbolo());
    }
    public void togliCarattere(){
    }

    @Override
    public String dettagliCasella(int d) {
        return switch (d) {
            case 2 ->
                    this.print.printRigaDueEQuattro("Giocatori in transito:");
            case 3 ->
                    this.print.printRigaTre(super.getGiocatoriPresenti(),super.getColore(), Gioco.getGiocatori());
            case 4 ->
                    this.print.printRigaDueEQuattro("Giocatori in prigione:");
            case 5 ->
                    this.print.printRigaCinque(super.getGiocatoriPresenti(),super.getColore(), Gioco.getGiocatori());
            default -> super.dettagliCasella(d);
        };
    }

}
