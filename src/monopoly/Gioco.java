package monopoly;

import monopoly.componentigioco.Dado;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.componentigioco.Tabellone;
import monopoly.schermate.SchermataFinale;
import monopoly.schermate.SchermataIniziale;
import monopoly.utilita.Costanti;
import monopoly.utilita.ScannerUtils;

public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Dado dado;
    private int numeroGiocatoreCorrente = 0;
    private final MenuInterfaccia menuGioco= new MenuGioco(); // cosi non si possono usare altri metodi di menuGioco che non sono presenti nella interfaccia

    public Gioco() {
        System.out.println(new SchermataIniziale());
        ScannerUtils.emptyTheScanner();
        avviaGioco();

    }

    private void avviaGioco(){
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
            menuTurno();

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

    private void inserisciGiocatore(int i){
        char simbolo;
        String nome = ScannerUtils.inputNomeGiocatore(i+1);
        do {
            simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);

        } while (controlloSimboli(simbolo));

        this.giocatori[i] = new Giocatore(nome,simbolo,Costanti.RIGHE-1,Costanti.CASELLE_PER_RIGA-1);

    }

    private void menuTurno() {
        Giocatore currentGiocatore = giocatori[numeroGiocatoreCorrente];
        this.menuGioco.menu(currentGiocatore);
        turno(currentGiocatore);

    }

    private void turnoSuccessivo(){
        if (this.numeroGiocatoreCorrente==(this.giocatori.length-1)){
            this.numeroGiocatoreCorrente=0;
        } else{
            this.numeroGiocatoreCorrente++;
        }
    }
    private void turno(Giocatore currentGiocatore){
       if (isGiocatore(currentGiocatore)) {
            currentGiocatore.updatePosizione(dado.lancioDadi(), tabellone, numeroGiocatoreCorrente);
            System.out.println(tabellone);
            System.out.println(dado);
            turnoSuccessivo();
        }
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



    private void fineGioco() {
        for (Giocatore giocatore : giocatori) {
            if (!giocatore.isBancarotta()) {
                System.out.println(new SchermataFinale(giocatore));
                break;
            }
        }
    }


    private boolean isGiocatore(Giocatore giocatore){
        return giocatore!=null;
    }
}
