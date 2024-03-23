package monopoly.componentigioco.casella;

import monopoly.utilita.Costanti;

import java.util.Random;

public abstract class  NomiHelper {
    private static int ultimoColore=0;
    private static int ultimoNome=0;
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
        String[] nomeColore = new String[2];
        while (!controlloNomiRimasti(nomiCaselle)){
            prossimoColore();
        }
        NomiCaselle categoriaCasella =nomiCaselle[ultimoColore];
        nomeColore[0]= categoriaCasella.getNomi()[ultimoNome];
        categoriaCasella.removeName(nomeColore[0]);
        nomeColore[1]= categoriaCasella.getColore();

        return nomeColore;
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
