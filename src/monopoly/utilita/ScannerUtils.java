package monopoly.utilita;

import java.util.Scanner;

public abstract class  ScannerUtils {
    private static final Scanner scanner=new Scanner(System.in);
    private static final int charMax=8;

    static void chiudiScanner(){
        scanner.close();
    }

    public static String inputNomeGiocatore(final int numeroGiocatore){
        while (true){
            System.out.println("Inserisci nome giocatore " + numeroGiocatore);
            String nome = scanner.nextLine().strip(); // non posso mettere this perche static
            if ((nome.length()<=charMax) && (!nome.isBlank())){
                return nome;
            }
            System.out.println("Il nome deve avere massimo " + charMax +" caratteri e non deve essere vuoto");
        }

    }



    public static char inputSimboloGiocatore(final int numeroGiocatore){
        while (true) {
            System.out.println("Inserisci simbolo giocatore " + numeroGiocatore);
            String inputUtente = scanner.nextLine().strip().toUpperCase(); // non posso mettere this perche static
            if ((inputUtente.length()==1) && (!inputUtente.isBlank())){
                return inputUtente.charAt(0);
            }
            System.out.println("Inserire soltanto e almeno un carattere");
        }
    }

    public static int readIntegerInRange(int min, int max) {
        while (true) {
            System.out.println("Inserisci un numero tra " + min + " e " + max + ":");
            if (scanner.hasNextInt()) {
                int inputUser = scanner.nextInt();
                if (!(inputUser < min || inputUser > max)){
                    emptyTheScanner();
                    return inputUser;
                }
                System.out.println("Errore: il numero non è valido.");
            }else {
                System.out.println("Errore: non hai inserito un numero.");
            }
            emptyTheScanner();
        }
    }

    private static void emptyTheScanner() { scanner.nextLine(); }




}
