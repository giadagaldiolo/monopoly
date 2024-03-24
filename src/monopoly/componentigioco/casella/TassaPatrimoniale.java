package monopoly.componentigioco.casella;


public class TassaPatrimoniale extends Tassa {

    public TassaPatrimoniale(Casella[][] caselle) {
        super();
        setCasella(caselle);
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
