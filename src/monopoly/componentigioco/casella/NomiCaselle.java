package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;


public enum NomiCaselle {
    TRENO(new String[]{"Stazione Nord","Stazione Sud","Stazione Ovest","Stazione Est"},233),
    SINGOLE (new String[]{"Parcheggio","VIA"},231),
    MARRONE(new String[]{"Vicolo Corto", "Vicolo Stretto"},172),
    AZZURO(new String[]{"Bastioni Gran Sasso", "Viale Monterosa", "Viale Vesuvio"},87),
    ROSA(new String[]{"Via Accademia", "Corso Ateneo", "Piazza Università"},13),
    GRIGIO(new String[]{"Via Verdi", "Corso Raffaello", "Piazza Dante"},244),
    ROSSO(new String[]{"Via Marco Polo", "Corso Magellano", "Largo Colombo"},9),
    GIALLO(new String[]{"Viale Costantino", "Viale Traiano", "Piazza Giulio Cesare"},220),
    VERDE(new String[]{"Via Roma", "Corso Impero", "Largo Augusto"},155),
    BLU(new String[]{"Viale dei Giardini", "Parco della Vittoria"},21),
    TASSE(new String[]{"Tassa di Lusso","Tassa Patrimoniale"},231),
    SOCIETA(new String[]{"Società Acqua Potabile", "Società Elettrica"},233);

    private String [] nomi;

    private final String colore;

    public String getColore(){
        return colore;
    }



    NomiCaselle(String [] nomi ,int colore ){
        this.nomi=nomi;
        this.colore= "\u001B[1;38;5;"+colore+"m"+Costanti.COLORE_SFONDO ; // bold;background/coloreScritta;? ; colore

    }

    public String[] getNomi() {
        return nomi;
    }

    public String getNome(int i){
        String nome=nomi[i];
        removeName(nome);

        return  nome;
    }


    private boolean isNomi(){
        return nomi!=null;
    }

    public void removeName(String nome){
        int nomiRimasti=this.nomi.length-1;
        String[] nuoviNomi;
        int c=0;
        if (nomiRimasti<=0){
            nuoviNomi=null;
        }else {
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
