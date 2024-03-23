package monopoly.componentigioco.casella;

public abstract class  NomiHelper {
    private static int ultimoColore=0;
    private static int ultimoNome=0;

    public static   String sceltaNome(){
        NomiCaselle [] nomiCaselle= NomiCaselle.values();
        String nome;
        if (!controlloNomiRimasti(nomiCaselle)){
            prossimoColore();
        }

        nome= nomiCaselle[ultimoColore].getNomi()[ultimoNome];
        ultimoNome++;
        return nome;
    }

    private static boolean controlloNomiRimasti(NomiCaselle[] nomiCaselle){
        if (isNomiCasella(nomiCaselle)){
            return (nomiCaselle[ultimoColore].getNomi().length>ultimoNome);
        }

        return false;
    }
    private static void prossimoColore(){
        ultimoColore++;
        ultimoNome=0;
    }

    private static boolean isNomiCasella(NomiCaselle[] nomiCaselle){
        return  nomiCaselle!=null;
    }
}
