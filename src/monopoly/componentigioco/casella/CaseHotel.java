package monopoly.componentigioco.casella;

public interface CaseHotel extends Acquistabile {
    void acquistoCasaHotel(int numeroAcquisti);
    int getNCase();
    boolean isHotelAcquistabile();
    int caseAcquistabili();


}
