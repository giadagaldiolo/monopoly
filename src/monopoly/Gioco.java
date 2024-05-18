package monopoly;

import monopoly.componentigioco.Dado;
import monopoly.componentigioco.carte.Carta;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.componentigioco.Tabellone;
import monopoly.schermate.Schermata;
import monopoly.schermate.SchermataFinale;
import monopoly.schermate.SchermataIniziale;
import monopoly.utilita.ScannerUtils;



public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;

    private int numeroGiocatoreCorrente = 0;
    private final MenuInterfaccia menuGioco= new MenuGioco(); // cosi non si possono usare altri metodi di menuGioco che non sono presenti nella interfaccia
    private Schermata schermataCorrente= new SchermataIniziale();


    public Gioco() {

        System.out.println(this.schermataCorrente);
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
        Carta.creaCarte();

        creaDado();
    }

    private void gameFlow() {
        System.out.println(tabellone);
        while (Giocatore.getNGiocatoriInGioco()>1) {
            menuTurno();

        }

        fineGioco();
    }

    private void creaDado() {
       Dado.creaDadi();

    }


    private void creaGiocatori() {
        this.giocatori= new SchermataIniziale().creaGiocatori(this.tabellone);

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
        if (giocatori[numeroGiocatoreCorrente].isBancarotta()) turnoSuccessivo();

    }
    private void turno(Giocatore currentGiocatore){
       if (isGiocatore(currentGiocatore)) {
           Dado.lancioDadi();
            if (!aggiornamentoPosizione(currentGiocatore,true)){
                aggiornamentoPosizione(currentGiocatore,false);

           }
           turnoSuccessivo();
        }
    }

    private Boolean aggiornamentoPosizione(Giocatore currentGiocatore,boolean possibilityUscita){
        boolean movimento=false;
        if (isGiocatore(currentGiocatore)){
            if (!isGiocatoreInPrigione(currentGiocatore)){
                currentGiocatore.updatePosizione(Dado.sommaDadi(), tabellone, numeroGiocatoreCorrente);
                System.out.println(tabellone);
                Dado.printDadi();
                movimento=true;

            }
            if (possibilityUscita || movimento){
                currentGiocatore.azioneCasella(tabellone, numeroGiocatoreCorrente);
            }


        }
        return movimento;

    }


    private void creaTabellone() {
        this.tabellone = new Tabellone();
        tabellone.crea();
    }



    private void fineGioco() {
        for (Giocatore giocatore : giocatori) {
            if (!giocatore.isBancarotta()) {
                this.schermataCorrente=new SchermataFinale(giocatore);
                System.out.println(this.schermataCorrente);
                break;
            }
        }

        ScannerUtils.chiudiScanner();
    }

    private boolean isGiocatore(Giocatore giocatore){
        return giocatore!=null;
    }

    private boolean isGiocatoreInPrigione(Giocatore giocatore){
        return giocatore.isImprigionato();
    }
}
