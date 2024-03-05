import java.util.Random;

public class Dado {

    public int lancioDadi(){
        Random random = new Random();
        return random.nextInt(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX+1);
    }

    public void stampaDado(int mossa){
        switch (mossa){
            case 1:
                System.out.println("""
                        * * * * * *
                        *         *
                        *    ●    *
                        *         *
                        * * * * * *
                        
                        E' uscito 1
                        """);
                break;
            case 2:
                System.out.println("""
                        * * * * * *
                        * ●       *
                        *         *
                        *       ● *
                        * * * * * *
                        
                        E' uscito 2
                        """);
                break;
            case 3:
                System.out.println("""
                        * * * * * *
                        * ●       *
                        *    ●    *
                        *       ● *
                        * * * * * *
                        
                        E' uscito 3
                        """);
                break;
            case 4:
                System.out.println("""
                        * * * * * *
                        * ●     ● *
                        *         *
                        * ●     ● *
                        * * * * * *
                        
                        E' uscito 4
                        """);
                break;
        }
    }
}
