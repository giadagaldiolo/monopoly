package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;
/*
 metodi enum statici ma solo se chiamo una categoria
 se aggiungo a un metodo static posso utilizzarlo direttamente con solo il nome del enum.
 */


/**
 * <i>Enum utile per gestire i nomi, colori e tipi delle caselle</i><p>
 * Ogni istanza contiene un <i>array String</i> con i rispettivi nomi e un <i>int </i> corrispondente al colore. <p>
 */
public enum NomiCaselle {
    TRENO(new String[]{"Stazione Nord","Stazione Sud","Stazione Ovest","Stazione Est"},233),
    SINGOLE (new String[]{"Parcheggio","VIA"},233),
    MARRONE(new String[]{"Vicolo Corto", "Vicolo Stretto"},172),
    AZZURO(new String[]{"Bastioni Gran Sasso", "Viale Monterosa", "Viale Vesuvio"},32),
    ROSA(new String[]{"Via Accademia", "Corso Ateneo", "Piazza Università"},13),
    GRIGIO(new String[]{"Via Verdi", "Corso Raffaello", "Piazza Dante"},244),
    ROSSO(new String[]{"Via Marco Polo", "Corso Magellano", "Largo Colombo"},9),
    GIALLO(new String[]{"Viale Costantino", "Viale Traiano", "Piazza Giulio Cesare"},220),
    VERDE(new String[]{"Via Roma", "Corso Impero", "Largo Augusto"},28),
    BLU(new String[]{"Viale dei Giardini", "Parco della Vittoria"},21),
    TASSE(new String[]{"Tassa di Lusso","Tassa Patrimoniale"},233),
    SOCIETA(new String[]{"Società Acqua Potabile", "Società Elettrica"},233);

    private String [] nomi;

    private final String colore;

    /**
     * Semplice getter del attributo colore
     * @return int colore
     */
    public String getColore(){
        return colore;
    }

    /**
     * Costruttore delle istanze del Enum si occupa di creare il codice ANSI per il colore.
     * @param nomi array di nomi
     * @param colore numero corrispondente al colore con i codici ANSI
     */
    NomiCaselle(String [] nomi ,int colore ){
        this.nomi=nomi;
        this.colore= "\u001B[1;38;5;"+colore+"m"+Costanti.COLORE_SFONDO ; // bold;background/coloreScritta;? ; colore

    }

    /**
     * Semplice getter del array {@link #nomi} dell'istanza
     * @return String[] array di nomi
     */
    public String[] getNomi() {
        return nomi;
    }

    /**
     * <p> Un getter che contiene contiene il metodo {@link #removeName(String nomeTrovato)}.</p>
     * @param i Indice indicante il nome da prendere in considerazione nel array {@link #nomi}
     * @return String Il nome nella posizione {@code i} del array {@link #nomi}
     */
    public String getNome(int i){
        String nome=nomi[i];
        removeName(nome);
        return nome;
    }


    private boolean isNomi(){
        return nomi!=null;
    }

    /**
     * <p>Il metodo si occupa semplicemente di eliminare un nome dal array {@link #nomi} </p>
     * <p>Fa ciò creando un array di dimensione minore che conterà tutti i nomi del array {@link #nomi} meno uno che è il parametro del metodo. </p>
     * <p>Alla fine sovrascrive array {@link #nomi} con il nuovo array modificato.</p>
     * @param nome nome da eliminare
     */
    public void removeName(String nome){
        int nomiRimasti=this.nomi.length-1;
        String[] nuoviNomi;
        int c=0;
        if (nomiRimasti<=0){
            nuoviNomi=null;
        } else {
            nuoviNomi= new String[this.nomi.length-1];
            for (String name : nomi) {
                if (!(name.equals(nome))) {
                    nuoviNomi[c++] = name;
                }
            }
        }

        this.nomi=nuoviNomi;


    }
}
