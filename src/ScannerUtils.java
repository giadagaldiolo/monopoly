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

    public static char inputSimboloGiocatore(final int numeroGiocatore){
        String inputUtente;
        do {
            System.out.println("Inserisci simbolo giocatore " + numeroGiocatore);
            inputUtente = scanner.nextLine().strip().toUpperCase(); // non posso mettere this perche static
            if ((inputUtente.length()==1) && (!inputUtente.isBlank())){
                return inputUtente.charAt(0);
            }
            System.out.println("Inserire soltanto e almeno un carattere");
        } while (true);
    }

    public static int readIntegerInRange(int min, int max) {
        int inputUser = 0;
        boolean correctInput = false;
        while (!correctInput) {
            System.out.println("Please enter a number between " + min + " and " + max + ":");
            if (scanner.hasNextInt()) {
                inputUser = scanner.nextInt();
                if (inputUser < min || inputUser > max)
                    System.out.println("Error: number not in range.");
                else
                    correctInput = true;
            } else {
                System.out.println("Error: input is not a number.");
                emptyTheScanner();
            }
        }
        emptyTheScanner();
        return inputUser;
    }

    private static void emptyTheScanner() {
        scanner.nextLine();
    }




}
