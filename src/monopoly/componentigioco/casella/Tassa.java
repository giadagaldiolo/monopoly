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

    public void setCasella(Casella [][] caselle){
        int[] coordinate = calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }


    private int[] calcoloCoordinate(Casella [][]caselle){
        int y,x;

        do{
            Random random= new Random();
            y= random.nextInt(Costanti.RIGHE);
            x= random.nextInt(Costanti.CASELLE_PER_RIGA);
        }while (Tabellone.controlloPosizione(y,x) || (caselle[y][x]!=null) );
        return new int[]{y,x};

    }

}
