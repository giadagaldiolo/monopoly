package monopoly.componentigioco.giocatore;

import monopoly.componentigioco.Banca;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatore;
import monopoly.componentigioco.giocatore.funzionalita.MovimentoGiocatoreSupporto;
import monopoly.utilita.Costanti;
import monopoly.utilita.Colori;


public class Giocatore  implements MovimentoGiocatoreSupporto {
    private static int nGiocatoriInGioco= Costanti.NUMERO_GIOCATORI;
    private String nome;
    private String simbolo;
    private char simboloChar;
    private int soldi;
    private boolean turno;
    private  String colore;
    private boolean bancarotta=false;
    private final MovimentoGiocatoreSupporto movimentoGiocatore; // se faccio cosi invece di usare direttamente la classe limito le funzioni



    public Giocatore(String nome, char simbolo, int yMax, int xMax) {

        this.movimentoGiocatore= new MovimentoGiocatore(xMax,yMax);

        impostaCaratteristiche(nome,simbolo);
        impostaColore();



    }
   private void impostaCaratteristiche(String nome,char simbolo){

       this.nome = controlloNome(nome) ? "Nome sconosciuto" : nome;
       this.simboloChar = controlloSimbolo(simbolo) ? 'X' : simbolo;
       this.soldi = Costanti.IMPORTO_INIZIALE_GIOCATORE;
       Banca.addImporto(-Costanti.IMPORTO_INIZIALE_GIOCATORE);


   }
   private void impostaColore(){
       String colore = Colori.sceltaColore(false);
       this.colore=colore;
       this.simbolo = colore+this.simboloChar+Costanti.ANSI_RESET;

   }

    private boolean controlloNome(String nome){
        return nome == null || nome.isBlank();
    }
    private boolean controlloSimbolo(char simbolo){
        return simbolo==' ' ;
    }



    public static int getNGiocatoriInGioco() {
        return nGiocatoriInGioco;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getSoldi() {
        return soldi;
    }

    public void addSoldi(final int soldi) {
        this.soldi += soldi;
        controlloSoldi();

    }


    private void controlloSoldi(){
        if(this.soldi <= 0){
            System.out.println("Il giocatore "+ nome +" ha perso" );
            this.bancarotta=true;
            nGiocatoriInGioco--;

        }
    }

    public boolean isBancarotta(){return bancarotta; }

    public String getNome() {
        return nome;
    }

    public int [] getCoordinate(){
        return new int[]{getY(),getX()};
    }
    @Override
    public int getX() {
        return this.movimentoGiocatore.getX();
    }
    @Override
    public int getY() {
        return this.movimentoGiocatore.getY();
    }
    public void spostamentoGiocatore(int dado){
        for (int i = dado; i >0 ; i--) {
            if (cambioCoordinate()){ // controlla se completa un giro
                addSoldi(Costanti.IMPORTO_DEL_VIA);
                Banca.addImporto(-Costanti.IMPORTO_DEL_VIA);
            }
        }


    }


    @Override
    public boolean cambioCoordinate(){
        return this.movimentoGiocatore.cambioCoordinate();

    }


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

    public String getColore() {
        return colore;
    }
}
