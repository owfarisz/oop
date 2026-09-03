/**
 * Milkshake.java
 */
public class Milkshake extends MenuItem {
    public enum Ukuran { SMALL, MEDIUM, LARGE }

    private String jenis;
    private boolean iceCreamTopping;
    private Ukuran ukuran;

    /**
     * @param volumeMl        volume minuman (ml)
     * @param jenis           jenis milkshake (null/kosong => "Original")
     * @param iceCreamTopping topping es krim
     * @param ukuran          SMALL/MEDIUM/LARGE
     */
    public Milkshake(int volumeMl, String jenis, boolean iceCreamTopping, Ukuran ukuran) {
        super("Milkshake", volumeMl, Unit.ML, Kategori.MINUMAN);

        // bersihkan & default jenis
        String j = (jenis == null) ? "" : jenis.trim();
        if (j.isEmpty()) j = "Original";

        this.jenis = j;
        this.iceCreamTopping = iceCreamTopping;
        this.ukuran = ukuran;
    }

    // Getters/Setters
    public String getJenis() { return this.jenis; }

    public void setJenis(String jenis) {
        String j = (jenis == null) ? "" : jenis.trim();
        if (j.isEmpty()) j = "Original";
        this.jenis = j;
    }

    public boolean hasIceCreamTopping() { return this.iceCreamTopping; }

    public void setIceCreamTopping(boolean iceCreamTopping) {
        this.iceCreamTopping = iceCreamTopping;
    }

    public Ukuran getUkuran() { return this.ukuran; }

    public void setUkuran(Ukuran ukuran) { this.ukuran = ukuran; }

    /**
     * Harga dasar:
     * SMALL=10000, MEDIUM=13000, LARGE=15000
     * +5000 jika iceCreamTopping = true
     */
    @Override
    public int basePrice() {
        int base = 0;
        if (ukuran == Ukuran.SMALL) base = 10000;
        else if (ukuran == Ukuran.MEDIUM) base = 13000;
        else if (ukuran == Ukuran.LARGE) base = 15000;

        if (iceCreamTopping) base += 5000;

        return Math.max(0, base);
    }

    /**
     * Contoh:
     * - "Milkshake Strawberry [MEDIUM] 250ml"
     * - "Milkshake Strawberry Float [MEDIUM] 250ml"
     */
    @Override
    public String label() {
        String name = "Milkshake " + this.jenis + (iceCreamTopping ? " Float" : "");
        // unit milkshake pasti ml
        return name + " [" + this.ukuran + "] " + getQuantity() + "ml";
    }
}
