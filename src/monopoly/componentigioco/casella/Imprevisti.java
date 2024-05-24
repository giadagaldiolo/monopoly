package monopoly.componentigioco.casella;

import monopoly.Coordinate;

public class Imprevisti extends CaselleCarte{

    public Imprevisti(Casella[][] caselle) {
        super();
        setCasella(caselle);
    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo=NomiCaselle.IMPREVISTI;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());
    }

    @Override
    public String infoCasella() {
        return super.infoCasella() + " imprevisti";
    }

}
