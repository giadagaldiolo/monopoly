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
    private PrintCasellaProprieta print= new PrintCasellaProprieta();

    public Proprieta(int y, int x) {
        super();
        setCoordinate(new Coordinate(y,x));
    }

    @Override
    public String dettagliCasella(int d) {

        return dettagliCasellaExtra(d);
    }
    private String dettagliCasellaExtra(int d){
        StringBuilder dettagli=new StringBuilder();
        dettagli.append(CostantiCaselle.SPAZIO);

        return switch (d) {
            case 3 ->
                    this.print.printRigaTre(this.proprietario, infoCasellaPrezziEdifici(), super.getPedaggio(), dettagli);
            case 4 ->
                    this.print.printRigaQuattro(this.proprietario, infoCasellaPrezziEdifici(), infoCasellaNumeroEdifici(), dettagli,getNCase());
            default -> super.dettagliCasella(d);
        };

    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggioDefault();
        setPrezzi();

    }
    private void setProprietario(Giocatore proprietario) {
        this.proprietario=proprietario;
    }

    private void setPrezzi(){ // da migliorare
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

    public boolean acquistoTerreno(Giocatore proprietario) {
        boolean acquistoTerreno=false;
        if (!isProprietario()) {
            acquistoTerreno=controlloAcquistoEffettuato(proprietario,this.prezzoTerreno);
            if (acquistoTerreno){
                setProprietario(proprietario);

            }

        }
        return  acquistoTerreno;

    }
    public void acquistoCasaHotel(int numeroAcquisti) {

        if (isProprietario() && (!this.hotel)) {
            if ((this.nCase<CostantiCaselle.MAX_CASE)) {
                for (int i = 0; i <numeroAcquisti ; i++) {
                    addCasa();
                    
                }
            } else if(acquistareHotel(numeroAcquisti)){
                addHotel();
            }

        }
    }
    private boolean acquistareHotel(int numeroAcquisti){
        return ((numeroAcquisti==CostantiCaselle.MAX_HOTEL) && (this.nCase>=CostantiCaselle.MAX_CASE));
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



    @Override
    public boolean isHotelAcquistabile() {
        boolean risposta=false;
        if (isProprietario()){
            risposta=(this.nCase>CostantiCaselle.MAX_CASE-1) && (!this.hotel) && (this.proprietario.getSoldi()>=this.prezzoHotel);
        }
        return risposta;
    }

    public int caseAcquistabili(){
        int houses =0;
        if (isProprietario()){
            houses= calcoloCaseAcquistabili(maxAcquistabili());

        }
        return houses;

    }
    private int calcoloCaseAcquistabili(int maxAcquistabili) {
        int soldiGiocatore= this.proprietario.getSoldi();

        if (soldiGiocatore < this.prezzoCasa*maxAcquistabili) {
            return calcoloCaseAcquistabili(--maxAcquistabili);
        }else {
            return maxAcquistabili;
        }
    }
    private int maxAcquistabili(){
        return CostantiCaselle.MAX_CASE-this.nCase;
    }

    public void resetAcquisti(){
        this.proprietario=null;
        this.nCase=0;
        this.hotel=false;

    }

    private String infoCasellaPrezziEdifici() { // non ci sta CHF, come possiamo ridurre la lunghezza di questa riga?
        StringBuilder info = new StringBuilder();
        info.append("⌂").append(this.prezzoCasa).append("CHF");
        info.append("۩").append(this.prezzoHotel).append("CHF");

        return info.toString();
    }

    private String infoCasellaNumeroEdifici() {
        StringBuilder info = new StringBuilder();
        if (this.nCase>0) info.append("⌂".repeat(Math.max(0, this.nCase)));
        if (this.hotel)info.append("۩");
        return info.toString();
    }

    public int getNCase(){
        if (!this.hotel){
            return this.nCase;

        }else {
            return 1;
        }

    }
}
