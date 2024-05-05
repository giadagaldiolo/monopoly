package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.componentigioco.Tabellone;
import monopoly.utilita.Costanti;

import java.util.Random;

public abstract class Tassa extends Casella {

    public static void creaTasse(Casella[][] caselle){
        new TassaDiLusso(caselle);
        new TassaPatrimoniale(caselle);

    }

    protected void setCasella(Casella [][] caselle){
        int[] coordinate = NomiHelper.calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }



}
