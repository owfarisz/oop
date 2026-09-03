import java.util.ArrayList;

/**
 * NasiGoreng.java
 * Subclass dari MenuItem untuk makanan Nasi Goreng.
 */
public class NasiGoreng extends MenuItem {
    private ArrayList<String> topping;
    private boolean pedas;

    /**
     * @param porsiGram jumlah gram (negatif => akan diperlakukan 100 oleh parent)
     * @param pedas     true jika pedas
     */
    public NasiGoreng(int porsiGram, boolean pedas) {
        super("Nasi Goreng", porsiGram, Unit.GRAM, Kategori.MAKANAN);
        this.pedas = pedas;
        this.topping = new ArrayList<String>();
    }

    /** tambah topping (abaikan jika null/kosong setelah trim) */
    public void addTopping(String t) {
        if (t == null) return;
        String x = t.trim();
        if (!x.isEmpty()) topping.add(x);
    }

    /** hapus satu kemunculan topping */
    public boolean removeTopping(String t) {
        if (t == null) return false;
        String x = t.trim();
        if (x.isEmpty()) return false;
        return topping.remove(x);
    }

    /** kosongkan semua topping */
    public void clearTopping() {
        topping.clear();
    }

    /** kembalikan salinan daftar topping (supaya tidak bisa memodifikasi internal langsung) */
    public ArrayList<String> getTopping() {
        return new ArrayList<String>(topping);
    }

    public boolean isPedas() { return pedas; }
    public void setPedas(boolean pedas) { this.pedas = pedas; }

    /**
     * base = 15000
     * +3000 per topping
     * +2000 jika pedas
     */
    @Override
    public int basePrice() {
        int base = 15000;
        base += 3000 * topping.size();
        if (pedas) base += 2000;
        return Math.max(0, base);
    }

    /**
     * Format:
     * - tanpa topping: "Nasi Goreng Original Pedas|Tidak Pedas <qty>g"
     * - dengan topping: "Nasi Goreng <t1> <t2> ... Pedas|Tidak Pedas <qty>g"
     */
    @Override
    public String label() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nasi Goreng ");

        if (topping.isEmpty()) {
            sb.append("Original ");
        } else {
            for (int i = 0; i < topping.size(); i++) {
                sb.append(topping.get(i)).append(" ");
            }
        }

        sb.append(pedas ? "Pedas " : "Tidak Pedas ");
        sb.append(getQuantity()).append("g");
        return sb.toString();
    }
}
