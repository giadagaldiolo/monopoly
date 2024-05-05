package monopoly.componentigioco.casella;

import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;

public class PrintCasellaProprieta {


    private String printRighetta(){
        StringBuilder riga=new StringBuilder();
        riga.append("|");
        return riga.toString();
    }
    public String printRigaTre(Giocatore proprietario, String infoEdificiPrezzi, int pedaggio,StringBuilder dettagli){
        StringBuilder terzaRiga = new StringBuilder();
        terzaRiga.append(printRighetta());
        String miniSpazio="";
        int nSpazi=1;
        if (proprietario!=null) {
            terzaRiga.append(infoEdificiPrezzi);
            miniSpazio="\u2009";
            nSpazi=2;



        } else {
            terzaRiga.append("Paga ").append(Math.abs(pedaggio)).append("CHF alla banca");
        }

        dettagli.append(terzaRiga).append(CostantiCaselle.SPAZIO.repeat(((Costanti.LARGHEZZA_CASELLA - nSpazi) - terzaRiga.length()))).append(miniSpazio);
        dettagli.append(printRighetta()).append(CostantiCaselle.SPAZIO);
        return dettagli.toString();

    }

    public String printRigaQuattro(Giocatore proprietario,String infoEdificiPrezzi,String edifici,StringBuilder dettagli,int nEdifici){
        StringBuilder quartaRiga = new StringBuilder();
        quartaRiga.append(printRighetta());
        int nSpazi=1;
        int miniSpazio=1;
        if (proprietario!=null) { // per 3 emoji 2 spazi e 1 minispazio // pwr 1 2 spazi e 2 mispazio // per 2 2 spazi 1 minispazio // per 4 2 mini 0
                quartaRiga.append(edifici);
                nSpazi=2;
                miniSpazio=calcoloMiniSpazi(nEdifici);


        }else{
                quartaRiga.append(infoEdificiPrezzi);
                nSpazi=2;
            }
        dettagli.append(quartaRiga).append(" ".repeat(((Costanti.LARGHEZZA_CASELLA-nSpazi ) - quartaRiga.length()))).append("\u2009".repeat(miniSpazio)); //spazio sottile
        dettagli.append(printRighetta()).append(CostantiCaselle.SPAZIO);
        return dettagli.toString();
    }

    private int calcoloMiniSpazi(int edifici){
        int miniSpazi=2;
        int counter=0;
        for (int i=0;i<=edifici;i++){
            if (counter==2){
                miniSpazi--;
                counter=0;

            }
            counter++;

        }
        return miniSpazi;


    }



}
