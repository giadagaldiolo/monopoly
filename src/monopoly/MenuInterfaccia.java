package monopoly;

import monopoly.componentigioco.giocatore.Giocatore;

public interface MenuInterfaccia {
    @Override
    String toString();
    void menu(Giocatore currentGiocatore);
    default boolean isGiocatore(Giocatore giocatore){
        return giocatore!=null;
    }

}




//implements se servono i metodi se no direttamente composizione