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
            // distribuisci soldi ad ogni giocatore
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
        currentGiocatore.setTurnoTrue();
        int scelta;
        do {
            System.out.println("è il turno di " + currentGiocatore.getNome());
            scelta = mostraMenu();
            switch (scelta){
                case 1:
                    System.out.println(currentGiocatore.getSoldi());
                    break;
                case 2:
                    int passi = (int) (Math.random() * ((Costanti.NUMERO_DADO_MAX - Costanti.NUMERO_DADO_MIN +1) + Costanti.NUMERO_DADO_MIN));
                    // sposta giocatore
                    // fai pagare
                    cambiaGiocatore();
                    tabellone.mostra();
                    break;
            }
        } while (scelta != 2);
    }

    private void cambiaGiocatore() {
        for (int i = 0; i < giocatori.length; i++) {
            if (giocatori[i].isTurno()) {
                giocatori[i].setTurnoFalse();
                if (i == giocatori.length - 1) {
                    giocatori[0].setTurnoTrue();
                } else {
                    giocatori[i+1].setTurnoTrue();
                }
                return;
            }
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
