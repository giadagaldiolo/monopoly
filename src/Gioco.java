
public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Banca banca;
    private Dado dado;

    public Gioco() {
        creaGioco();
        tabellone.mostra();
        handleGame();
    }
    public void creaGioco(){
        creaTabellone();
        creaGiocatori();
        creaDado();

    }
    private void creaDado(){
        this.dado=new Dado(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX);

    }

    private void creaGiocatori() {
        this.giocatori = new Giocatore[Costanti.NUMERO_GIOCATORI];
        char simbolo;
        for (int i = 0; i < giocatori.length; i++) {
            String nome = ScannerUtils.inputNomeGiocatore(i+1);
            do {
                simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);

            }while (controllosimboli(simbolo));


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
                    int passi = this.dado.lancioDadi();
                    System.out.println(passi);

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
            if ( giocatore != null && giocatore.getSimbolo()==simbolo){
                System.out.println("Simbolo gia utilizzato dal giocatore: " + giocatore.getNome());
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
