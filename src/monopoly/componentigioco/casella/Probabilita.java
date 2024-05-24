package monopoly.componentigioco.casella;

import monopoly.Coordinate;

public class Probabilita extends CaselleCarte{

    public Probabilita(Casella[][] caselle) {
        super();
        setCasella(caselle);
    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo=NomiCaselle.PROBABILITA;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());
    }


    @Override
    public String infoCasella() {
        return super.infoCasella() + " probabilità";
    }

}
