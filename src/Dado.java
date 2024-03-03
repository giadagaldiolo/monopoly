import java.util.Random;

public class Dado {
    private int max;
    private int min;
    public Dado(int min,int max){
        this.max=max+1;
        this.min=min;

    }

    public int lancioDadi(){
        Random random= new Random();
        return random.nextInt(min,max);
    }
}
