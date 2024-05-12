package monopoly.componentigioco.giocatore.funzionalita;


import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.casella.Casella;

/**
 * <i>Interfaccia utilizzata per impostare i metodi necessari a {@link monopoly.componentigioco.giocatore.Giocatore} per il movimento.</i>
 */

public interface MovimentoGiocatoreSupporto {

    boolean cambioCoordinate();

    int  getX();

    int getY();

    void spostaGiocatoreInPrigione(Casella casella,int nGiocatore);

    default boolean isTabellone(Tabellone tabellone){
        return tabellone != null;
    }
    default boolean isCasella(Casella casella){
        return casella != null;
    }

    /**
     * Modifica una casella con il carattere in ingresso.
     * @param simbolo simboloGiocatore

     * @param giocatore indica la posizione del giocatore nel array {@link monopoly.Gioco#giocatori}.
     */
    default void spostaSimbolo(String simbolo,Casella casella,int giocatore){
        if (isCasella(casella)) {
            casella.aggiungiCarattere(simbolo, giocatore);
        }
    }



}
