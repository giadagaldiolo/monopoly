package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.componentigioco.Banca;
import monopoly.componentigioco.carte.Carta;
import monopoly.componentigioco.carte.ModificaBudget;
import monopoly.componentigioco.carte.VaiA;
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

    protected void setCasella(Casella [][] caselle){
        int[] coordinate = NomiHelper.calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }
    @Override
    public String infoCasella() {
        return "Pesca una carta";
    }

    public void azioneCasellaCarte(Carta carta, Giocatore giocatoreCorrente) {
        System.out.println(carta.toString());
        if (carta instanceof VaiA) {
            giocatoreCorrente.spostaGiocatoreConCarta(carta);
        } else {
            giocatoreCorrente.addSoldi(((ModificaBudget) carta).getValore());
            Banca.addImporto(((ModificaBudget) carta).getValore());
        }
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
