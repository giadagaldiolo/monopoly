public class Giocatore {
    private String nome;
    private String simbolo;
    private char simboloChar;
    private int soldi;
    private boolean turno;
    private final int  yMax=Costanti.RIGHE-1;
    private final int  xMax= Costanti.CASELLE_PER_RIGA-1;

    private final Coordinate coordinate = new Coordinate(yMax,xMax);

    public Giocatore(String nome, char simbolo) {
        this.nome = nome;
        this.simboloChar=simbolo;
        this.soldi =Costanti.IMPORTO_INIZIALE_GIOCATORE;
        Banca.setImporto(-Costanti.IMPORTO_INIZIALE_GIOCATORE);
        String colore = Colori.sceltaColore(false);
        this.simbolo = colore +simbolo+Costanti.ANSI_RESET;


    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(final int soldi) {
        this.soldi += soldi;
    }

    public void controlloSoldi(){
        if(soldi <= 0){

        }
    }

    public String getNome() {
        return nome;
    }

    public int [] getCoordinate(){
        return new int[]{this.coordinate.getY(),this.coordinate.getX()};
    }

    public void cambioCasella(int dado){
        if (dado == 0){
            return;
        } else {
            cambioCoordinate(dado);
        }
    }



    private void cambioCoordinate(int dado){

        int nuovaCoordinataX=this.coordinate.getX();
        int nuovaCoordinataY= this.coordinate.getY();
        int prodotto = nuovaCoordinataY*nuovaCoordinataX;
        int sinistraSopra = -1;
        int destraSotto = 1;
        if (controlloAngoli(prodotto,nuovaCoordinataY,nuovaCoordinataX) ){

            if (nuovaCoordinataY==this.yMax){
                movimentoOrizzontale(sinistraSopra,nuovaCoordinataX);
            } else {
                movimentoOrizzontale(destraSotto,nuovaCoordinataX);
            }
        } else{
            if (nuovaCoordinataX==this.xMax){
                movimentoVerticale(destraSotto,nuovaCoordinataY);
            } else {
                movimentoVerticale(sinistraSopra,nuovaCoordinataY);
            }
        }
        cambioCasella(dado-1);
    }
    private boolean controlloAngoli(int prodotto , int nuovaCoordinataY, int nuovaCoordinataX){
        return (prodotto!=0 && nuovaCoordinataY==this.yMax) || (nuovaCoordinataY==0 && nuovaCoordinataX!=this.xMax);
    }

    private void movimentoOrizzontale(int movimento,int x){ // sinistra -1 destra 1
        x+=movimento;
        this.coordinate.setX(x);
    }
    private void movimentoVerticale(int movimento,int y){ // sopra -1 , sotto 1
        y+=movimento;
        this.coordinate.setY(y);

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
