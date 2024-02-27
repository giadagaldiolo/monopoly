import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner=new Scanner(System.in);
    private static final int charMax=8;

    static void chiudiScanner(){
        scanner.close();
    }

    public static String inputNomeGiocatore(final int numeroGiocatore){
        String nome;

        do {
            System.out.println("Inserisci nome giocatore " + numeroGiocatore);
            nome = scanner.nextLine().strip(); // non posso mettere this perche static
            if ((nome.length()<=charMax) && (!nome.isBlank())){
                return nome;

            }
            System.out.println("Il nome deve avere massimo " + charMax +" caratteri e non deve essere vuoto");
        }while (true);

    }

    public static char inputSimboloGiocatore( final int numeroGiocatore){
        String inputUtente;
        do{
            System.out.println("Inserisci simbolo giocatore " + numeroGiocatore);
            inputUtente = scanner.nextLine().strip(); // non posso mettere this perche static
            if ((inputUtente.length()==1) && (!inputUtente.isBlank())){
                return inputUtente.charAt(0);

            }
            System.out.println("Inserire soltanto e almeno un carattere");
        }while (true);


    }




}
