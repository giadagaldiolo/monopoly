package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

public class TassaDiLusso extends Casella {

    public TassaDiLusso(int y, int x) {
        super(y, x);

    }


    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(Costanti.IMPORTO_TASSA_LUSSO);
    }
}
