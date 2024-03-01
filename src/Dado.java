import java.util.Random;

public class Dado {
    private final Random random= new Random();
    private int max;
    private int min;
    public Dado(int min,int max){
        this.max=max+1;
        this.min=min;

    }

    public int lancioDadi(){
        return random.nextInt(min,max);
    }
}
