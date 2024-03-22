package monopoly.componentigioco.casella;


public enum TipoCasella {
     PARCHEGGIO(1), TASSA(2),VIA(1),STAZIONE(4),SOCIETA(0),PROPRIETA();
    //per adesso o in societa
    final int nCaselle;
    TipoCasella(int nCaselle){
        this.nCaselle=nCaselle;
        Casella.addCaselleRimaste(-1);

    }
    TipoCasella(){
        this.nCaselle=Casella.getCaselleRimaste();

    }
}


