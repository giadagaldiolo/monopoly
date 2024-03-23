package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;


public enum NomiCaselle {
    MARRONE(new String[]{"Vicolo Corto", "Vicolo Stretto"},172),
    AZZURO(new String[]{"Bastioni Gran Sasso", "Viale Monterosa", "Viale Vesuvio"},87),
    ROSA(new String[]{"Via Accademia", "Corso Ateneo", "Piazza Università"},13),
    GRIGIO(new String[]{"Via Verdi", "Corso Raffaello", "Piazza Dante"},249),
    ROSSO(new String[]{"Via Marco Polo", "Corso Magellano", "Largo Colombo"},9),
    GIALLO(new String[]{"Viale Costantino", "Viale Traiano", "Piazza Giulio Cesare"},220),
    VERDE(new String[]{"Via Roma", "Corso Impero", "Largo Augusto"},155),
    BLU(new String[]{"Viale dei Giardini", "Parco della Vittoria"},21),
    NERO(new String[]{"Parcheggio","Stazione Sud", "Stazione Nord", "Stazione Est", "Stazione Ovest", "Società Acqua Potabile", "Società Elettrica","Tassa di Lusso","Tassa Patrimoniale","Via"},231);

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
                    nuoviNomi[c] = name;
                    c++;
                }
            }

        }

        this.nomi=nuoviNomi;


    }
}
