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

    void spostaGiocatoreInPrigione(Casella casella);

    default boolean isTabellone(Tabellone tabellone){
        return tabellone != null;
    }
    default boolean isCasella(Casella casella){
        return casella != null;
    }




}
