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
    private Dado dado;
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

    private void creaDado(){
        this.dado = new Dado();
    }

    private void creaGiocatori() {
        this.giocatori= new SchermataIniziale().creaGiocatori(this.tabellone);

    }

    private void menuTurno() {
        Giocatore currentGiocatore = giocatori[numeroGiocatoreCorrente];
        while (currentGiocatore.isBancarotta()){
            turnoSuccessivo();
            currentGiocatore = giocatori[numeroGiocatoreCorrente];
        }
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
    }


    private boolean isGiocatore(Giocatore giocatore){
        return giocatore!=null;
    }
}
