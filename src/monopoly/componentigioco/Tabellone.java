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
        caselleSpeciali();
        for (int i = 0; i < Costanti.RIGHE; i++) {
            for (int j = 0; j < Costanti.CASELLE_PER_RIGA; j++) {
                if (controlloPosizione(i,j)) { // controlla se non è ai lati
                    caselle[i][j] = null;
                } else {
                    scegliNome(i, j);
                }
            }
        }
    }

    public static boolean controlloPosizione(int i ,int j){
        return i > 0 && i < Costanti.RIGHE-1 && j > 0 && j < Costanti.CASELLE_PER_RIGA-1;
    }

    private void caselleSpeciali(){
        int righeMatrice=Costanti.RIGHE-1;
        int elementiMatrice=Costanti.CASELLE_PER_RIGA-1;
        int numeroStazioni=4;

        this.caselle[righeMatrice][elementiMatrice] = new Via();
        for (int i = 0; i < numeroStazioni ; i++) {
            new Stazione(caselle);
        }
        this.caselle[0][0] = new Parcheggio();
        Tassa.creaTasse(this.caselle);
    }


    private void scegliNome(int i, int j) {
        if (caselle[i][j] == null){
            caselle[i][j] = new Proprieta(i, j);
        }
    }

    public void modificaCasella(String simbolo, int i, int j, int giocatore) {
        caselle[i][j].aggiungiCarattere(simbolo, giocatore);
    }

    private int getImporto(int i, int j) {
        return caselle[i][j].getPedaggio();
    }
    public int getImporto(int i, int j, int soldiGiocatore ){
        if (isTassaPatrimoniale(i,j)) caselle[i][j].setPedaggio(soldiGiocatore);
        return getImporto(i,j);
    }

    private boolean isTassaPatrimoniale(int i, int j) {
        return caselle[i][j] instanceof TassaPatrimoniale;
    }
}
