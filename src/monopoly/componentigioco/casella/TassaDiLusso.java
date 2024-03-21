package monopoly.componentigioco.casella;

import monopoly.utilita.Colori;
import monopoly.utilita.Costanti;

public class TassaDiLusso extends Tasse{
    private int pedaggio= Costanti.IMPORTO_TASSA_LUSSO;
    private final String colore;
    public TassaDiLusso(String nome, int y, int x) {
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
