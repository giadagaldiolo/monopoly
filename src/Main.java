
public class Main {
    public static void main(String[] args) {
        Casella[] caselle = {
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                null, null, null,
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                null, null, null,
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                null, null, null,
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Pedaggio", 100),
                new Casella("Via", 100),

        };
        Tabellone tabellone = new Tabellone(caselle);
        Tabellone.mostra();

//        ScannerUtils.inputNomeGiocatore(2);
//        ScannerUtils.inputSimboloGiocatore(2); // sono solo di prova

    }
}
