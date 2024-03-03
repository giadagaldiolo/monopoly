import java.util.Random;

public class Casella {
    private String nome="Pedaggio"; //la casella via si chiama via
    private int pedaggio;
    private String[] giocatoripresenti = {" ", " "}; // poi aggiustiamo la costante
    private int cntGiocatori = Costanti.NUMERO_GIOCATORI;
    private final Coordinate coordinate;


    public Casella(String nome,int y, int x) {
        this.nome = nome;
        Random random = new Random();
        this.pedaggio = random.nextInt(Costanti.IMPORTO_PEDAGGIO_MIN,Costanti.IMPORTO_PEDAGGIO_MAX+1);
        this.coordinate = new Coordinate(y,x);


    }

    public String getNome() {
        return nome;
    }
    public int getPedaggio() {
        return pedaggio;
    }
    public int getNumGiocatori() {
        return cntGiocatori;
    }
    public String getCharGiocatore(final int i) {
        return giocatoripresenti[i];
    }

    public void aggiungiCarattere(String ch, int giocatore) {
        giocatoripresenti[giocatore] = ch;
    }

    public static void printTrattiniCasella(int i){
        String spazio = " ";
        String trattino = "-";
        if (i == 0 || i == 1 || i == Costanti.RIGHE -1) {
            System.out.print(trattino.repeat((Costanti.LARGHEZZA_CASELLA * Costanti.CASELLE_PER_RIGA)));
        } else {
            System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
            System.out.print(spazio.repeat((Costanti.LARGHEZZA_CASELLA * (Costanti.CASELLE_PER_RIGA-2))));
            System.out.print(trattino.repeat(Costanti.LARGHEZZA_CASELLA));
        }
        System.out.println();

    }

    public void mostra(int d){

        System.out.print("|");
        stampaDettagliCasella(d);
        System.out.print("|");


    }

    public static boolean checkForNull(Casella casella){
        return casella==null;
    }

    private void stampaDettagliCasella(int d) {
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
                    secondaRiga = "Paga " + this.pedaggio;
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
                int numeroGiocatori=getNumGiocatori();
                int spaziDaFare =  numeroGiocatori* numeroGiocatori;


                for (int i = 0; i < numeroGiocatori; i++) {
                    quintaRiga.append(getCharGiocatore(i)).append(" ");
                }
                System.out.print(quintaRiga + spazio.repeat((Costanti.LARGHEZZA_CASELLA -2)-spaziDaFare));
                break;

        }
    }



}

