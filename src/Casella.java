public class Casella {
    private String nome="Pedaggio"; //la casella via si chiama via
    private int pedaggio;
    private char[] giocatoripresenti = {' ', ' '}; // poi aggiustiamo la costante
    private int cntGiocatori =2;
    private final int ID;

    public Casella(String nome, int pedaggio, int id) {
        this.nome = nome;
        this.pedaggio = pedaggio;
        this.ID = id;
        this.giocatoripresenti = giocatoripresenti;
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
    public char getCharGiocatore(final int i) {
        return giocatoripresenti[i];
    }


    public void aggiungiCarattere(char ch, int giocatore) {
        giocatoripresenti[giocatore] = ch;
    }

    public char[] getArrayCaratteri() {
        return giocatoripresenti;
    }
}

