public class Banca {
    private static int importo = Costanti.IMPORTO_INIZIALE_BANCA;

    public Banca(int importo) {
        this.importo = importo;
    }

    public static void setImporto(final int importo) {
        if (importo >= Banca.importo)
            aggiungiSoldiImporto();
        Banca.importo += importo;
    }

    private static void aggiungiSoldiImporto() {
        Banca.importo += Costanti.IMPORTO_PER_BANCAROTTA;
    }
}
