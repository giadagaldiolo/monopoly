package monopoly.componentigioco.casella;


public class Parcheggio extends Casella {

    public Parcheggio(int y, int x) {
        super(y, x);

    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(0);
    }



}
