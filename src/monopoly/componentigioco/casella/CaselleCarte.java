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

    protected void setCasella(Casella [][] caselle){
        int[] coordinate = NomiHelper.calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }
    @Override
    public String infoCasella() {
        return "Pesca una carta";
    }

    @Override
    public void azioneCasella(Giocatore giocatoreCorrente) {
        setPedaggio(giocatoreCorrente.getSoldi());
        super.azioneCasella(giocatoreCorrente);
    }

    public static void creaCarte() {
        CaselleCarte.probabilita = Carta.creaProbabilita();
        CaselleCarte.imprevisti = Carta.creaImprevisti();
    }
}
