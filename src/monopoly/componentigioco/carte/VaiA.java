package monopoly.componentigioco.carte;


import monopoly.Coordinate;
import monopoly.componentigioco.Tabellone;

public class VaiA extends Carta{
    private Coordinate coordinateDiArrivo;
    public VaiA(String descrizione, String terzaInformazione) {
        super(descrizione);
        this.coordinateDiArrivo = Tabellone.controlloCasella(terzaInformazione);
    }

    public Coordinate getCoordinateDiArrivo() {
        return coordinateDiArrivo;
    }

    @Override
    public String toString() {
        return super.toString() + "VaiA{" +
                "coordinateDiArrivo=" + coordinateDiArrivo +
                '}';
    }
}
