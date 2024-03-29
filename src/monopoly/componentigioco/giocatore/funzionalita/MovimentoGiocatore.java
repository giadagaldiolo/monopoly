package monopoly.componentigioco.giocatore.funzionalita;

import monopoly.Coordinate;


public class MovimentoGiocatore  implements MovimentoGiocatoreSupporto {
    Coordinate coordinate;
    private final int xMax;
    private final int yMax;
    public MovimentoGiocatore(int xMax,int yMax){
        this.xMax=xMax;
        this.yMax=yMax;
        this.coordinate=new Coordinate(yMax,xMax);

    }


    public boolean cambioCoordinate(){ // boolean cosi so se ha fatto un giro
        int nuovaCoordinataX=this.coordinate.getX();
        int nuovaCoordinataY= this.coordinate.getY();
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
        return isGiroCompleto();
    }
    private boolean controlloAngoli(int prodotto , int nuovaCoordinataY, int nuovaCoordinataX){
        return (prodotto!=0 && nuovaCoordinataY==this.yMax) || (nuovaCoordinataY==0 && nuovaCoordinataX!=this.xMax);
    }

    private boolean isGiroCompleto(){
        return this.coordinate.getX()==this.xMax && this.coordinate.getY()==this.yMax;
    }

    private void movimentoOrizzontale(int movimento,int x){ // sinistra -1 destra 1
        x+=movimento;
        this.coordinate.setX(x);
    }

    private void movimentoVerticale(int movimento,int y){ // sopra -1, sotto 1
        y+=movimento;
        this.coordinate.setY(y);

    }

    @Override
    public int getX() {
        return this.coordinate.getX();
    }
    @Override
    public int getY() {
        return this.coordinate.getY();
    }






}
