package monopoly;
import monopoly.componentigioco.casella.CaseHotel;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.ScannerUtils;

public class MenuAcquistoMiglioramenti implements MenuMiglioramentiTerreni {
    private Giocatore giocatoreCorrente;
    private CaseHotel proprieta;
    private int opzioniMenu;
    private boolean acquistoEfettuato=false;


    @Override
    public void menu(Giocatore currentGiocatore) {
        int scelta=2;

        if (isGiocatore(currentGiocatore) ){

            System.out.print(this);
            if (this.opzioniMenu>0){
                scelta = ScannerUtils.readIntegerInRange(1, this.opzioniMenu);
                if (scelta >= this.opzioniMenu) {
                    System.out.println("Nessun Acquisto effettuato");
                    acquistoEfettuato=false;
                }else {
                    acquistoEfettuato=this.proprieta.acquistoCasaHotel(scelta);
                }

            }

        }

    }





    @Override
    public String toString(){
        StringBuilder stringa=new StringBuilder();
        System.out.println("MENU ACQUISTO MIGLIORAMENTI PER IL TERRENO");
        int caseAcquistabili= this.proprieta.caseAcquistabili();
        if (caseAcquistabili>0) {
            this.opzioniMenu=caseAcquistabili+1;
            stringa.append("Case acquistabili : NUMERO MASSIMO %d \n".formatted(caseAcquistabili));
            stringa.append("Inserire la quantità di case da acquistare o premere %d per non compare niente\n".formatted(this.opzioniMenu));

        } else if (this.proprieta.isHotelAcquistabile()){
            this.opzioniMenu=2;
            stringa.append("HOTEL ACQUISTABILE");
            stringa.append("1 per acquistare \n");
            stringa.append("2 per non acquistare \n");

        }
        return stringa.toString();


    }

    @Override
    public void menu(Giocatore currentGiocatore, CaseHotel terreno) {
        if (isTerreno(terreno)){
            this.giocatoreCorrente = terreno.getProprietario();
            this.proprieta=terreno;
            menu(currentGiocatore);

        }
        resetProprieta();


    }

    @Override
    public void resetProprieta() {
        this.giocatoreCorrente=null;
        this.proprieta=null;
        this.opzioniMenu=0;
        this.acquistoEfettuato=false;

    }

    @Override
    public boolean pagamentoGiaEffettuato() {
        return this.acquistoEfettuato;
    }
}
