package monopoly.componentigioco.giocatore;

import monopoly.componentigioco.Banca;
import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.casella.*;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatore;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatoreSupporto;
import monopoly.utilita.Costanti;
import monopoly.utilita.Colori;

import java.util.Objects;


/**
 * <i>Classe che gestisce le funzionalità del giocatore</i>
 */

public class Giocatore  implements MovimentoGiocatoreSupporto  {


    /**
     * Nome giocatore.
     */
    private String nome;
    /**
     * Stringa contenente il simbolo + colore del giocatore.
     */
    private String simbolo;
    /**
     * Simbolo giocatore senza colore.
     */
    private char simboloChar;
    /**
     * Semplicemente i soldi rimasti al giocatore.
     */
    private int soldi;

    /**
     * Stringa contenente solo il colore
     */
    private  String colore;

    private boolean imprigionato;

    private int tentativiPerPrigione = Costanti.TENTATIVI_PRIGIONE;

    private int[] nCaselleAcquistate;

    /**
     * Si occupa di contenere tutti i metodi e attributi riguardante il movimento del giocatore
     */
    private final MovimentoGiocatoreSupporto movimentoGiocatore; // se faccio cosi invece di usare direttamente la classe limito le funzioni


    /**
     * Il costruttore si occupa di generare correttamente il Giocatore.
     * @param nome nome giocatore
     * @param simbolo simbolo del giocatore
     * @param yMax coordinata y della casella iniziale
     * @param xMax  coordinata x della casella iniziale
     * @see #impostaCaratteristiche(String, char) impostaCaratteristiche(String nome,char simbolo)

     */
    public Giocatore(String nome, char simbolo, int yMax, int xMax) {

        this.movimentoGiocatore= new MovimentoGiocatore(xMax,yMax);
        impostaCaratteristiche(nome,simbolo);
        svuotaArrayCaselle();


    }

    private void svuotaArrayCaselle(){
        this.nCaselleAcquistate=new int[NomiCaselle.getUltimaPosizione()]; //lenght 8

        for (int i = 0; i <nCaselleAcquistate.length ; i++) {
            this.nCaselleAcquistate[i]=0;

        }


    }

    /**
     * Metodo utilizzato nel costruttore per controllare e settare le caratteristiche del giocatore.
     * @param nome nome Giocatore
     * @param simbolo simbolo giocatore
     * @see #controlloNome(String) metodo di controllo per il nome 
     * @see #controlloSimbolo(char) metodo di controllo per il simbolo.
     */
   private void impostaCaratteristiche(String nome,char simbolo){

       this.nome = controlloNome(nome) ? "Nome sconosciuto" : nome;
       this.simboloChar = controlloSimbolo(simbolo) ? 'X' : simbolo;
       this.soldi = Costanti.IMPORTO_INIZIALE_GIOCATORE;
       Banca.addImporto(-Costanti.IMPORTO_INIZIALE_GIOCATORE);
   }

    /**
     * Metodo utilizzato nel costruttore per richiedere un colore random per il giocatore. <p>
     * Alla fine salva nell'attributo simbolo tutto il necessario per generare un simbolo colorato.
     * @see Colori#sceltaColore()  Metodo utilizzato per generare il colore.
     */
   public void impostaColore(){
       String colore = Colori.sceltaColore();
       this.colore=colore;
       this.simbolo = colore+this.simboloChar+Costanti.ANSI_RESET;
   }

    /**
     * Controlla se un nome è valido per creare un giocatore.
     * @param nome Stringa da controllare
     * @return return {@code True} se {@code nome} non è valido , {@code False} se valido.
     */
    private boolean controlloNome(String nome){
        return nome == null || nome.isBlank();
    }
    /**
     * Controlla se un simbolo è valido per creare un giocatore.
     * @param simbolo char da controllare
     * @return return {@code True} se {@code simbolo} non è valido , {@code False} se valido.
     */
    private boolean controlloSimbolo(char simbolo){
        return simbolo==' ' ;
    }




    /**
     *
     * @return {@code String} simbolo giocatore con il colore.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     *
     * @return {@code int} soldi disponibili al giocatore
     */
    public int getSoldi() {
        return soldi;
    }

    /**
     * Metodo per variare la quantità di soldi disponibili al giocatore. {@link #soldi}
     * @param soldi importo da aggiungere al giocatore o togliere nel caso di importo negativo.
     */
    private void addSoldi(final int soldi) {
        this.soldi += soldi;
    }

    public boolean compraMiglioramentiTerreno(int acquisto){
        boolean acquistatoAvvenuto = false;
        if (acquisto <= this.soldi) {
            acquistatoAvvenuto = true;
            addSoldi(-acquisto);
        }
        return acquistatoAvvenuto;


    }

    /**
     * <p>Metodo che si occupa di controllare quando un giocatore va in bancarotta.</p>

     */
    private void controlloSoldi(Casella casella,Tabellone tabellone){
        if(this.soldi <= 0){
            System.out.println("Il giocatore "+ nome +" ha perso" );
            cancellaGiocatore(casella, tabellone);
        }
    }

    /**
     * <p>Metodo che cancella il giocatore dal tabellone.</p>

     */
    private void cancellaGiocatore(Casella casella,Tabellone tabellone){
        this.movimentoGiocatore.cancellaSimbolo(this.simbolo,casella);
        resettaCaselleGiocatore(tabellone);



    }
    private void resettaCaselleGiocatore(Tabellone tabellone){
        svuotaArrayCaselle();
        Casella[][] caselle = tabellone.getCaselle();
        for (Casella[] righe : caselle) {
            for (Casella casella : righe) {
                if (casella instanceof Acquistabile acquistabile){
                    if (this.equals(acquistabile.getProprietario())){
                        acquistabile.resetAcquisti();
                    }
                }

            }

        }

    }


    /**
     *
     * @return utile per sapere se il giocatore è in bancarotta.
     */
    public boolean isBancarotta(){return this.soldi<0; }

    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    /**
     *
     * @return {@code String} nome giocatore
     */
    public String getNome() {

        return nome;
    }

    /**
     *
     * @return {@code int} coordinata x giocatore.
     */
    @Override
    public int getX() {
        return this.movimentoGiocatore.getX();
    }
    /**
     *
     * @return {@code int} coordinata y giocatore.
     */
    @Override
    public int getY() {
        return this.movimentoGiocatore.getY();
    }

    /**
     * <p>Il metodo si occupa di gestire l'aggiornamento delle coordinate del giocatore salvate in {@link #movimentoGiocatore}.</p>
     * <p>Il metodo {@link #cambioCoordinate()} è importante per aggiungere i soldi del via al giocatore (oltre che ad aggiornare le coordinate): dato che controlla se un giocatore passa per il via.</p>
     * @param dado numero uscito dal dado
     * @see MovimentoGiocatore
     */
    public void spostamentoGiocatore(int dado){
        for (int i = dado; i >0 ; i--) {
            if (cambioCoordinate() && i>1){ // controlla se completa un giro durante il turno
                addSoldi(Costanti.IMPORTO_DEL_VIA);
                Banca.addImporto(-Costanti.IMPORTO_DEL_VIA);
            }
        }
    }

    /**
     * Il metodo aggiorna le coordinate utilizzando i metodi in {@link #movimentoGiocatore}
     * @return {@code True} se il giocatore completa un giro
     * @see MovimentoGiocatore#cambioCoordinate()
     */
    @Override
    public boolean cambioCoordinate(){
        return this.movimentoGiocatore.cambioCoordinate();
    }

    /**
     * Metodo che si occupa di gestire l'aggiornamento dei soldi.

     * @see Banca#addImporto(int)
     * @see #addSoldi(int) 
     * @see #calcoloSoldiResidui(int)
     */
    public void pagamentoPedaggio(Casella casella){ // solo per la banca
        if (isCasella(casella) && !this.imprigionato) {
            int importo = casella.getPedaggio();
            Banca.addImporto(calcoloSoldiResidui(importo));
            addSoldi(importo);


        }
    }

    public void pagamentoAffitto(Giocatore proprietario,int importo){
        proprietario.addSoldi(calcoloSoldiResidui(importo));
        addSoldi(importo);


    }

    /**
     * <p>Metodo utile nel caso un giocatore non riesca a pagare la somma corrispondente alla banca.</p>
     * @param pedaggio somma da pagare
     * @return somma che il giocatore riesce a pagare 
     */
    private int calcoloSoldiResidui(int pedaggio){
        int soldiDaAggiungere=-pedaggio;
        if (pedaggio>0 || (soldiDaAggiungere <this.soldi)) return soldiDaAggiungere;
        return this.soldi; //positivo

    }

    /**
     * @param passi numero ottenuto dai dadi.
     * @see #spostamentoGiocatore(int) Metodo per cambiare le coordinate del giocatore
     */
    public void updatePosizione(int passi, Tabellone tabellone){
        Casella casella;
        if (isTabellone(tabellone) && isCasella((casella=tabellone.getCasella(getY(),getX()))) ) {

            pulisciCasella(casella);
            spostamentoGiocatore(passi);
            casella=tabellone.getCasella(getY(),getX());
            riempiCasella(casella);



        }
    }

    public void pulisciCasella(Casella casella ){
        casella.togliCarattere(this.simbolo);

    }
    public void riempiCasella(Casella casella){
        aggiungiSimbolo(this.simbolo, casella);
    }


    public void azioneCasella(Tabellone tabellone){
        if (isTabellone(tabellone)){
            Casella casella = casellaCorrente(tabellone);
            if (isCasella(casella)) {
                casella.azioneCasella(this);
                controlloSoldi(casella, tabellone);
            }
        }


    }

    private Casella casellaCorrente(Tabellone tabellone){
        Casella casella=null;
        if (isTabellone(tabellone)){
            casella= tabellone.getCasella(getY(),getX());

        }
        return casella;

    }




    public void aggiuntaTerreno(int index){
        this.nCaselleAcquistate[index]++;

    }


    public int getNCaselleAcquistate(int index) {
        return nCaselleAcquistate[index];
    }

    @Override
    public void spostaGiocatoreInPrigione(Casella casella) {
        pulisciCasella(casella);
        this.imprigionato = true;
        this.tentativiPerPrigione = Costanti.TENTATIVI_PRIGIONE;
        this.movimentoGiocatore.spostaGiocatoreInPrigione(casella);


    }



    /**
     *
     * @return {@code String} stringa con solo il colore del giocatore
     */
    public String getColore() {
        return colore;
    }


    public boolean isImprigionato() {
        return imprigionato;
    }
    public void riduciTurniPrigione(){
        this.tentativiPerPrigione--;
    }
    public int getTentativiPerPrigione(){
        return this.tentativiPerPrigione;
    }

    public void setImprigionato(boolean imprigionato) {
        this.imprigionato = imprigionato;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(simboloChar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giocatore giocatore = (Giocatore) o;
        if ( (giocatore.nome == null) || (giocatore.simbolo == null) || (giocatore.colore == null)) {
            return false;
        }
        return this.simboloChar == giocatore.simboloChar;
    }


}
