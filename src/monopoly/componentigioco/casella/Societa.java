package monopoly.componentigioco.casella;
import monopoly.Coordinate;


public class Societa extends Casella{
    public static void creaSocieta(Casella[][] caselle){
        for(int i=0; i<2; i++){
            new Societa(caselle);
        }

    }
    public Societa(Casella[][] caselle) {
        super();
        setCasella(caselle);
    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo=NomiCaselle.SOCIETA;
        super.setNomeColore(tipo.getNome(0),tipo.getColore());

    }


    protected void setCasella(Casella [][] caselle){
        int[] coordinate = NomiHelper.calcoloCoordinate(caselle);
        setCoordinate(new Coordinate(coordinate[0],coordinate[0]));
        caselle[coordinate[0]][coordinate[1]]=this;
    }




}
