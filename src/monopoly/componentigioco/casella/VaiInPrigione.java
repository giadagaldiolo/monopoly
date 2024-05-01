package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.utilita.Costanti;

public class VaiInPrigione extends Casella {

    public VaiInPrigione() {
        super();
        setCoordinate(new Coordinate(0,Costanti.CASELLE_PER_RIGA-1));

    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo = NomiCaselle.SINGOLE;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());
    }

    @Override
    public void setPedaggioDefault() {
        super.setPedaggio(0);
    }

    @Override
    public String infoCasella() {
        return "";
    }
}
