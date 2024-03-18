package monopoly.schermate;

import monopoly.componentigioco.giocatore.Giocatore;

public class SchermataFinale extends Schermata{
    private final Giocatore vincitore;
    private final String colore;
    public SchermataFinale(Giocatore vincitore){
        this.vincitore = isGiocatore(vincitore) ? vincitore : giocatoreDefault() ;
        this.colore=vincitore.getColore();

    }
    private Giocatore giocatoreDefault(){
        return new Giocatore("Sconosciuto",'S',0,0);
    }

    private boolean isGiocatore(Giocatore vincitore){
        return vincitore!=null;
    }
    @Override
    public String toString(){
        String nomeGiocatore = getStringaDaStampare(this.vincitore.getNome());
        return this.colore+ """
                        * * * * * * * * * * * * * * * * * * * * * * *
                        *                                           *
                        *              PARTITA FINITA!              *
                        *               Il giocatore                *
                        *%s*
                        *            ha vinto la partita            *
                        *              CONGRATULAZIONI!             *
                        *                                           *
                        * * * * * * * * * * * * * * * * * * * * * * *
                                                                  
                        """.formatted(nomeGiocatore);
    }

    private String getStringaDaStampare(String giocatore) {
        if (!giocatore.isBlank()) {
            int larghezzaSchermata = 43;
            int nSpaziRichiestiTotali = ((larghezzaSchermata - giocatore.length()));
            int nSpaziRichiestiPrima = (nSpaziRichiestiTotali / 2);
            String spazio = " ";
            return spazio.repeat(nSpaziRichiestiPrima) + giocatore + spazio.repeat(nSpaziRichiestiTotali - nSpaziRichiestiPrima);
        }else {
            return "Stringa vuota";
        }
    }


}
