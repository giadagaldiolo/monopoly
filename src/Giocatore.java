public class Giocatore {
    private String nome;
    private char simbolo;
    private int soldi;
    private boolean turno;
    private int yMax=Costanti.RIGHE-1;
    private int xMax= Costanti.CASELLE_PER_RIGA-1;
    private Cordinate cordinate= new Cordinate(yMax,xMax);

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

    public int [] cordinate(){
        int cordinate[]= {this.cordinate.getY(),this.cordinate.getX()};
        return cordinate;
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
    public void cambioCasella(int dado){
        if (dado==0){
            return;
        }else {
            cambioCordinate(dado);
        }
    }

    private void cambioCordinate(int dado){
        int nuovaCordinataX=this.cordinate.getX();
        int nuovaCordinataY= this.cordinate.getY();


        if (nuovaCordinataY==this.yMax){

            if (nuovaCordinataX==0){
                nuovaCordinataY-=1;
                this.cordinate.setY(nuovaCordinataY);

            }else{
                nuovaCordinataX-=1;
                this.cordinate.setX(nuovaCordinataX);

            }
        }
        else if (nuovaCordinataY==0){
            if (nuovaCordinataX==this.xMax){
                nuovaCordinataY+=1;
                this.cordinate.setY(nuovaCordinataY);

            }else{
                nuovaCordinataX+=1;
                this.cordinate.setX(nuovaCordinataX);

            }

        }
        else {
            if (nuovaCordinataX==0){
                nuovaCordinataY-=1;
                this.cordinate.setY(nuovaCordinataY);

            }else {
                nuovaCordinataY+=1;
                this.cordinate.setY(nuovaCordinataY);

            }
        }

        cambioCasella(dado-1);


    }





}
