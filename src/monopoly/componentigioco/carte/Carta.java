package monopoly.componentigioco.carte;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Carta {

    private static List<Carta> imprevisti = new ArrayList<>();
    private static List<Carta> probabilita = new ArrayList<>();
    private String descrizione;
    private String azione;
    private String terzaInformazione;


    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setAzione(String azione) {
        this.azione = azione;
    }

    public void setTerzaInformazione(String terzaInformazione) {
        this.terzaInformazione = terzaInformazione;
    }

    private static List<Carta> creaImprevisti() {
        return LeggiFile.readFromFile(new File("Imprevisti.txt"));

    }

    private static List<Carta> creaProbabilita() {
        return LeggiFile.readFromFile(new File("Probabilita.txt"));
    }

    public static void creaCarte() {
        Carta.probabilita = creaProbabilita();
        Carta.imprevisti = creaImprevisti();
    }
}
