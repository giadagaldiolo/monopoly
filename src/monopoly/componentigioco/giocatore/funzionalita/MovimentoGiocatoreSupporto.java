package monopoly.componentigioco.giocatore.funzionalita;


import monopoly.componentigioco.Tabellone;

public interface MovimentoGiocatoreSupporto {

    boolean cambioCoordinate();


    int  getX();

    int getY();

    default boolean isTabellone(Tabellone tabellone){
        return tabellone != null;
    }
    default void spostaSimbolo(String simbolo,Tabellone tabellone,int giocatore){
        if (isTabellone(tabellone)) {
            tabellone.modificaCasella(simbolo, getY(), getX(), giocatore);
        }
    }


}
