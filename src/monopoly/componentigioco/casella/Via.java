package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

public class Via extends Casella {


    public Via(String nome, int y, int x) {
        super(nome, y, x);
        //forse deve essere nero
    }

    @Override
    public void setPedaggioDefault() {
        setPedaggio(Costanti.IMPORTO_DEL_VIA);
    }
}
