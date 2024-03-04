import java.util.Random;

public class Dado {
    private int max=4;
    private int min=1;
    public Dado(int min,int max){
        this.max=max+1;
        this.min=min;

    }

    public int lancioDadi(){
        Random random= new Random();
        return random.nextInt(min,max);
    }

    public void stampaDado(int mossa){
        switch (mossa){
            case 1:
                System.out.println("""
                        * * * * * *
                        *         *
                        *    0    *
                        *         *
                        * * * * * *
                        
                        E' uscito 1
                        """);
                break;
            case 2:
                System.out.println("""
                        * * * * * *
                        * 0       *
                        *         *
                        *       0 *
                        * * * * * *
                        
                        E' uscito 2
                        """);
                break;
            case 3:
                System.out.println("""
                        * * * * * *
                        * 0       *
                        *    0    *
                        *       0 *
                        * * * * * *
                        
                        E' uscito 3
                        """);
                break;
            case 4:
                System.out.println("""
                        * * * * * *
                        * 0     0 *
                        *         *
                        * 0     0 *
                        * * * * * *
                        
                        E' uscito 4
                        """);
                break;
        }
    }
}
