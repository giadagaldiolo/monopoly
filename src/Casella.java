public class Casella {
    private String nome="Pedaggio";
    private int pedaggio;
    private Giocatore[] giocatoripresenti;

    public Casella(String nome, int pedaggio, Giocatore[] giocatoripresenti) {
        this.nome = nome;
        this.pedaggio = pedaggio;
        this.giocatoripresenti = giocatoripresenti;
    }
}

