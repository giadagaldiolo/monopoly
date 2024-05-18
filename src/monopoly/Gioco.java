package monopoly;

import monopoly.componentigioco.Dado;
import monopoly.componentigioco.carte.Carta;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.componentigioco.Tabellone;
import monopoly.schermate.Schermata;
import monopoly.schermate.SchermataFinale;
import monopoly.schermate.SchermataIniziale;
import monopoly.utilita.ScannerUtils;

import java.util.Iterator;
import java.util.LinkedHashSet;



public class Gioco {
    private Tabellone tabellone;
    private LinkedHashSet<Giocatore> giocatori=new LinkedHashSet<>();
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
        int sizeGiocatori=giocatori.size();


        while (sizeGiocatori > 1) {
            Iterator<Giocatore> iteratorGiocatori = giocatori.iterator(); //per resettare il loop
            this.numeroGiocatoreCorrente=0;
            while (iteratorGiocatori.hasNext()) { // parte dal primo elemento
                Giocatore next = iteratorGiocatori.next();
                menuTurno(next);
                if (next.isBancarotta()) {
                    iteratorGiocatori.remove();
                    sizeGiocatori--;
                    if (sizeGiocatori==1) break;
                }
                this.numeroGiocatoreCorrente++;

            }


        }

        fineGioco(giocatori.iterator().next());


    }

    private void creaDado() {
       Dado.creaDadi();

    }


    private void creaGiocatori() {
        this.giocatori= new SchermataIniziale().creaGiocatori(this.tabellone);

    }

    private void menuTurno(Giocatore currentGiocatore) {
        this.menuGioco.menu(currentGiocatore);
        turno(currentGiocatore);

    }


    private void turno(Giocatore currentGiocatore){
       if (isGiocatore(currentGiocatore)) {
           Dado.lancioDadi();
            if (!aggiornamentoPosizione(currentGiocatore,true)){
                aggiornamentoPosizione(currentGiocatore,false);

           }

        }
    }

    private Boolean aggiornamentoPosizione(Giocatore currentGiocatore,boolean possibilityUscita){
        boolean movimento=false;
        if (isGiocatore(currentGiocatore)&& !currentGiocatore.isBancarotta()){
            if (!isGiocatoreInPrigione(currentGiocatore)){
                currentGiocatore.updatePosizione(Dado.sommaDadi(), tabellone);
                System.out.println(tabellone);
                Dado.printDadi();
                movimento=true;

            }
            if (possibilityUscita || movimento){

                currentGiocatore.azioneCasella(tabellone);
            }



        }
        return movimento;

    }


    private void creaTabellone() {
        this.tabellone = new Tabellone();
        tabellone.crea();
    }



    private void fineGioco(Giocatore giocatore) {

        this.schermataCorrente=new SchermataFinale(giocatore);
        System.out.println(this.schermataCorrente);

        ScannerUtils.chiudiScanner();
    }

    private boolean isGiocatore(Giocatore giocatore){
        return giocatore!=null;
    }

    private boolean isGiocatoreInPrigione(Giocatore giocatore){
        return giocatore.isImprigionato();
    }
}
