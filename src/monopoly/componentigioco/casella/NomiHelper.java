package monopoly.componentigioco.casella;

import java.util.Random;

public abstract class  NomiHelper {
    private static final int caselleNotRandom=2;
    private static int ultimoColore=caselleNotRandom;

    private static NomiCaselle [] nomiCaselle = NomiCaselle.values();



    private static void mischiaColori(){

        for (int i = caselleNotRandom; i < nomiCaselle.length; i++) {
            Random random = new Random();
            NomiCaselle tmp;
            int numeroRandom= random.nextInt(caselleNotRandom,nomiCaselle.length);

            tmp =nomiCaselle[numeroRandom];
            nomiCaselle[numeroRandom]=nomiCaselle[i];
            nomiCaselle[i]=tmp;
        }

    }


    public static  String[] sceltaNomeColore(){
        mischiaColori();
        int c=0;
        while (!controlloNomiRimasti()){

            prossimoColore();
            c++;
            if (c>nomiCaselle.length) return casellaSconosciuta();
        }
        return sceltaRandom();
    }

    private static String[] casellaSconosciuta(){
        return  new String[]{"????", nomiCaselle[0].getColore()};

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

    private static boolean controlloNomiRimasti(){
            return (nomiCaselle[ultimoColore].getNomi()!=null);

    }
    private static void prossimoColore(){
        if (ultimoColore+1<nomiCaselle.length){

        ultimoColore++;
        } else {
            ultimoColore=caselleNotRandom;


        }

    }
}
