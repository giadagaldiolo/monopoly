public class Banca {
    private static int importo = Costanti.IMPORTO_INIZIALE_BANCA;

    public Banca(int importo) {
        Banca.importo = isNull(importo) ? Costanti.IMPORTO_INIZIALE_BANCA : importo;
    }

    private boolean isNull(int importo) { return (importo <= 0); }

    public static void setImporto(final int importo) {
        if (importo >= Banca.importo && importo<0)
            aggiungiSoldiImporto();
        Banca.importo += importo;
    }
    public static int getImporto(){
        return importo;
    }

    private static void aggiungiSoldiImporto() {
        Banca.importo += Costanti.IMPORTO_PER_BANCAROTTA;
    }
}
