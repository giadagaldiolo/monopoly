package monopoly.componentigioco.giocatore;

import monopoly.componentigioco.Banca;
import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.casella.NomiCaselle;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatore;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatoreSupporto;
import monopoly.utilita.Costanti;
import monopoly.utilita.Colori;

/**
 * <i>Classe che gestisce le funzionalità del giocatore</i>
 */

public class Giocatore  implements MovimentoGiocatoreSupporto  {
    /**
     * Contatore dei giocatori in Gioco.
     */
    private static int nGiocatoriInGioco= Costanti.NUMERO_GIOCATORI;
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
     * Per sapere se è il turno di un giocatore, da implementare
     */
    private boolean turno;
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
     * @see #impostaColore() impostaColore().
     */
    public Giocatore(String nome, char simbolo, int yMax, int xMax) {

        this.movimentoGiocatore= new MovimentoGiocatore(xMax,yMax);

        impostaCaratteristiche(nome,simbolo);
        impostaColore();
        svuotaArrayCaselle();


    }

    private void svuotaArrayCaselle(){
        this.nCaselleAcquistate=new int[NomiCaselle.getUltimaPosizione()];

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
   private void impostaColore(){
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
     * @return {@code int} numero di giocatori in gioco
     */
    public static int getNGiocatoriInGioco() {
        return nGiocatoriInGioco;
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
     * @see #cancellaGiocatore(Tabellone, int)  Metodo per cancellare il Giocatore.
     */
    private void controlloSoldi(Tabellone tabellone,int nGiocatore){
        if(this.soldi <= 0){
            System.out.println("Il giocatore "+ nome +" ha perso" );
            cancellaGiocatore(tabellone,nGiocatore);
        }
    }

    /**
     * <p>Metodo che cancella il giocatore dal tabellone.</p>
     * <p>Per adesso array {@link monopoly.Gioco#giocatori} rimane invariato</p>
     * @param tabellone utile per eliminare il giocatore dal tabellone.
     * @param nGiocatore indica la posizione del giocatore nel array {@link monopoly.Gioco#giocatori}
     */
    private void cancellaGiocatore(Tabellone tabellone,int nGiocatore){
        this.simbolo="";
        this.simboloChar=' ';
        nGiocatoriInGioco--;
        spostaSimbolo(this.simbolo, tabellone, nGiocatore);

    }

    /**
     *
     * @return utile per sapere se il giocatore è in bancarotta.
     */
    public boolean isBancarotta(){return this.soldi<0; }

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
     * @param tabellone utile per il metodo {@link #controlloSoldi(Tabellone, int)}
     * @param nGiocatore posizione giocatore in {@link monopoly.Gioco#giocatori}
     * @see Banca#addImporto(int)
     * @see #addSoldi(int) 
     * @see #calcoloSoldiBanca(int)
     */
    private void pagamentoPedaggio(Tabellone tabellone,int nGiocatore){
        if (isTabellone(tabellone) && !this.imprigionato) {
            int importo = tabellone.getImporto(getY(), getX(),this.soldi);
            Banca.addImporto(calcoloSoldiBanca(importo));
            addSoldi(importo);
            controlloSoldi(tabellone,nGiocatore);

        }
    }

    /**
     * <p>Metodo utile nel caso un giocatore non riesca a pagare la somma corrispondente alla banca.</p>
     * @param pedaggio somma da pagare
     * @return somma che il giocatore riesce a pagare 
     */
    private int calcoloSoldiBanca(int pedaggio){
        int soldiDaAggiungere=-pedaggio;
        if (pedaggio>0 || (soldiDaAggiungere <this.soldi)) return soldiDaAggiungere;
        return this.soldi;

    }

    /**
     * <p>Metodo utilizzato {@link monopoly.Gioco#turno(Giocatore)} si occupa di aggiornare la posizione del giocatore </p>
     * @param passi numero ottenuto dai dadi.
     * @param tabellone per aggiornare la posizione.
     * @param giocatore indica la posizione del giocatore nel array {@link monopoly.Gioco#giocatori}.
     * @see #spostaSimbolo(String, Tabellone, int) Metodo per aggiornare la casella
     * @see #spostamentoGiocatore(int) Metodo per cambiare le coordinate del giocatore
     * @see #pagamentoPedaggio(Tabellone, int) Metodo per aggiungere i soldi coretti al giocatore.
     */
    public void updatePosizione(int passi, Tabellone tabellone,int giocatore){
        if (isTabellone(tabellone)) {
            spostaSimbolo(" ", tabellone, giocatore);
            spostamentoGiocatore(passi);
            if (controlloGiocatoreInVaiInPrigione(tabellone)) {
                spostaGiocatoreInPrigione();
            }
            spostaSimbolo(this.simbolo, tabellone, giocatore);
            pagamentoPedaggio(tabellone,giocatore);
        }
    }

    @Override
    public void spostaGiocatoreInPrigione() {
        this.imprigionato = true;
        this.tentativiPerPrigione = Costanti.TENTATIVI_PRIGIONE;
        this.movimentoGiocatore.spostaGiocatoreInPrigione();
    }

    /**
     * Metodo utilizzato {@link monopoly.schermate.SchermataIniziale#controlloSimboli(char, Giocatore[])} per poter gestire l'inserimento giocatori.
     * @param giocatoreDaControllare {@code char} del giocatore da controllare
     * @return True se due giocatori hanno lo stesso simbolo.
     */
    public boolean isSimboloUguale(char giocatoreDaControllare){
        boolean risposta = giocatoreDaControllare==this.simboloChar;
        if (risposta){
            System.out.println("Simbolo gia utilizzato dal giocatore: " + this.nome);
        }
        return risposta;

    }

    public static boolean checkForNullGiocatore(Giocatore giocatore){
        return giocatore == null;
    }

    /**
     *
     * @return {@code String} stringa con solo il colore del giocatore
     */
    public String getColore() {
        return colore;
    }

    private boolean controlloGiocatoreInVaiInPrigione(Tabellone tabellone){ // da cambiare il movimento modificando il cambio delle coordinate
        return tabellone.isVaiInPrigione(getY(), getX());
    }

    public boolean isImprigionato() {
        return imprigionato;
    }

    public boolean tryToEscape(int i, int i1, Tabellone tabellone, int numeroGiocatoreCorrente) {
        tentativiPerPrigione--;
        boolean uscita= i == i1;

        if (tentativiPerPrigione <= 0) {
            Banca.addImporto(Costanti.IMPORTO_PER_USCIRE_PRIGIONE);
            addSoldi(-Costanti.IMPORTO_PER_USCIRE_PRIGIONE);
            controlloSoldi(tabellone,numeroGiocatoreCorrente);
            uscita=true;
            this.imprigionato=false;
        }
        return uscita;
    }


}
