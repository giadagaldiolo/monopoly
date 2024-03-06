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

    public static void printTrattiniCasella(int i){
        String spazio = " ";
        String trattino = "-";
        System.out.print(coloreTrattini);

        if (i == 0 || i == 1 || i == Costanti.RIGHE -1) {
            System.out.print(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
        } else {
            System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
            System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA * (Costanti.CASELLE_PER_RIGA-2))));
            System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
        }
        System.out.println(Costanti.ANSI_RESET);


    }

    public  static void printUltimaRiga(){

        String trattino = "-";
        System.out.print(coloreTrattini);
        System.out.println(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
        System.out.print(Costanti.ANSI_RESET);

    }

    public void mostra(int d){
        System.out.print(this.colore);
        stampaDettagliCasella(d);
        System.out.print(Costanti.ANSI_RESET);
    }

    public static boolean checkForNull(Casella casella){
        return casella==null;
    }

    private void stampaDettagliCasella(int d) {
        System.out.print("|");

        String spazio = " ";
        switch (d) {
            case 0:
                String primaRiga = this.nome; // Per sapere quanti spazi aggiungere
                System.out.print(primaRiga + spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - primaRiga.length()))); //Tolgo 2 che sono i caratteri ||
                break;
            case 1:
                String secondaRiga = "";
                if (this.nome.equals("Via")) {
                    secondaRiga = "Ritira " + Costanti.IMPORTO_DEL_VIA;
                } else {
                    secondaRiga = "Paga " + Math.abs(this.pedaggio);
                }
                System.out.print(secondaRiga + spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - secondaRiga.length())));
                break;
            case 2: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2)));
                break;
            case 3: // per adesso non si deve stampare niente
                System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2)));
                break;
            case 4:
                StringBuilder quintaRiga = new StringBuilder();
                int numeroGiocatori=this.giocatoriMassimi;
                int spaziDaFare = Costanti.LARGHEZZA_CASELLA-(Costanti.LARGHEZZA_CASELLA-(2*numeroGiocatori));  // 2 sono i | |

                for (int i = 0; i < numeroGiocatori; i++) {
                    quintaRiga.append(getCharGiocatore(i)).append(" ");
                }

                System.out.print(quintaRiga + spazio.repeat((Costanti.LARGHEZZA_CASELLA -2)-spaziDaFare));
                System.out.print(this.colore); // ripeto il colore perche si resetta con i simboli del giocatore

                break;

        }
        System.out.print("|");
    }



}

