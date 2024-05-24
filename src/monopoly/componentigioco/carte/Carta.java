package monopoly.componentigioco.carte;

import java.io.File;
import java.util.LinkedList;

public abstract class Carta {

    private String descrizione;
    private static String percorsoFile="src/monopoly/componentigioco/carte/".replace("/",File.separator);


    public Carta(String descrizione) {
        this.descrizione=descrizione;

    }


    public static LinkedList<Carta> creaImprevisti() {
        return InformazioniCarta.readFromFile(new File(percorsoFile+"Imprevisti.txt"));

    }

    public static LinkedList<Carta> creaProbabilita() {
        return InformazioniCarta.readFromFile(new File(percorsoFile+"Probabilita.txt"));
    }

    @Override
    public String toString() {
        return "Carta{" +
                "descrizione='" + descrizione + '\'' +
                '}';
    }
}
