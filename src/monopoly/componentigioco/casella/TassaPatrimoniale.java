package monopoly.componentigioco.casella;

import monopoly.utilita.Colori;

public class TassaPatrimoniale extends Tasse{
    private final String colore;
    public TassaPatrimoniale(String nome, int y, int x) {
        super(nome, y, x);
        this.colore= Colori.sceltaColore(true);
        //pedaggio?
    }

    @Override
    public int getPedaggio() {
        return 0;
    }

    @Override
    public String getColore() {
        return colore;
    }
}
