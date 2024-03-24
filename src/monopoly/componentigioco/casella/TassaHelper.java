package monopoly.componentigioco.casella;

import monopoly.componentigioco.Tabellone;
import monopoly.utilita.Costanti;

import java.util.Random;

public abstract class TassaHelper {
    public static void creaTasse(Casella[][] caselle){
        int [] coordinate;
        coordinate= calcoloCoordinate(caselle);
        caselle[coordinate[0]][coordinate[1]]=new TassaDiLusso(coordinate[0],coordinate[1]);
        coordinate= calcoloCoordinate(caselle);
        caselle[coordinate[0]][coordinate[1]]=new TassaPatrimoniale(coordinate[0],coordinate[1]);




    }


    private static int[] calcoloCoordinate(Casella [][]caselle){
        int y,x;

        do{
            Random random= new Random();
            y= random.nextInt(Costanti.RIGHE);
            x= random.nextInt(Costanti.CASELLE_PER_RIGA);
        }while (Tabellone.controlloPosizione(y,x) || (caselle[y][x]!=null) );
        return new int[]{y,x};

    }

}
