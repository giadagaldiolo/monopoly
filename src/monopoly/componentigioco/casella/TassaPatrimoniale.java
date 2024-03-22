package monopoly.componentigioco.casella;

public class TassaPatrimoniale extends Casella {

    public TassaPatrimoniale(String nome, int y, int x) {
        super(nome, y, x);
        //pedaggio?
    }
    public void setTipoDefault(){
        super.setTipoCasella(TipoCasella.TASSA);
    }


}
