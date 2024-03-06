import java.util.Random;

public class Dado {
    private int ultimoLancio;

    public int lancioDadi(){
        Random random = new Random();
        return this.ultimoLancio = random.nextInt(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX+1);
    }



    public String toString(){

        String stringa = switch (this.ultimoLancio) {
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
            default -> "";
        };
        return stringa;
    }
}
