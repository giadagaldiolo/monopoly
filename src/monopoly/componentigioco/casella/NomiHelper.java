package monopoly.componentigioco.casella;

import java.util.Random;

public abstract class  NomiHelper {
    private static int ultimoColore=0;

    private static NomiCaselle [] nomiCaselle = NomiCaselle.values();

    private static void mischiaColori(){
        for (int i = 0; i < nomiCaselle.length; i++) {
            Random random = new Random();
            NomiCaselle tmp;

            int numeroRandom= random.nextInt(nomiCaselle.length);
            tmp =nomiCaselle[numeroRandom];
            nomiCaselle[numeroRandom]=nomiCaselle[i];
            nomiCaselle[i]=tmp;

        }
    }



    public static  String[] sceltaNomeColore(){
        mischiaColori();
        while (!controlloNomiRimasti(nomiCaselle)){
            prossimoColore();
        }
        return sceltaRandom();
    }


    private static String[] sceltaRandom(){
        String[] nomeColore = new String[2];
        NomiCaselle categoriaCasella =nomiCaselle[ultimoColore];
        String[] nomi =categoriaCasella.getNomi();

        nomeColore[0]= nomi[numeroRandom(nomi.length)];
        categoriaCasella.removeName(nomeColore[0]);
        nomeColore[1]= categoriaCasella.getColore();
        return nomeColore;

    }
    private static int numeroRandom(int limite){
        Random random =new Random();
        return random.nextInt(limite);
    }

    private static boolean controlloNomiRimasti(NomiCaselle[] nomiCaselle){
        if (isNomiCasella(nomiCaselle)){

            return (nomiCaselle[ultimoColore].getNomi()!=null);
        }

        return false;
    }
    private static void prossimoColore(){
        if (ultimoColore+1<nomiCaselle.length){
        ultimoColore++;
        } else {
            ultimoColore=0;


        }

    }

    private static boolean isNomiCasella(NomiCaselle[] nomiCaselle){
        return  nomiCaselle!=null;
    }
}
