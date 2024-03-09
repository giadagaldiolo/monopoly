import java.util.Random;

public class Casella extends  Coordinate{
    private String nome;
    private int pedaggio;

    private int nGiocatoriPresenti = 0;
    private String[] giocatoriPresenti = new String[Costanti.NUMERO_GIOCATORI]; // poi aggiustiamo la costante
    private static final String coloreTrattini = Colori.sceltaColore(true);

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

        boolean PrimaUltimaRiga=d>0 && d<Costanti.RIGHE_CASELLA-1;
        if (PrimaUltimaRiga) dettagli.append("|");
        String spazio = " ";
        String trattino = "-";
        String righette=trattino.repeat((Costanti.LARGHEZZA_CASELLA));
        switch (d) {
            case 0: case 6:
                StringBuilder trattini=new StringBuilder(); // tolti tutti i sout e salvato tutto in una stringa
                dettagli.append(righette);
                dettagli.append(spazio.repeat(1));
                break;
            case 1:
                String primaRiga = this.nome; // Per sapere quanti spazi aggiungere
                dettagli.append(primaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - primaRiga.length())));
                break;
            case 2: // per adesso non si deve stampare niente
                String secondaRiga = "";
                if (this.nome.equals("Via")) {
                    secondaRiga = "Ritira " + Costanti.IMPORTO_DEL_VIA;
                } else {
                    secondaRiga = "Paga " + Math.abs(this.pedaggio);
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
                    if (giocatore.isBlank()) continue;
                    quintaRiga.append(giocatore).append(" ");


                }

                dettagli.append(quintaRiga).append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2) - spaziDaFare));
                dettagli.append(this.colore);
                break;

        }
        if (PrimaUltimaRiga) dettagli.append("|").append(spazio); // if in una sola riga // spazio per avere tutte le le caselle separate come sopra


        return  dettagli.toString();
    }



}

