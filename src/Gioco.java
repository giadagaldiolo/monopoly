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
            char simbolo = ScannerUtils.inputSimboloGiocatore(i+1);
            giocatori[i] = new Giocatore(ScannerUtils.inputNomeGiocatore(i+1),
                    simbolo, 0);
            tabellone.modificaCasella(simbolo, Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);

        }
    }

    private void creaTabellone() {
        this.tabellone = new Tabellone();
        tabellone.crea();

    }

}
