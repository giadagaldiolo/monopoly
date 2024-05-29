package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.componentigioco.Banca;
import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.carte.Carta;
import monopoly.componentigioco.carte.ModificaBudget;
import monopoly.componentigioco.carte.VaiA;
import monopoly.componentigioco.giocatore.Giocatore;

import java.util.Collections;

public class Imprevisti extends CaselleCarte{

    public Imprevisti(Casella[][] caselle) {
        super();
        setCasella(caselle);
    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo=NomiCaselle.IMPREVISTI;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());
    }

    @Override
    public void azioneCasella(Giocatore giocatoreCorrente) {
        Carta carta = getImprevisti().remove(0);
        super.azioneCasellaCarte(carta, giocatoreCorrente);
        getImprevisti().add(carta);
        Collections.shuffle(getImprevisti());
    }

    @Override
    public String infoCasella() {
        return super.infoCasella() + " imprevisti";
    }

}
