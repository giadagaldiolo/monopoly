package monopoly.componentigioco.casella;

import monopoly.componentigioco.Tabellone;
import monopoly.utilita.Costanti;

import java.util.Random;

/**
 * {@link #caselleNotRandom} numero di tipo di caselle con posizione fisse. <p>
 * {@link #ultimoColore} indice dell'ultimo colore preso in considerazione, utile per navigare negli elementi del array {@link #nomiCaselle} <p>
 * {@link #nomiCaselle} contiene gli elementi del Enum {@link NomiCaselle} <p>
 * <i>Questa classe serve da supporto alla classe {@link Casella} e al Enum {@link NomiCaselle} per la scelta dei nomi</i>
 */
public abstract class  NomiHelper {

    private static final int caselleNotRandom = 2; // dato che nel enum NomiCaselle non serve mischiare Treno e singole
    private static int ultimoColore=caselleNotRandom;

    private static NomiCaselle [] nomiCaselle = NomiCaselle.values(); // contiene il valori del enum NomiCaselle
    private static boolean fakeCaselle=false;

/**
 * Mischia l'array {@link #nomiCaselle} dove serve.<p>
 *
 * <i>Dove serve perchè limito il shuffle alle categorie mischiabili.</i>
 *
 */
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
    public static int nArrayUltimoColore(){
        NomiCaselle categoriaCasella =nomiCaselle[ultimoColore];
        return categoriaCasella.getPosizioneArrayCaselleGiocatore();

    }




    /**
     * Metodo utilizzato nel metodo {@link Casella#setNomeColoreDefault()} per trovare il colore e nome adatto. <p>
     * Inizia richiamando il metodo {@link #mischiaColori()}. <p>
     * Successivamente insieme al metodo {@link #controlloNomiRimasti()} si occuperà di prendere il primo colore/categoria con almeno un nome disponibile. <p>
     * Nel caso che il numero di caselle necessarie superi il numero di nomi saranno chiamate {@code ????}  : vedi {@link #casellaSconosciuta()}
       per far questo controllo utilizzo una variabile {@code c} che controlla se tutte le categorie del Enum {@link NomiCaselle} sono state prese in considerazione.<p>
     * Modifica l'attributo di classe {@link #ultimoColore} tramite il metodo {@link #prossimoColore()} <p>
     * @return String[] {@link #sceltaRandom()} Array contenente un Nome e un Colore <p>
     */

    protected static  String[] sceltaNomeColore(){
        mischiaColori();
        int c=0;
        while (!controlloNomiRimasti()){
            prossimoColore();
            c++;
            if (c>nomiCaselle.length) return casellaSconosciuta();
        }
        return sceltaRandom();
    }

    /**
     * Metodo per continuare a creare caselle {@link Proprieta} in assenza di nomi
     * @return String[] contenete il nome {@code ????}  e il colore corrispondente alla prima categoria del enum {@link NomiCaselle}.
     */
    private static String[] casellaSconosciuta(){
        fakeCaselle=true;
        return  new String[]{"????", nomiCaselle[0].getColore()};

    }
    static boolean getFakeCaselle(){
        return fakeCaselle;
    }

    /**
     * Questo metodo sceglie, dalla categoria con almeno un nome trovata da {@link #sceltaNomeColore()} ,il nome e colore della casella
     * salvandole in un array.<p>
     * Utilizza gli attributi di classe {@link #ultimoColore} e {@link #nomiCaselle}.<p>
     * Genera un numero Random con il metodo {@link #numeroRandom(int nomiDisponibili)} per poter scegliere il nome.<p>
     * il metodo inoltre chiama {@link NomiCaselle#removeName(String nomeTrovato)} che si occupa di eliminare dal enum il nome appena trovato per evitare doppioni. <p>
     * La rimozione funziona date le proprietà statiche del enum.
     * @return un array con il <i>nome(posizione 0) e colore (posizione 1)</i>.
     */
    private static String[] sceltaRandom(){
        String[] nomeColore = new String[2];
        NomiCaselle categoriaCasella =nomiCaselle[ultimoColore];
        String[] nomi =categoriaCasella.getNomi();

        nomeColore[0]= nomi[numeroRandom(nomi.length)];
        categoriaCasella.removeName(nomeColore[0]);
        nomeColore[1]= categoriaCasella.getColore();

        return nomeColore;

    }

    /**
     * Genera il un indice che corrisponderà al nome in {@link #sceltaRandom()}
     * @param limite ossia il numero di nomi disponibili in una determinata categoria/colore
     * @return int indice del nome scelto
     */
    private static int numeroRandom(int limite){
        Random random =new Random();
        return random.nextInt(limite);
    }

    /**
     * Controlla se una categoria contiene nomi disponibili
     * @return boolean risultato del controllo
     */
    private static boolean controlloNomiRimasti(){
            return (nomiCaselle[ultimoColore].getNomi()!=null);
    }

    /**
     * Utilizzato in {@link #sceltaNomeColore()}.<p>
     * Cambia l'indice del colore rappresentato dall'attributo di classe {@link #ultimoColore}.<p>
     * Se raggiunge il valore della lunghezza del array {@link #nomiCaselle} si resetta saltando le categorie che non sono mischiate.<p>
     * Altrimenti incrementa l'attributo.<p>
     * Infine le modifiche apportate saranno utilizzate principalmente in {@link #controlloNomiRimasti()}
     */
    private static void prossimoColore(){
        if (ultimoColore+1<nomiCaselle.length){
        ultimoColore++;
        } else {
            ultimoColore=caselleNotRandom;
        }

    }

    public static int[] calcoloCoordinate(Casella [][]caselle){
        int y,x;
        do{
            Random random= new Random();
            y= random.nextInt(Costanti.RIGHE);
            x= random.nextInt(Costanti.CASELLE_PER_RIGA);
        }while (Tabellone.controlloPosizione(y,x) || (caselle[y][x]!=null) );
        return new int[]{y,x};

    }
}
