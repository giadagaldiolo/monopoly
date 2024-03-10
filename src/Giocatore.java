public class Giocatore extends Coordinate {
    private static int nGiocatoriInGioco= Costanti.NUMERO_GIOCATORI;
    private String nome;
    private String simbolo;
    private char simboloChar;
    private int soldi;
    private boolean turno;
    private final int  yMax;
    private final int  xMax;
    private boolean bancarotta=false;



    public Giocatore(String nome, char simbolo,int yMax,int xMax) {
        super(yMax,xMax);
        this.yMax=yMax;
        this.xMax=xMax;
        impostaCaratteristiche(nome,simbolo);
        impostaColore();



    }
   private void impostaCaratteristiche(String nome,char simbolo){

       this.nome = controlloNome(nome) ? "Nome sconosciuto" : nome;
       this.simboloChar = controlloSimbolo(simbolo) ? 'X' : simbolo;
       this.soldi = Costanti.IMPORTO_INIZIALE_GIOCATORE;
       Banca.setImporto(-Costanti.IMPORTO_INIZIALE_GIOCATORE);


   }
   private void impostaColore(){
       String colore = Colori.sceltaColore(false);
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

    public void setSoldi(final int soldi) {
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

    public String getNome() {
        return nome;
    }

    public int [] getCoordinate(){
        return new int[]{super.getY(),super.getX()};
    }

    public void cambioCasella(int dado){
        if (dado>0){

            cambioCoordinate(dado);

        }

    }



    private void cambioCoordinate(int dado){
        int nuovaCoordinataX=super.getX();
        int nuovaCoordinataY= super.getY();
        int prodotto = nuovaCoordinataY*nuovaCoordinataX;
        int movimento = 1; // destraSotto = 1 // sinistraSopra = -1
        if (controlloAngoli(prodotto,nuovaCoordinataY,nuovaCoordinataX) ){
            if (nuovaCoordinataY==this.yMax){
                movimento*=-1;
            }
            movimentoOrizzontale(movimento,nuovaCoordinataX);
        }else{
            if (nuovaCoordinataX!=this.xMax){
                movimento*=-1;
            }
            movimentoVerticale(movimento,nuovaCoordinataY);
        }

        if (isGiroCompleto()){
            setSoldi(Costanti.IMPORTO_DEL_VIA);
            Banca.setImporto(-Costanti.IMPORTO_DEL_VIA);
        }
        cambioCasella(dado-1);
    }
    private boolean controlloAngoli(int prodotto , int nuovaCoordinataY, int nuovaCoordinataX){
        return (prodotto!=0 && nuovaCoordinataY==this.yMax) || (nuovaCoordinataY==0 && nuovaCoordinataX!=this.xMax);
    }



    private boolean isGiroCompleto(){
        return super.getX()==this.xMax && super.getY()==this.yMax;
    }

    private void movimentoOrizzontale(int movimento,int x){ // sinistra -1 destra 1
        x+=movimento;
        super.setX(x);
    }
    private void movimentoVerticale(int movimento,int y){ // sopra -1 , sotto 1
        y+=movimento;
        super.setY(y);

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

}
