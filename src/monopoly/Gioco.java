package monopoly;

import monopoly.componentigioco.Dado;
import monopoly.componentigioco.Giocatore;
import monopoly.componentigioco.Tabellone;
import monopoly.utilita.Costanti;
import monopoly.utilita.ScannerUtils;

public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Dado dado;
    private int numeroGiocatoreCorrente = 0;

    public Gioco() {
        creaGioco();
        gameFlow();
    }
    private void creaGioco(){
        creaTabellone();
        creaGiocatori();
        creaDado();


    }
    private void gameFlow() {
        System.out.println(tabellone);
        while (Giocatore.getNGiocatoriInGioco()>1) {
            handleGame();
        }
        fineGioco();
    }

    private void creaDado(){
        this.dado = new Dado();
    }

    private void creaGiocatori() {
        this.giocatori = new Giocatore[Costanti.NUMERO_GIOCATORI];

        for (int i = 0; i < giocatori.length; i++) {
            inserisciGiocatore(i);

            tabellone.modificaCasella(giocatori[i].getSimbolo(), Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);

        }

    }

    private int mostraMenu() {
        System.out.println("1. Mostra capitale giocatore corrente");
        System.out.println("2. Tira il dado");
        System.out.print("Scelta: ");
        return ScannerUtils.readIntegerInRange(1,2);
    }

    private void inserisciGiocatore(int i){
        char simbolo;
        String nome = ScannerUtils.inputNomeGiocatore(i+1);
        do {
            simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);

        } while (controlloSimboli(simbolo));

        this.giocatori[i] = new Giocatore(nome,simbolo,Costanti.RIGHE-1,Costanti.CASELLE_PER_RIGA-1);



    }

    private void handleGame() {
        Giocatore currentGiocatore = giocatori[numeroGiocatoreCorrente];
        int scelta;
        do {
            System.out.println("E' il turno di " + currentGiocatore.getNome());
            scelta = mostraMenu();
            switch (scelta){
                case 1:
                    System.out.println(currentGiocatore.getSoldi());
                    break;
                case 2:
                    turno(currentGiocatore);
                    break;
            }
        } while (scelta != 2);
    }
    private void turnoSucessivo(){
        if (this.numeroGiocatoreCorrente==(this.giocatori.length-1)){
            this.numeroGiocatoreCorrente=0;
        } else{
            this.numeroGiocatoreCorrente++;
        }
    }
    private void turno(Giocatore currentGiocatore){
        movimentoGiocatore(dado.lancioDadi(),numeroGiocatoreCorrente);
        pagamentoPedaggio(currentGiocatore);
        System.out.println(tabellone);
        System.out.println(dado);
        turnoSucessivo();
    }

    private void pagamentoPedaggio(Giocatore currentGiocatore){
        int[] coordinateAttuali = currentGiocatore.getCoordinate();
        tabellone.faiPagare(coordinateAttuali[0],coordinateAttuali[1], currentGiocatore);


    }
    private boolean controlloSimboli(char simbolo){
        boolean trovato = false;
        for (Giocatore giocatore : giocatori) { // da spostare se si trova il modo

            if (!(Giocatore.checkForNullGiocatore(giocatore)) && giocatore.isSimboloUguale(simbolo)){
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
        int[] coordinateAttuali = this.giocatori[giocatore].getCoordinate();
        this.tabellone.modificaCasella(simbolo,coordinateAttuali[0],coordinateAttuali[1],giocatore);
    }

    private void fineGioco() {
        for (Giocatore giocatore : giocatori) {
            if (!giocatore.isBancarotta()) {
                String nomeGiocatore = getStringaDaStampare(giocatore.getNome());
                String stringaFinale = giocatore.getColore()+ """
                        * * * * * * * * * * * * * * * * * * * * * * *
                        *                                           *
                        *              PARTITA FINITA!              *
                        *               Il giocatore                *
                        *%s*
                        *            ha vinto la partita            *
                        *              CONGRATULAZIONI!             *
                        *                                           *
                        * * * * * * * * * * * * * * * * * * * * * * *
                                                                  
                        """.formatted(nomeGiocatore);

                System.out.println(stringaFinale);
                break;

            }


        }
    }

    private String getStringaDaStampare(String giocatore) {
        int larghezzaSchermata=43;
        int nSpaziRichiestiTotali = ((larghezzaSchermata - giocatore.length()));
        int nSpaziRichiestiPrima = (nSpaziRichiestiTotali/2);
        String spazio = " ";
        return spazio.repeat(nSpaziRichiestiPrima) + giocatore + spazio.repeat(nSpaziRichiestiTotali-nSpaziRichiestiPrima);
    }
}
