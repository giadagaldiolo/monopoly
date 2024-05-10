package monopoly;

import monopoly.componentigioco.Dado;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.componentigioco.Tabellone;
import monopoly.schermate.Schermata;
import monopoly.schermate.SchermataFinale;
import monopoly.schermate.SchermataIniziale;
import monopoly.utilita.ScannerUtils;


public class Gioco {
    private Tabellone tabellone;
    private Giocatore[] giocatori;
    private Dado[] dado={new Dado(0), new Dado(0)};
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
        for (int i = 0; i <this.dado.length ; i++) {
            this.dado[i] = dado[i].controllo(dado[i]) ? new Dado(1) : dado[i];

        }

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
           if(!isGiocatoreInPrigione(currentGiocatore)) {
               currentGiocatore.updatePosizione(dado[0].lancioDadi() + dado[1].lancioDadi(), tabellone, numeroGiocatoreCorrente);
               System.out.println(tabellone);
               System.out.println(dado[0]);
               System.out.println(dado[1]);
               currentGiocatore.pagamento(tabellone, numeroGiocatoreCorrente);
               currentGiocatore.acquistoCaseHotel(tabellone);
               turnoSuccessivo();
           } else {
                // prova a uscire di prigione
               if (currentGiocatore.tryToEscape(dado[0].lancioDadi(), dado[1].lancioDadi(), tabellone, numeroGiocatoreCorrente)){
                   currentGiocatore.updatePosizione(dado[0].getUltimoLancio() + dado[1].getUltimoLancio(), tabellone, numeroGiocatoreCorrente);
               }else {
                   System.out.println("Non sei riuscito ad uscire");
               }
               System.out.println(tabellone);
               System.out.println(dado[0]);
               System.out.println(dado[1]);

               turnoSuccessivo();
           }
        }
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
