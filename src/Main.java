
public class Main {
    public static void main(String[] args) {
        Casella[][] caselle = Tabellone.crea();
        Tabellone tabellone = new Tabellone(caselle);
        Tabellone.mostra();

//        ScannerUtils.inputNomeGiocatore(2);
//        ScannerUtils.inputSimboloGiocatore(2); // sono solo di prova

    }
}
