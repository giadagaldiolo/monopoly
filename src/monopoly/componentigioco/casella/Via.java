package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

public class Via extends Casella {


    public Via(int y, int x) {
        super(y, x);
        //forse deve essere nero
    }


    @Override
    public void setPedaggioDefault() {
        setPedaggio(Costanti.IMPORTO_DEL_VIA);
    }
}
