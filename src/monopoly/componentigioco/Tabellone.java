package monopoly.componentigioco;


import monopoly.componentigioco.casella.*;
import monopoly.utilita.Costanti;

public class Tabellone {
    private Casella[][] caselle ;

    @Override
    public String toString(){
        Casella currentCell;
        String spazio = " ";
        StringBuilder tabellone=new StringBuilder();

        for (int i = 0; i < Costanti.RIGHE; i++) {
            for (int d = 0; d < Costanti.RIGHE_CASELLA; d++) {
                for (int col = 0; col < Costanti.CASELLE_PER_RIGA; col++) {
                    currentCell = caselle[i][col];
                    if (Casella.checkForNull(currentCell)) {
                        tabellone.append(Costanti.COLORE_SFONDO_NULL).append(spazio.repeat(Costanti.LARGHEZZA_CASELLA+2)); // +2 per lo spazio aggiunto per separare le caselle
                    }
                    else {
                        tabellone.append(currentCell.casellaString(d));
                    }
                }
                tabellone.append("\n");
            }
        }

        return tabellone.toString();

    }


    public void crea() {
        String nome = "Pedaggio";

        this.caselle = new Casella[Costanti.RIGHE][Costanti.CASELLE_PER_RIGA];
        for (int i = 0; i < Costanti.RIGHE; i++) {
            for (int j = 0; j < Costanti.CASELLE_PER_RIGA; j++) {
                if (i > 0 && i < Costanti.RIGHE-1 && j > 0 && j < Costanti.CASELLE_PER_RIGA-1) {
                    caselle[i][j] = null;
                } else {
                    scegliNome(i, j);
                }
            }
        }
    }
    


    public void scegliNome(int i, int j) {
        if (i == Costanti.RIGHE-1 && j == Costanti.CASELLE_PER_RIGA-1) {
            caselle[i][j] = new Via( i, j);
        } else if (i == 0 && j == Costanti.CASELLE_PER_RIGA/2) {
            caselle[i][j] = new Stazione(i, j);
        } else if (i == Costanti.RIGHE-1 && j == Costanti.CASELLE_PER_RIGA/2) {
            caselle[i][j] = new Stazione(i, j);
        } else if (i == Costanti.RIGHE/2 && j == 0) {
            caselle[i][j] = new Stazione(i, j);
        } else if (i == Costanti.RIGHE/2 && j == Costanti.CASELLE_PER_RIGA-1) {
            caselle[i][j] = new Stazione(i, j);
        } else if (i == 0 && j == 0) {
            caselle[i][j] = new Parcheggio(i, j);
        } else {
            caselle[i][j] = new Proprieta(i, j); // Mancano le due tasse
        }
    }

    public void modificaCasella(String simbolo, int i, int j, int giocatore) {

        caselle[i][j].aggiungiCarattere(simbolo, giocatore);
    }

    public int getImporto(int i, int j) {
        return caselle[i][j].getPedaggio();

    }





}
