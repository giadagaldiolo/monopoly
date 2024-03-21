package monopoly.componentigioco.casella;

import monopoly.utilita.Colori;
import monopoly.utilita.Costanti;

public class Via extends Casella {
    private int pedaggio= Costanti.IMPORTO_DEL_VIA;
    private final String colore;

    public Via(String nome, int y, int x) {
        super(nome, y, x);
        this.colore= Colori.sceltaColore(true); //forse deve essere nero
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
