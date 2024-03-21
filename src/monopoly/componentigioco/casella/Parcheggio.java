package monopoly.componentigioco.casella;

import monopoly.utilita.Colori;

public class Parcheggio extends Casella {
    private int pedaggio = 0;
    private final String colore;
    public Parcheggio(String nome, int y, int x) {
        super(nome, y, x);
        this.colore= Colori.sceltaColore(true);
    }
    @Override
    public int getPedaggio() {
        return pedaggio;
    }

    @Override
    public String getColore() {
        return colore;
    }
}
