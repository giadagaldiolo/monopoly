package monopoly.componentigioco.casella;


import monopoly.Coordinate;

import java.util.Random;

public class Proprieta extends Casella {
    private int nCase=0;
    private boolean hotel=false;
    private int prezzoCasa;
    private int prezzoHotel;
    private int prezzoTerreno;

    public Proprieta(int y, int x) {
        super();
        setCoordinate(new Coordinate(y,x));
    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggioDefault();
        setPrezzi();

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



}
