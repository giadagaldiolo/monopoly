package monopoly.componentigioco.carte;


import monopoly.Coordinate;
import monopoly.componentigioco.Tabellone;

public class VaiA extends Carta{
    private final Coordinate coordinateDiArrivo;
    public VaiA(String descrizione, String terzaInformazione) {
        super(descrizione);
        this.coordinateDiArrivo = Tabellone.controlloCasella(terzaInformazione);
    }

    public Coordinate getCoordinateDiArrivo() {
        return coordinateDiArrivo;
    }
}
