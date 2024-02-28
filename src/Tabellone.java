public class Tabellone {
    private static Casella[] caselle;
    private static final int CASELLE_PER_RIGA = 5;
    private static final int LARGHEZZA_CASELLA = 22;

    public Tabellone(Casella[] caselle) {
        Tabellone.caselle = caselle;
    }

    public static void mostra(){
        Casella currentCell = caselle[0];
        String spazio = " ";
        String trattino = "-";
        for (int i = 0; i < CASELLE_PER_RIGA; i++) {
            if (i == 0 || i == 1 || i == CASELLE_PER_RIGA -1)
                System.out.print(trattino.repeat((LARGHEZZA_CASELLA * CASELLE_PER_RIGA)));
            else {
                System.out.print(trattino.repeat(LARGHEZZA_CASELLA));
                System.out.print(spazio.repeat((LARGHEZZA_CASELLA * (CASELLE_PER_RIGA-2))));
                System.out.print(trattino.repeat(LARGHEZZA_CASELLA));
            }
            System.out.println();

            for (int d = 0; d < 5; d++) {
                for (int col = 0; col < CASELLE_PER_RIGA; col++) {
                    if (currentCell == null)
                        System.out.print(spazio.repeat(LARGHEZZA_CASELLA));
                    else {
                        System.out.print("|");
                        stampaDettagliCasella(d, currentCell);
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
        System.out.print(trattino.repeat((LARGHEZZA_CASELLA * CASELLE_PER_RIGA)));
    }

    private static void stampaDettagliCasella(final int d, final Casella currentCell) {
        String spazio = " ";
        switch (d) {
            case 0:
                String primaRiga = currentCell.getNome();
                System.out.print(primaRiga + spazio.repeat(((LARGHEZZA_CASELLA -2) - primaRiga.length())));
                break;
            case 1:
                String secondaRiga = "Paga " + currentCell.getPedaggio();
                System.out.print(secondaRiga + spazio.repeat(((LARGHEZZA_CASELLA-2) - secondaRiga.length())));
                break;
            case 2: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((LARGHEZZA_CASELLA -2)));
                break;
            case 3: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((LARGHEZZA_CASELLA -2)));
                break;
            case 4:
                StringBuilder quintaRiga = new StringBuilder();
                for (int i = 0; i < currentCell.getNumGiocatori(); i++)
                    quintaRiga.append(currentCell.getGiocatore(i)).append(" ");
                System.out.print(quintaRiga + spazio.repeat(((LARGHEZZA_CASELLA -2) - quintaRiga.length())));
                break;
        }
    }
}
