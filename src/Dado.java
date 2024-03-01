import java.util.Random;

public class Dado {
    private Random random= new Random();

    public int lancioDadi(){
        return random.nextInt(Costanti.NUMERO_DADO_MIN,Costanti.NUMERO_DADO_MAX+1);
    }
}
