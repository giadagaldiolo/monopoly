package monopoly.componentigioco.casella;

public enum NomiCaselle {
    MARRONE(new String[]{"Vicolo Corto", "Vicolo Stretto"}),
    AZZURO(new String[]{"Bastioni Gran Sasso", "Viale Monterosa", "Viale Vesuvio"}),
    ROSA(new String[]{"Via Accademia", "Corso Ateneo", "Piazza Università"}),
    GRIGIO(new String[]{"Via Verdi", "Corso Raffaello", "Piazza Dante"}),
    ROSSO(new String[]{"Via Marco Polo", "Corso Magellano", "Largo Colombo"}),
    GIALLO(new String[]{"Viale Costantino", "Viale Traiano", "Piazza Giulio Cesare"}),
    VERDE(new String[]{"Via Roma", "Corso Impero", "Largo Augusto"}),
    BLU(new String[]{"Viale dei Giardini", "Parco della Vittoria"}),
    NERO(new String[]{"Stazione Sud", "Stazione Nord", "Stazione Est", "Stazione Ovest", "Società Acqua Potabile", "Società Elettrica","Tassa di Lusso","Tassa Patrimoniale"});

    private final String [] nomi;

    NomiCaselle(String [] nomi){
        this.nomi=nomi;
    }

}
