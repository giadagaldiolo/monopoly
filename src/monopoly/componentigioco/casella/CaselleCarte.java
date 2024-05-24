package monopoly.componentigioco.casella;

import monopoly.Coordinate;

public class CaselleCarte extends Casella{

    public static void creaCaselleCarte(Casella[][] caselle){
        for(int i=0; i<3; i++){
            new Imprevisti(caselle);
            new Probabilita(caselle);
        }
    }

    protected void setCasella(Casella [][] caselle){
        int[] coordinate = NomiHelper.calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }
    @Override
    public String infoCasella() {
        return "Pesca una carta";
    }
}
