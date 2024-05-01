package monopoly.componentigioco;

import monopoly.utilita.Costanti;

import java.util.Random;

public class Dado {
    private int ultimoLancio;

    public Dado(int ultimoLancio) {
        this.ultimoLancio = ultimoLancio;
    }

    public int lancioDadi(){
        Random random = new Random();
        return this.ultimoLancio = random.nextInt(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX+1);
    }

    public boolean controllo (Dado dado){
        return (dado.ultimoLancio>0 && dado.ultimoLancio<7);
    }

    public int getUltimoLancio() {
        return ultimoLancio;
    }

    @Override
    public String toString(){
        return switch (this.ultimoLancio) {
            case 1 -> ("""
                    * * * * * *
                    *         *
                    *    ●    *
                    *         *
                    * * * * * *
                                            
                    E' uscito 1
                    """);
            case 2 -> ("""
                    * * * * * *
                    * ●       *
                    *         *
                    *       ● *
                    * * * * * *
                                            
                    E' uscito 2
                    """);
            case 3 -> ("""
                    * * * * * *
                    * ●       *
                    *    ●    *
                    *       ● *
                    * * * * * *
                                            
                    E' uscito 3
                    """);
            case 4 -> ("""
                    * * * * * *
                    * ●     ● *
                    *         *
                    * ●     ● *
                    * * * * * *
                                            
                    E' uscito 4
                    """);
            case 5 -> ("""
                    * * * * * *
                    * ●     ● *
                    *    ●    *
                    * ●     ● *
                    * * * * * *
                                            
                    E' uscito 5
                    """);
            case 6 -> ("""
                    * * * * * *
                    * ●     ● *
                    * ●     ● *
                    * ●     ● *
                    * * * * * *
                                            
                    E' uscito 6
                    """);
            default -> "";
        };
    }
}
