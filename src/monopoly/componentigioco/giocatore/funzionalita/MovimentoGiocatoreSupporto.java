package monopoly.componentigioco.giocatore.funzionalita;


import monopoly.componentigioco.Tabellone;

/**
 * <i>Interfaccia utilizzata per impostare i metodi necessari a {@link monopoly.componentigioco.giocatore.Giocatore} per il movimento.</i>
 */

public interface MovimentoGiocatoreSupporto {

    boolean cambioCoordinate();

    int  getX();

    int getY();

    default boolean isTabellone(Tabellone tabellone){
        return tabellone != null;
    }

    /**
     * Modifica una casella con il carattere in ingresso.
     * @param simbolo simboloGiocatore
     * @param tabellone per modificare le caselle
     * @param giocatore indica la posizione del giocatore nel array {@link monopoly.Gioco#giocatori}.
     */
    default void spostaSimbolo(String simbolo,Tabellone tabellone,int giocatore){
        if (isTabellone(tabellone)) {
            tabellone.modificaCasella(simbolo, getY(), getX(), giocatore);
        }
    }


}
