public class Giocatore {
    private String nome;
    private char simbolo;
    private int soldi;
    private boolean turno;
    private int casellaCorrente=0;

    public Giocatore(String nome, char simbolo, int soldi) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.soldi = soldi;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public int getSoldi() {
        return soldi;
    }

    public String getNome() {
        return nome;
    }

    public void setTurnoTrue() {
        this.turno = true;
    }

    public void setTurnoFalse() {
        this.turno = false;
    }

    public boolean isTurno() {
        return turno;
    }

    private void cambioCasella(int dado){
        this.casellaCorrente+=dado;
    }
}
