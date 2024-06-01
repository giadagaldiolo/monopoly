package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.componentigioco.carte.Carta;
import monopoly.componentigioco.giocatore.Giocatore;

import java.util.LinkedList;

public abstract class CaselleCarte extends Casella{

    private static LinkedList<Carta> imprevisti = new LinkedList<>();
    private static LinkedList<Carta> probabilita = new LinkedList<>();


    public static void creaCaselleCarte(Casella[][] caselle){
        for(int i=0; i<3; i++){
            new Imprevisti(caselle);
            new Probabilita(caselle);
        }
    }

    public CaselleCarte(Casella [][] caselle){
        super();
        super.setCasella(caselle);

    }


    @Override
    public String infoCasella() {
        return "Pesca una carta";
    }

    public void azioneCasellaCarte(Carta carta, Giocatore giocatoreCorrente) {
        System.out.println(carta.toString());
        carta.azioneCarta(giocatoreCorrente);
    }

    public static LinkedList<Carta> getImprevisti() {
        return imprevisti;
    }

    public static LinkedList<Carta> getProbabilita() {
        return probabilita;
    }

    public static void creaCarte() {
        CaselleCarte.probabilita = Carta.creaProbabilita();
        CaselleCarte.imprevisti = Carta.creaImprevisti();
    }
}
