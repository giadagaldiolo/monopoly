package monopoly.componentigioco.carte;

import java.io.File;
import java.util.LinkedList;

public abstract class Carta {

    private static LinkedList<Carta> imprevisti = new LinkedList<>();
    private static LinkedList<Carta> probabilita = new LinkedList<>();
    private String descrizione;
    private static String percorsoFile="src/monopoly/componentigioco/carte/".replace("/",File.separator);


    public Carta(String descrizione) {
        this.descrizione=descrizione;

    }


    private static LinkedList<Carta> creaImprevisti() {
        return InformazioniCarta.readFromFile(new File(percorsoFile+"Imprevisti.txt"));

    }

    private static LinkedList<Carta> creaProbabilita() {
        return InformazioniCarta.readFromFile(new File(percorsoFile+"Probabilita.txt"));
    }

    public static void creaCarte() {
        Carta.probabilita = creaProbabilita();
        Carta.imprevisti = creaImprevisti();
    }
}
