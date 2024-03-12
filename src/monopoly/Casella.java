package monopoly;

import monopoly.utilita.Costanti;

import java.util.Random;
import monopoly.utilita.Colori;

public class Casella extends Coordinate {
    private String nome;
    private int pedaggio;

    private int nGiocatoriPresenti = 0;
    private String[] giocatoriPresenti = new String[Costanti.NUMERO_GIOCATORI]; // poi aggiustiamo la costante


    private final String colore;


    public Casella(String nome, int y, int x){ // assi
        super(y,x);
        svuotaCasella();
        this.nome = checkForNullNome(nome) ? "Nome sconosciuto" : nome;
        Random random = new Random();
        this.pedaggio = random.nextInt(Costanti.IMPORTO_PEDAGGIO_MIN,Costanti.IMPORTO_PEDAGGIO_MAX+1);
        if (this.nome.equals("Via")) this.pedaggio=Costanti.IMPORTO_DEL_VIA;
        this.colore= Colori.sceltaColore(true);

    }

    private boolean checkForNullNome(String nome){
        return nome == null || nome.isBlank();

    }

    private void svuotaCasella(){
        for (int i = 0; i < giocatoriPresenti.length; i++) {
            this.giocatoriPresenti[i]=" ";
        }

    }

    public String getCharGiocatore(final int i) {
        return giocatoriPresenti[i];
    }

    public void aggiungiCarattere(String ch, int giocatore) {
        if (ch.isBlank()){
            nGiocatoriPresenti--;
        }else{
            nGiocatoriPresenti++;
        }
        giocatoriPresenti[giocatore] = ch;
    }

    public int getPedaggio() {
        return pedaggio;
    }


    public String casellaString(int d){
        return this.colore +
                dettagliCasella(d) +
                Costanti.ANSI_RESET;
    }

    public static boolean checkForNull(Casella casella){
        return casella==null;
    }

    private String dettagliCasella(int d) {
        StringBuilder dettagli=new StringBuilder();
        String spazio = " ";
        String trattino = "-";
        String righette=trattino.repeat((Costanti.LARGHEZZA_CASELLA));
        dettagli.append(spazio);

        boolean PrimaUltimaRiga=d>0 && d<Costanti.RIGHE_CASELLA-1;
        if (PrimaUltimaRiga) dettagli.append("|");


        switch (d) {
            case 0: case 6:
                dettagli.append(righette);
                dettagli.append(spazio.repeat(1));
                break;
            case 1:
                String primaRiga = this.nome; // Per sapere quanti spazi aggiungere
                dettagli.append(primaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - primaRiga.length())));
                break;
            case 2:
                String secondaRiga;
                if (this.nome.equals("Via")) {
                    secondaRiga = "Ritira " + this.pedaggio;
                } else {
                    secondaRiga = "Paga " + this.pedaggio;
                }

                dettagli.append(secondaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - secondaRiga.length())));
                break;
            case 3: case 4: // per adesso non si deve stampare niente
                dettagli.append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2)));
                break;
            case 5:
                StringBuilder quintaRiga = new StringBuilder();
                int spaziDaFare = Costanti.LARGHEZZA_CASELLA-(Costanti.LARGHEZZA_CASELLA-(2*this.nGiocatoriPresenti));

                  // 2 sono i | |
                for (int i = 0; i < Costanti.NUMERO_GIOCATORI; i++) {
                    String giocatore=getCharGiocatore(i);

                    if (!(giocatore.isBlank())) quintaRiga.append(giocatore).append(Costanti.COLORE_SFONDO).append(" ");



                }

                dettagli.append(quintaRiga).append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2) - spaziDaFare));
                dettagli.append(this.colore);
                break;

        }
        if (PrimaUltimaRiga) dettagli.append("|").append(spazio); // if in una sola riga // spazio per avere tutte le caselle separate come sopra


        return  dettagli.toString();
    }
    public String getNome(){
        return this.nome;
    }



}

