package monopoly.componentigioco.casella;

import monopoly.utilita.Colori;
import monopoly.utilita.Costanti;

import java.util.Random;

public class Stazione extends Casella{

    private int pedaggio;
    private final String colore;

    public Stazione(String nome, int y, int x) {
        super(nome, y, x);
        Random random = new Random();
        this.pedaggio = random.nextInt(Costanti.IMPORTO_PEDAGGIO_MIN,Costanti.IMPORTO_PEDAGGIO_MAX+1);
        this.colore= Colori.sceltaColore(true); //deve essere nero
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
