import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner=new Scanner(System.in);
    private static  int charMax=8;

    static void chiudiScanner(){
        scanner.close();
    }

    public static String inserisciNome(final int numeroGiocatore){
        String nome="";

        do {
            System.out.println("Inserisci nome giocatore " + numeroGiocatore);
            nome = scanner.nextLine().strip(); // non posso mettere this perche static
            if ((nome.length()<=charMax) && (!nome.isBlank())){
                return nome;

            }
            System.out.println("Il nome deve essere massimo di " + charMax +" e non deve essere vuoto");
        }while (true);

    }
}
