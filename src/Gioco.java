
public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Banca banca;
    private Dado dado;

    private int giocatoreCorrente=0;

    public Gioco() {
        creaGioco();
        gameFlow();

    }
    private void creaGioco(){
        creaTabellone();
        creaGiocatori();
        creaDado();
        tabellone.mostra();

    }
    private void gameFlow(){
        while (true) {
            handleGame(); // ds programmare il limite
        }
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

            }while (controlloSimboli(simbolo));


            giocatori[i] = new Giocatore(nome,simbolo, 0);
            tabellone.modificaCasella(giocatori[i].getSimbolo(), Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);
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
        Giocatore currentGiocatore = giocatori[giocatoreCorrente];
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
                    movimentoGiocatore(passi,giocatoreCorrente);

                    // sposta giocatore
                    // fai pagare
                    //cambiaGiocatore();
                    turnoSucessivo();
                    tabellone.mostra();

                    break;
            }
        } while (scelta != 2);
    }

    private void cambiaGiocatore() {
        for (int i = 0; i < giocatori.length; i++) {
            if (giocatori[i].isTurno()) {            // per adesso non serve
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
    private void turnoSucessivo(){
        if (this.giocatoreCorrente==(this.giocatori.length-1)){
            this.giocatoreCorrente=0;
        }else{
            this.giocatoreCorrente++;
        }


    }
    private boolean controlloSimboli(char simbolo){
        boolean trovato = false;
        for (Giocatore giocatore : giocatori) {
            if ( giocatore != null && giocatore.getSimboloChar()==simbolo){
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

    private void movimentoGiocatore(int passi,int giocatore){
        cambioSimbolo(giocatore," ");
        this.giocatori[giocatore].cambioCasella(passi);
        cambioSimbolo(giocatore,this.giocatori[giocatore].getSimbolo());


    }
    private void cambioSimbolo(int giocatore,String simbolo){
        int [] coordinateAttuali= this.giocatori[giocatore].cordinate();
        this.tabellone.modificaCasella(simbolo,coordinateAttuali[0],coordinateAttuali[1],giocatore);

    }



}
