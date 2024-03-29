package monopoly.componentigioco.casella;


import monopoly.Coordinate;
import monopoly.utilita.Costanti;

public class Stazione extends Casella{
    static int stazioniRimaste=4;

    public Stazione(Casella [][] caselle) {
        super();
        setCasella(caselle);
    }

    private void setCasella(Casella [][] caselle){
        int y=0 ,x=0;
        x = switch (stazioniRimaste) {
            case 1 -> Costanti.CASELLE_PER_RIGA / 2;
            case 2 -> {
                y = Costanti.RIGHE - 1;
                yield Costanti.CASELLE_PER_RIGA / 2;
            }
            case 3 -> {
                y = Costanti.RIGHE / 2;
                yield 0;
            }
            case 4 -> {
                y = Costanti.RIGHE / 2;
                yield Costanti.CASELLE_PER_RIGA - 1;
            }
            default -> x;
        };
        setCoordinate(new Coordinate(y,x));


        caselle[y][x]=this;
        stazioniRimaste--;

    }

    @Override
    public void setNomeColoreDefault(){
        NomiCaselle tipo = NomiCaselle.TRENO;
        super.setNomeColore(tipo.getNome(stazioniRimaste-1),tipo.getColore());

    }


}
