package monopoly.componentigioco.casella;

import monopoly.Coordinate;

public class TassaPatrimoniale extends Casella {

    public TassaPatrimoniale(int y, int x) {
        super();
        setCoordinate(new Coordinate(y,x));

    }
    @Override
    public String infoCasella() {
        return "Paga 10% del patrimonio";
    }
    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo=NomiCaselle.TASSE;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());

    }



}
