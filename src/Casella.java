public class Casella {
    private String nome="Pedaggio"; //la casella via si chiama via
    private int pedaggio;
    private Giocatore[] giocatoripresenti;
    private int cntGiocatori;

    public Casella(String nome, int pedaggio) {
        this.nome = nome;
        this.pedaggio = pedaggio;
//        this.giocatoripresenti = giocatoripresenti;
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
    public char getGiocatore(final int i) {
        return giocatoripresenti[i].getSimboloGiocatore();
    }
}

