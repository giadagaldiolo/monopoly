package monopoly.schermate;

import monopoly.componentigioco.giocatore.Giocatore;

public class SchermataFinale implements SchermataInterface {
    private final Giocatore vincitore;
    public SchermataFinale(Giocatore vincitore){
        this.vincitore=vincitore;
    }
    @Override
    public String toString(){
        String nomeGiocatore = getStringaDaStampare(this.vincitore.getNome());
        return this.vincitore.getColore()+ """
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
