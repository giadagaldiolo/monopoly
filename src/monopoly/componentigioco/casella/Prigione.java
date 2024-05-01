package monopoly.componentigioco.casella;

import monopoly.Coordinate;
import monopoly.utilita.Costanti;

public class Prigione extends Casella {
    public Prigione() {
        super();
        setCoordinate(new Coordinate(Costanti.RIGHE-1,0));
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
