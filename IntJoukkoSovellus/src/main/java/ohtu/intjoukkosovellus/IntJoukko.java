package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        ljono = new int[kapasiteetti < 0 ? KAPASITEETTI : kapasiteetti];
        this.kasvatuskoko = this.kasvatuskoko < 0 ? OLETUSKASVATUS : kasvatuskoko;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        ljono[alkioidenLkm++] = luku;
        if (alkioidenLkm == ljono.length) {
            grow();
        }
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (kuuluu(luku)) {
            for (int i = 0; i < alkioidenLkm; i++) {
                if (luku == ljono[i]) {
                    return scoot(i);
                }
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            sb.append(ljono[i]).append(", ");
        }
        return alkioidenLkm == 0 ?
                sb.append("}").toString():
                sb.append(ljono[alkioidenLkm - 1]).append("}").toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i : a.toIntArray()) {
            x.lisaa(i);
        }
        for (int i : b.toIntArray()) {
            x.lisaa(i);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i : a.toIntArray()) {
            if (b.kuuluu(i)) {
                y.lisaa(i);
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i : a.toIntArray()) {
            if (!b.kuuluu(i)) {
                z.lisaa(i);
            }
        }
        return z;
    }

    private void grow() {
        int[] newTable = new int[ljono.length + kasvatuskoko];
        kopioiTaulukko(ljono, newTable);
        ljono = newTable;
    }

    private boolean scoot(int i) {
        for (int j = i; j < alkioidenLkm; j++) {
            ljono[j] = j + 1 < alkioidenLkm ? ljono[j + 1] : 0;
        }
        alkioidenLkm--;
        return true;
    }

}
