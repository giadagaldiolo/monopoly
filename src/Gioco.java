public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Banca banca;

    public Gioco() {
        creaTabellone();
        creaGiocatori();
        tabellone.mostra();
    }

    private void creaGiocatori() {
        this.giocatori = new Giocatore[2];
        for (int i = 0; i < giocatori.length; i++) {
            String nome = ScannerUtils.inputNomeGiocatore(i+1);

            char simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);
            giocatori[i] = new Giocatore(nome,simbolo, 0);
            tabellone.modificaCasella(simbolo, Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);

        }
    }
    
    private boolean controllosimboli(char simbolo){
        boolean trovato = false;
        for (Giocatore giocatore : giocatori) {
            if (giocatore.getSimbolo()==simbolo){
                trovato= true;
                break;
            }

        }
        return trovato;
        
    }

    private void creaTabellone() {
        this.tabellone = new Tabellone();
        tabellone.crea();

    }

}
