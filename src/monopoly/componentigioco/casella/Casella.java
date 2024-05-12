package monopoly.componentigioco.casella;

import monopoly.Coordinate;

import monopoly.componentigioco.Banca;
import monopoly.componentigioco.Tabellone;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;

import java.util.Random;

public abstract class Casella implements CasellaInterface {

    private int pedaggio = 0;
    private String colore;
    private String nome;
    private Coordinate coordinate;
    private int nGiocatoriPresenti = 0;
    private String[] giocatoriPresenti = new String[Costanti.NUMERO_GIOCATORI]; // poi aggiustiamo la costante


    @Override
    public void setPedaggioDefault() {
        Random random = new Random();
        this.pedaggio = random.nextInt(Costanti.IMPORTO_PEDAGGIO_MIN,Costanti.IMPORTO_PEDAGGIO_MAX+1);
    }

    protected Casella(){ // assi
        svuotaCasella();
        setNomeColoreDefault();
        setPedaggioDefault();
    }

    protected void setCoordinate(Coordinate coordinate) {
        this.coordinate=coordinate;
    }

    private boolean checkForNullNome(String nome){
        return nome == null || nome.isBlank();

    }

    private void svuotaCasella(){
        for (int i = 0; i < giocatoriPresenti.length; i++) {
            this.giocatoriPresenti[i]=" ";
        }

    }

    private String getCharGiocatore(final int i) {
        return giocatoriPresenti[i];
    }

    public void aggiungiCarattere(String ch, int giocatore) {
        if (ch.isBlank()){
            nGiocatoriPresenti--;
        } else{
            nGiocatoriPresenti++;
        }
        giocatoriPresenti[giocatore] = ch;
    }


    public String casellaString(int d){
        return getColore() +
                dettagliCasella(d) +
                Costanti.ANSI_RESET;
    }

    public static boolean checkForNull(Casella casella){
        return casella==null;
    }

    public String dettagliCasella(int d) {
        StringBuilder dettagli=new StringBuilder();
        String spazio = " ";
        String trattino = "-";
        String righette=trattino.repeat((Costanti.LARGHEZZA_CASELLA));
        dettagli.append(spazio);

        boolean PrimaUltimaRiga=d>0 && d<Costanti.RIGHE_CASELLA-1;
        if (PrimaUltimaRiga) dettagli.append("|");


        switch (d) {
            case 0: case 6:
                dettagli.append(righette);
                dettagli.append(spazio.repeat(1));
                break;
            case 1:
                String primaRiga = this.nome; // Per sapere quanti spazi aggiungere
                int nSpazi=Costanti.LARGHEZZA_CASELLA-2- primaRiga.length();
                dettagli.append(primaRiga).append(spazio.repeat(nSpazi ));
                break;
            case 2:
                String secondaRiga = infoCasella();
                dettagli.append(secondaRiga).append(CostantiCaselle.SPAZIO.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - secondaRiga.length())));
                break;
            case 3, 4:
                StringBuilder terzaRiga = new StringBuilder();
                dettagli.append(terzaRiga).append(spazio.repeat(((Costanti.LARGHEZZA_CASELLA - 2) - terzaRiga.length())));
                break;
            case 5: // proviamo a dividere i giocatori in prigione
                StringBuilder quintaRiga = new StringBuilder();
                int spaziDaFare = Costanti.LARGHEZZA_CASELLA-(Costanti.LARGHEZZA_CASELLA-(2*this.nGiocatoriPresenti));

                  // 2 sono i | |
                for (int i = 0; i < Costanti.NUMERO_GIOCATORI; i++) {
                    String giocatore=getCharGiocatore(i);

                    if (!(giocatore.isBlank()))
                        quintaRiga.append(giocatore).append(Costanti.COLORE_SFONDO).append(" ");
                }
                dettagli.append(quintaRiga).append(spazio.repeat((Costanti.LARGHEZZA_CASELLA - 2) - spaziDaFare));
                dettagli.append(getColore());
                break;

        }
        if (PrimaUltimaRiga) dettagli.append("|").append(spazio); // if in una sola riga // spazio per avere tutte le caselle separate come sopra
        return  dettagli.toString();
    }

    public String getNome(){
        return this.nome;
    }
    public  int getPedaggio(){
        return this.pedaggio;
    }
    private String getColore(){
        return this.colore;
    }

    @Override
    public void setNomeColoreDefault(){
        String[] nomeColore = NomiHelper.sceltaNomeColore();
        this.nome=nomeColore[0];
        this.colore=nomeColore[1];
    }

    protected void setNomeColore(String nome , String colore){
        this.nome=nome;
        this.colore=colore;
    }
    @Override
    public String infoCasella() {
        StringBuilder info = new StringBuilder();

        info.append("Paga ").append(Math.abs(this.pedaggio));

        return info.toString();
    }

    private void pagamento(Giocatore giocatorePagante,int nGiocatore){
        giocatorePagante.pagamentoPedaggio(this,nGiocatore);
    }

    public void azioneCasella(Giocatore giocatoreCorrente,int nGiocatore){
       pagamento(giocatoreCorrente,nGiocatore);
    }





    public void setPedaggio(int pedaggio) {
        this.pedaggio = pedaggio;
    }


}