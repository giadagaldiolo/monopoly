package monopoly.componentigioco.casella;

import monopoly.componentigioco.giocatore.Giocatore;

public interface Acquistabile {
    void acquistoTerreno(Giocatore proprietario);
    Giocatore getProprietario();


}
