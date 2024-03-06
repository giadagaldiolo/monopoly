import java.util.Random;

public class Dado {
    private int ultimoLancio;

    public int lancioDadi(){
        Random random = new Random();
        return this.ultimoLancio = random.nextInt(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX+1);
    }



    public String toString(){

        String stringa="";
        switch (this.ultimoLancio){
            case 1:
                stringa=("""
                        * * * * * *
                        *         *
                        *    ●    *
                        *         *
                        * * * * * *
                        
                        E' uscito 1
                        """);
                break;
            case 2:
                stringa=("""
                        * * * * * *
                        * ●       *
                        *         *
                        *       ● *
                        * * * * * *
                        
                        E' uscito 2
                        """);
                break;
            case 3:
                stringa=("""
                        * * * * * *
                        * ●       *
                        *    ●    *
                        *       ● *
                        * * * * * *
                        
                        E' uscito 3
                        """);
                break;
            case 4:
                stringa=("""
                        * * * * * *
                        * ●     ● *
                        *         *
                        * ●     ● *
                        * * * * * *
                        
                        E' uscito 4
                        """);
                break;
        }
        return stringa;
    }
}
