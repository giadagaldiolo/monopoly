public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Banca banca;

    public Gioco(Tabellone tabellone, Giocatore[] giocatori, Banca banca) {
        this.tabellone = tabellone;
        this.giocatori = giocatori;
        this.banca = banca;
    }
}
