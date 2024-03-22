package monopoly.componentigioco.casella;


public class Parcheggio extends Casella {

    public Parcheggio(String nome, int y, int x) {
        super(nome, y, x);

    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(0);
    }
    @Override
    public void setTipoDefault(){
        super.setTipoCasella(TipoCasella.PARCHEGGIO);
    }
}
