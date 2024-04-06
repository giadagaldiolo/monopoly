package monopoly.utilita;

import java.util.Random;

public abstract class Colori  {

    private static int [] coloriUsati= new int[Costanti.ANSI_MAX-Costanti.ANSI_MIN+1];
    private static int cntColori=0;


    /**
     * @deprecated la parte di scelta colori che riguarda le caselle
     */
    public static String sceltaColore(boolean ripetuto){ // ripetuto false se non vuoi che si ripetano i colori
        Random random = new Random();
        String colore ="\u001B[1;38;5;";  // bold;background/coloreScritta;? ; colore
        int numeroColore;
        do {
            numeroColore = random.nextInt(Costanti.ANSI_MIN, Costanti.ANSI_MAX + 1);

        }while (!ripetuto && isColoreUtilizzato(numeroColore));
        if (!ripetuto) {
            coloriUsati[++cntColori] = numeroColore;
        }
        colore = colore + numeroColore + "m";
        if (ripetuto) colore+=Costanti.COLORE_SFONDO; // da migliorare in futuro se serve per lo sfondo
        return colore  ;
    }

    private static void resetContatoreColori(){

        if (cntColori>=coloriUsati.length-1){
            cntColori=0;
            coloriUsati= new int[Costanti.ANSI_MAX-Costanti.ANSI_MIN+1];
        }
    }



    private static Boolean isColoreUtilizzato(int coloreScelto){
        boolean utilizzato=false;
        resetContatoreColori();
        for (int colore : coloriUsati) {
            if (colore==coloreScelto){
                utilizzato=true;
                break;
            }

        }
        return utilizzato;

    }
}
