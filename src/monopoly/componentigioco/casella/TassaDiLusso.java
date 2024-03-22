package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

public class TassaDiLusso extends Casella {

    public TassaDiLusso(String nome, int y, int x) {
        super(nome, y, x);

    }
    public void setTipoDefault(){
        super.setTipoCasella(TipoCasella.TASSA);
    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(Costanti.IMPORTO_TASSA_LUSSO);
    }
}
