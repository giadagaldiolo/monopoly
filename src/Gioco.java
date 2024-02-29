public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Banca banca;

    public Gioco() {
        creaTabellone();
        creaGiocatori();
        tabellone.mostra();
        handleGame();
    }

    private void creaGiocatori() {
        this.giocatori = new Giocatore[Costanti.NUMERO_GIOCATORI];
        for (int i = 0; i < giocatori.length; i++) {
            String nome = ScannerUtils.inputNomeGiocatore(i+1);

            char simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);
            giocatori[i] = new Giocatore(nome,simbolo, 0);
            tabellone.modificaCasella(simbolo, Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);

        }
    }

    private int mostraMenu() {
        System.out.println("1. Mostra capitale giocatore corrente");
        System.out.println("2. Tira il dado");
        System.out.print("Scelta: ");
        return ScannerUtils.readIntegerInRange(1,2);
    }

    private void handleGame() {
        Giocatore currentGiocatore = giocatori[0];
        int scelta;
        do {
            scelta = mostraMenu();
            switch (scelta){
                case 1:
                    System.out.println(currentGiocatore.getSoldi());
                    break;
                case 2:
                    // genera numero random
                    // sposta giocatore
                    // fai pagare
                    // cambia currentGiocatore
                    break;
            }
        } while (scelta != 2);
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
