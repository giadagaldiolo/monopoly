public class Tabellone {
    private Casella[][] caselle ;


    public String toString(){
        Casella currentCell;
        String spazio = " ";
        StringBuilder tabellone=new StringBuilder();

        for (int i = 0; i < Costanti.RIGHE; i++) {
            tabellone.append(Casella.trattiniCasella(i));
            for (int d = 0; d < 5; d++) {
                for (int col = 0; col < Costanti.CASELLE_PER_RIGA; col++) {
                    currentCell = caselle[i][col];
                    if (Casella.checkForNull(currentCell)) {
                        tabellone.append(spazio.repeat(Costanti.LARGHEZZA_CASELLA));
                    }
                    else {
                        tabellone.append(currentCell.casellaString(d));
                    }
                }
                tabellone.append("\n");
            }
        }

        tabellone.append(Casella.ultimaRiga());
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
                    if (i == Costanti.RIGHE-1 && j == Costanti.CASELLE_PER_RIGA-1)
                        nome = "Via";
                    caselle[i][j] = new Casella(nome, i, j); //i,j
                }
            }
        }
    }

    public void modificaCasella(String simbolo, int i, int j, int giocatore) {

        caselle[i][j].aggiungiCarattere(simbolo, giocatore);
    }

    public void faiPagare(int i, int j, Giocatore giocatore) {
        giocatore.setSoldi(-caselle[i][j].getPedaggio());
    }





}
