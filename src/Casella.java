import java.util.Random;

public class Casella extends  Coordinate{
    private String nome;
    private int pedaggio;

    private int giocatoriMassimi = Costanti.NUMERO_GIOCATORI;
    private String[] giocatoriPresenti = new String[giocatoriMassimi]; // poi aggiustiamo la costante
    private static final String coloreTrattini = Colori.sceltaColore(true);
    //private final Coordinate coordinate;
    private final String colore;


    public Casella(String nome, int y, int x){ // assi
        super(y,x);
        svuotaCasella();
        this.nome = checkForNullNome(nome) ? "Nome sconosciuto" : nome;
        Random random = new Random();
        this.pedaggio = random.nextInt(Costanti.IMPORTO_PEDAGGIO_MIN,Costanti.IMPORTO_PEDAGGIO_MAX+1);
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
        giocatoriPresenti[giocatore] = ch;
    }

    public int getPedaggio() {
        return pedaggio;
    }

    public static String trattiniCasella(int i){
        String spazio = " ";
        String trattino = "-";

        StringBuilder trattini=new StringBuilder(); // tolti tutti i sout e salvato tutto in una stringa
        trattini.append(coloreTrattini);


        if (i == 0 || i == 1 || i == Costanti.RIGHE -1) {
            trattini.append(trattino.repeat(Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA));

        } else {
            trattini.append(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
            trattini.append(spazio.repeat(Costanti.LARGHEZZA_CASELLA * (Costanti.CASELLE_PER_RIGA-2)));
            trattini.append(trattino.repeat(Costanti.LARGHEZZA_CASELLA));

        }
        trattini.append("\n"+Costanti.ANSI_RESET);

        return trattini.toString();


    }

    public static String ultimaRiga(){
        StringBuilder ultimaRiga=new StringBuilder();
        String trattino = "-";
        ultimaRiga.append(coloreTrattini);
        ultimaRiga.append(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
        ultimaRiga.append(Costanti.ANSI_RESET);
       return ultimaRiga.toString();

    }

    public String casellaString(int d){
        StringBuilder casella=new StringBuilder();
        casella.append(this.colore);
        casella.append(dettagliCasella(d));
        casella.append(Costanti.ANSI_RESET);
        return casella.toString();
    }

    public static boolean checkForNull(Casella casella){
        return casella==null;
    }

    private String dettagliCasella(int d) {
        StringBuilder dettagli=new StringBuilder();
        dettagli.append("|");
        String spazio = " ";
        switch (d) {
            case 0:
                String primaRiga = this.nome; // Per sapere quanti spazi aggiungere
                dettagli.append(primaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - primaRiga.length())));
                break;
            case 1:
                String secondaRiga = "";
                if (this.nome.equals("Via")) {
                    secondaRiga = "Ritira " + Costanti.IMPORTO_DEL_VIA;
                } else {
                    secondaRiga = "Paga " + Math.abs(this.pedaggio);
                }
                dettagli.append(secondaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - secondaRiga.length())));

                break;
            case 2: // per adesso non si deve stampare niente
                dettagli.append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2)));

                break;
            case 3: // per adesso non si deve stampare niente

                dettagli.append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2)));
                break;
            case 4:
                StringBuilder quintaRiga = new StringBuilder();
                int numeroGiocatori=this.giocatoriMassimi;
                int spaziDaFare = Costanti.LARGHEZZA_CASELLA-(Costanti.LARGHEZZA_CASELLA-(2*numeroGiocatori));  // 2 sono i | |

                for (int i = 0; i < numeroGiocatori; i++) {

                    quintaRiga.append(getCharGiocatore(i)).append(" ");
                }
                dettagli.append(quintaRiga).append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2) - spaziDaFare));
                dettagli.append(this.colore);
                break;

        }
        dettagli.append("|");

        return  dettagli.toString();
    }



}

