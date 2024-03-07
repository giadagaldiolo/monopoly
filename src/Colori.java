import java.util.Random;

public class Colori {

    private static int [] coloriUsati= new int[Costanti.ANSI_MAX-Costanti.ANSI_MIN+1];
    private static int cntColori=0;



    public static String sceltaColore(boolean ripetuto){
        Random random = new Random();
        String colore ="\u001B[3";
        int numeroColore;
        do {
            numeroColore = random.nextInt(Costanti.ANSI_MIN, Costanti.ANSI_MAX + 1);

        }while (  !ripetuto && isColoreUtilizzato(numeroColore ));
        if (!ripetuto) {
            coloriUsati[++cntColori] = numeroColore;

        }
        colore = colore + numeroColore + "m";
        return colore ;
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
//        System.out.println(utilizzato);
        return utilizzato;

    }
}
