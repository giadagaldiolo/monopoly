package monopoly.componentigioco.casella;


import monopoly.Coordinate;
import monopoly.componentigioco.giocatore.Giocatore;

import java.util.Random;

public class Proprieta extends Casella implements CaseHotel {
    private int nCase=0;
    private boolean hotel=false;
    private int prezzoCasa;
    private int prezzoHotel;
    private int prezzoTerreno;
    private Giocatore proprietario=null;

    public Proprieta(int y, int x) {
        super();
        setCoordinate(new Coordinate(y,x));
    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggioDefault();
        setPrezzi();

    }
    private void setProprietario(Giocatore proprietario) {
        this.proprietario=proprietario;
    }

    private void setPrezzi(){
        this.prezzoTerreno=creaSeedRandom().nextInt(CostantiCaselle.PREZZO_TERRENO_MIN,CostantiCaselle.PREZZO_TERRENO_MAX);
        this.prezzoCasa=creaSeedRandom().nextInt(CostantiCaselle.PREZZO_CASA_MIN,CostantiCaselle.PREZZO_CASA_MAX);
        this.prezzoHotel=creaSeedRandom().nextInt(calcoloPrezzoMinimoHotel(),CostantiCaselle.PREZZO_HOTEL_MAX);
    }
    private int calcoloPrezzoMinimoHotel(){ // non avrebbe senso che l'hotel costi meno di una casa
        int prezzoMinimoHotel=CostantiCaselle.PREZZO_HOTEL_MIN;
        int aumentoPrezzo=10; // per avere una differenza sicura tra casa/hotel
        if (this.prezzoCasa>prezzoMinimoHotel){
            prezzoMinimoHotel=this.prezzoCasa+aumentoPrezzo;
        }
        return prezzoMinimoHotel;

    }
    private Random creaSeedRandom(){

         return new Random();
    }

    public void acquistoTerreno(Giocatore proprietario) {
        if (!isProprietario() && controlloAcquistoEffettuato(proprietario,this.prezzoTerreno)) {
            setProprietario(proprietario);

        }

    }
    public void acquistoCasaHotel() {
        if (isProprietario() && (!this.hotel)) {
            if ((this.nCase<CostantiCaselle.MAX_CASE)) {
                addCasa();
            } else{
                addHotel();

            }

        }
    }
    private void addHotel(){
        if (controlloAcquistoEffettuato(this.proprietario,this.prezzoHotel)){
            this.nCase=0;
            this.hotel=true;

        }

    }
    private void addCasa(){
        if (controlloAcquistoEffettuato(this.proprietario,this.prezzoCasa)){
            this.nCase++;

        }
    }

    private boolean controlloAcquistoEffettuato(Giocatore proprietario,int prezzo){
        return proprietario.compraMiglioramentiTerreno(prezzo);

    }
    private boolean isProprietario(){
        return this.proprietario!=null;
    }

    public Giocatore getProprietario() {
        return proprietario;
    }

    public int getPrezzoTerreno() {
        return prezzoTerreno;
    }

    public int getnCase() {
        return nCase;
    }

    public boolean isHotel() {
        return hotel;
    }

    public int getPrezzoCasa() {
        return prezzoCasa;
    }

    public int getPrezzoHotel() {
        return prezzoHotel;
    }
}
