public class Tabellone {
    private Casella[][] caselle ;


    public void mostra(){

        Casella currentCell;
        String spazio = " ";
        String trattino = "-";

        for (int i = 0; i < Costanti.RIGHE; i++) {
            if (i == 0 || i == 1 || i == Costanti.RIGHE -1)
                System.out.print(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
            else {
                System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
                System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA * (Costanti.CASELLE_PER_RIGA-2))));
                System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
            }
            System.out.println();

            for (int d = 0; d < 5; d++) {
                for (int col = 0; col < Costanti.CASELLE_PER_RIGA; col++) {

                    currentCell = caselle[i][col];
                    if (currentCell == null)
                        System.out.print(spazio.repeat(Costanti.LARGHEZZA_CASELLA));
                    else {
                        System.out.print("|");
                        stampaDettagliCasella(d, currentCell);
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
        System.out.print(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
    }

    private void stampaDettagliCasella(final int d, final Casella currentCell) {
        String spazio = " ";
        switch (d) {
            case 0:
                String primaRiga = currentCell.getNome(); // Per sapere quanti spazi aggiungere
                System.out.print(primaRiga + spazio.repeat(((Costanti.LARGHEZZA_CASELLA -2) - primaRiga.length()))); //Tolgo 2 che sono i caratteri ||
                break;
            case 1:
                String secondaRiga = "";
                if (currentCell.getNome().equals("Via")) {
                    secondaRiga = "Ritira " + Costanti.IMPORTO_DEL_VIA;
                } else {
                    secondaRiga = "Paga " + currentCell.getPedaggio();
                }
                System.out.print(secondaRiga + spazio.repeat(((Costanti.LARGHEZZA_CASELLA-2) - secondaRiga.length())));
                break;
            case 2: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA -2)));
                break;
            case 3: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA -2)));
                break;
            case 4:

                StringBuilder quintaRiga = new StringBuilder();
                int spaziDaFare=currentCell.getNumGiocatori()*currentCell.getNumGiocatori();


                for (int i = 0; i < currentCell.getNumGiocatori(); i++) {
                    quintaRiga.append(currentCell.getCharGiocatore(i)).append(" ");



                }

                System.out.print(quintaRiga + spazio.repeat((Costanti.LARGHEZZA_CASELLA -2)-spaziDaFare));
                break;
        }
    }

    public void crea() {
        String nome = "Pedaggio";
        int pedaggio;
        int id = 0;
        this.caselle = new Casella[Costanti.RIGHE][Costanti.CASELLE_PER_RIGA];
        for (int i = 0; i < Costanti.RIGHE; i++) {
            for (int j = 0; j < Costanti.CASELLE_PER_RIGA; j++) {
                if (i > 0 && i < Costanti.RIGHE-1 && j > 0 && j < Costanti.CASELLE_PER_RIGA-1) {
                    caselle[i][j] = null;
                } else {
                    if (i == Costanti.RIGHE-1 && j == Costanti.CASELLE_PER_RIGA-1)
                        nome = "Via";
                    caselle[i][j] = new Casella(nome,i,j);
                }
            }
        }
    }

    public void modificaCasella(String simbolo, int i, int j, int giocatore) {


        caselle[i][j].aggiungiCarattere(simbolo, giocatore);
    }



}
