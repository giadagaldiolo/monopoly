package monopoly.componentigioco.giocatore.funzionalita;


import monopoly.componentigioco.Tabellone;

public interface MovimentoGiocatoreSupporto {

    boolean cambioCoordinate();
    void updatePosizione(int passi, Tabellone tabellone,int giocatore);

    int  getX();

    int getY();


}
