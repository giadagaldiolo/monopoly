package monopoly.schermate;

import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;
import monopoly.utilita.ScannerUtils;

public class SchermataIniziale extends Schermata{

    @Override
    public String toString() {
        String colore = "\u001B[1;38;5;183m";
        return colore + """
                 __       __                                                    __          \s
                |  \\     /  \\                                                  |  \\         \s
                | $$\\   /  $$  ______   _______    ______    ______    ______  | $$ __    __\s
                | $$$\\ /  $$$ /      \\ |       \\  /      \\  /      \\  /      \\ | $$|  \\  |  \\
                | $$$$\\  $$$$|  $$$$$$\\| $$$$$$$\\|  $$$$$$\\|  $$$$$$\\|  $$$$$$\\| $$| $$  | $$
                | $$\\$$ $$ $$| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$| $$  | $$
                | $$ \\$$$| $$| $$__/ $$| $$  | $$| $$__/ $$| $$__/ $$| $$__/ $$| $$| $$__/ $$
                | $$  \\$ | $$ \\$$    $$| $$  | $$ \\$$    $$| $$    $$ \\$$    $$| $$ \\$$    $$
                 \\$$      \\$$  \\$$$$$$  \\$$   \\$$  \\$$$$$$ | $$$$$$$   \\$$$$$$  \\$$ _\\$$$$$$$
                                                           | $$                    |  \\__| $$
                                                           | $$                     \\$$    $$
                                                            \\$$                      \\$$$$$$
                                
                Premere invio per Iniziare...""" + Costanti.ANSI_RESET;
    }
    public Giocatore[] creaGiocatori(Tabellone tabellone) {
        Giocatore[] giocatori = new Giocatore[Costanti.NUMERO_GIOCATORI];

        for (int i = 0; i < giocatori.length; i++) {
            inserisciGiocatore(i,giocatori);
            tabellone.modificaCasella(giocatori[i].getSimbolo(), Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1, i);
        }
        return giocatori;

    }

    private void inserisciGiocatore(int i,Giocatore[] giocatori){
        char simbolo;
        String nome = ScannerUtils.inputNomeGiocatore(i+1);
        do {
            simbolo = ScannerUtils.inputSimboloGiocatore(i + 1);

        } while (controlloSimboli(simbolo,giocatori));

        giocatori[i] = new Giocatore(nome,simbolo,Costanti.RIGHE-1,Costanti.CASELLE_PER_RIGA-1);

    }

    private boolean controlloSimboli(char simbolo,Giocatore[] giocatori){
        boolean trovato = false;
        if (isGiocatori(giocatori)) {
            for (Giocatore giocatore : giocatori) { // da spostare se si trova il modo

                if (!(Giocatore.checkForNullGiocatore(giocatore)) && giocatore.isSimboloUguale(simbolo)) {
                    trovato = true;
                    break;
                }
            }
        }
        return trovato;
    }

    private boolean isGiocatori(Giocatore[] giocatori){
        return giocatori!=null;
    }


}
