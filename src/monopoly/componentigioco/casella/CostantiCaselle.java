package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

public class CostantiCaselle {
    public static final int PREZZO_TERRENO_MAX=500+1;
    public static final int PREZZO_TERRENO_MIN =150;
    public static final int PREZZO_CASA_MAX= 125+1;
    public static final int PREZZO_CASA_MIN= 75;
    public static final int PREZZO_HOTEL_MAX= 175+1;
    public static final int PREZZO_HOTEL_MIN= 95;
    public static final int COLORE_CASELLE_NON_PROPRIETA=233;
    public static final int MAX_CASE=4;
    public static final String SPAZIO = " ";
    public static final String TRATTINO = "-";
    public static final String RIGHETTE=TRATTINO.repeat((Costanti.LARGHEZZA_CASELLA));
    public static final int MAX_HOTEL=1;
}
