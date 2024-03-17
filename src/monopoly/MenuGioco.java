package monopoly;

import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.ScannerUtils;

public class MenuGioco implements MenuInterfaccia{
    @Override
    public String toString(){
        return """
                1. Mostra capitale giocatore corrente
                2. Tira il dado
                Scelta:\s
                """;
    }
    @Override
    public void menu(Giocatore currentGiocatore){
        if (isGiocatore(currentGiocatore)){
            int scelta;
            do {
                System.out.println("E' il turno di " + currentGiocatore.getNome());
                System.out.println(this);
                scelta = ScannerUtils.readIntegerInRange(1,2);
                if (scelta == 1) {
                    System.out.println(currentGiocatore.getSoldi());
                }
            } while (scelta != 2);
        }

    }





}
