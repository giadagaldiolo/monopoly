public class Tabellone {
    private Casella[][] caselle ;


    public void mostra(){

        Casella currentCell;
        String spazio = " ";
        String trattino = "-";

        for (int i = 0; i < Costanti.RIGHE; i++) {
            Casella.printTrattiniCasella(i);
            for (int d = 0; d < 5; d++) {
                for (int col = 0; col < Costanti.CASELLE_PER_RIGA; col++) {
                    currentCell = caselle[i][col];
                    if (Casella.checkForNull(currentCell))
                        System.out.print(spazio.repeat(Costanti.LARGHEZZA_CASELLA));
                    else {
                        currentCell.mostra(d);
                    }
                }
                System.out.println();
            }
        }
        System.out.print(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
    }


    public void crea() {
        String nome = "Pedaggio";
        int pedaggio;

        this.caselle = new Casella[Costanti.RIGHE][Costanti.CASELLE_PER_RIGA];
        for (int i = 0; i < Costanti.RIGHE; i++) {
            for (int j = 0; j < Costanti.CASELLE_PER_RIGA; j++) {
                if (i > 0 && i < Costanti.RIGHE-1 && j > 0 && j < Costanti.CASELLE_PER_RIGA-1) {
                    caselle[i][j] = null;
                } else {
                    if (i == Costanti.RIGHE-1 && j == Costanti.CASELLE_PER_RIGA-1)
                        nome = "Via";
                    caselle[i][j] = new Casella(nome,i,j);
                }
            }
        }
    }

    public void modificaCasella(String simbolo, int i, int j, int giocatore) {

        caselle[i][j].aggiungiCarattere(simbolo, giocatore);
    }



}
