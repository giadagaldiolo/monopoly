public class Giocatore {
    private String nome;
    private String simbolo;
    private char simboloChar;
    private int soldi;
    private boolean turno;
    private String colore;
    private final int  yMax=Costanti.RIGHE-1;
    private final int  xMax= Costanti.CASELLE_PER_RIGA-1;

    private Coordinate coordinate = new Coordinate(yMax,xMax);

    public Giocatore(String nome, char simbolo, int soldi) {
        this.nome = nome;
        this.simboloChar=simbolo;
        this.soldi = soldi;
        this.colore=Colori.sceltaColore();
        this.simbolo = colore+simbolo+Costanti.ANSI_RESET;
    }

    public String getSimbolo() {
        return simbolo;
    }
    public char getSimboloChar() {
        return simboloChar;
    }

    public int getSoldi() {
        return soldi;
    }



    public String getNome() {
        return nome;
    }

    public int [] cordinate(){
        int cordinate[]= {this.coordinate.getY(),this.coordinate.getX()};
        return cordinate;
    }

    public void setTurnoTrue() {
        this.turno = true;
    }

    public void setTurnoFalse() {
        this.turno = false;
    }

    public boolean isTurno() {
        return turno;
    }
    public void cambioCasella(int dado){
        if (dado==0){
            return;
        }else {
            cambioCoordinate(dado);
        }
    }



    private void cambioCoordinate(int dado){
        int nuovaCoordinataX=this.coordinate.getX();
        int nuovaCoordinataY= this.coordinate.getY();
        int prodotto = nuovaCoordinataY*nuovaCoordinataX;
        int sinistraSopra = -1;
        int destraSotto = 1;
        if ( controlloAngoli(prodotto,nuovaCoordinataY,nuovaCoordinataX) ){

            if (nuovaCoordinataY==this.yMax){
                movimentoOrizzontale(sinistraSopra,nuovaCoordinataX);

            }else {
                movimentoOrizzontale(destraSotto,nuovaCoordinataX);
            }

        }else{

            if (nuovaCoordinataX==this.xMax){
                movimentoVerticale(destraSotto,nuovaCoordinataY);


            }else {
                movimentoVerticale(sinistraSopra,nuovaCoordinataY);

            }

        }
        cambioCasella(dado-1);
    }
    private boolean controlloAngoli(int prodotto , int nuovaCoordinataY, int nuovaCoordinataX){
        return (prodotto!=0 && nuovaCoordinataY==this.yMax) || (prodotto!=xMax*yMax && nuovaCoordinataY==0 && nuovaCoordinataX!=this.xMax)  ;
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
        boolean risposta= giocatoreDaControllare==this.simboloChar;
        if (risposta){
            System.out.println("Simbolo gia utilizzato dal giocatore: " + this.nome);

        }
        return risposta ;

    }










}
