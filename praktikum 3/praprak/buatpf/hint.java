/**
 * HintCheatSheet.java
 *
 * KUMPULAN CONTOH HINT:
 * 1) Bersihkan String + Null-safe + default (ternary)
 * 2) Ternary operation dasar (validasi quantity, simbol unit)
 * 3) Math.max / Math.min / Math.round + urutan diskon -> pajak
 * 4) Casting: (int) vs Math.round
 * 5) ArrayList: add/remove/clear, kembalikan internal vs salinan
 * 6) StringBuilder untuk rakit label panjang
 * 7) Enum dasar + name() + switch
 * 8) Overloading method (nama sama, parameter beda)
 * 9) Abstract + Override (basePrice() di subclass)
 * 10) Clamp score 0..100 (contoh untuk OS compatibility)
 *
 * Semua contoh di bawah bisa dipakai ulang ke tugasmu (KantinKampus, Zooooo, Cashier, OS).
 */
import java.util.ArrayList;

public class HintCheatSheet {

    // ========================= 1) BERSIHKAN STRING + TERNARY =========================
    /**
     * APA: Membersihkan input string (null-safe, trim spasi), dengan fallback default.
     * KENAPA: Agar data rapi, hindari NullPointerException.
     * UNTUK APA: Dipakai saat set nama menu/jenis rasa, dsb.
     */
    static String cleanOrDefault(String raw, String fallback) {
        String tmp = (raw == null) ? "" : raw.trim(); // ternary: null -> "", else trim
        return tmp.isEmpty() ? fallback : tmp;        // kalau kosong -> fallback
    }

    // ========================= 2) TERNARY DASAR (VALIDASI, SYMBOL) ===================
    enum Unit { ML, GRAM }

    /**
     * APA: Validasi quantity.
     * KENAPA: Sesuai aturan soal, quantity negatif -> 100 (default).
     * UNTUK APA: Menjaga data agar selalu aman dipakai.
     */
    static int normalizeQuantity(int q) {
        return (q < 0) ? 100 : q; // ternary
    }

    /**
     * APA: Mapping enum Unit ke simbol string.
     * KENAPA: Hindari salah ketik "ml"/"g".
     * UNTUK APA: Membuat label menu yang konsisten.
     */
    static String unitSymbol(Unit u) {
        return (u == Unit.ML) ? "ml" : "g"; // ternary
    }

    // ========================= 3) MATH.ROUND / MAX / MIN + DISKON -> PAJAK ===========
    /**
     * APA: Hitung price final sesuai urutan soal:
     *   1) base = max(0, basePrice)
     *   2) afterPromo = round(base * (100 - promoPercent) / 100.0)
     *   3) jika happyHour: afterPromo = round(afterPromo * 0.8)
     *   4) tax = round(base * taxRate)   // pajak dari harga dasar
     *   5) final = afterPromo + tax; min 0
     * KENAPA: Urutan harus tepat sesuai ketentuan (sering bikin nilai salah).
     * UNTUK APA: Dipakai di MenuItem.price().
     */
    static int priceWithPromoHappyTax(int basePrice, int promoPercent, boolean happyHour, double taxRate) {
        int base = Math.max(0, basePrice); // jaga base tidak negatif

        int afterPromo = (int) Math.round(base * (100 - promoPercent) / 100.0);
        if (happyHour) {
            afterPromo = (int) Math.round(afterPromo * 0.8);
        }

        int tax = (int) Math.round(base * taxRate);

        int finalPrice = afterPromo + tax;
        if (finalPrice < 0) finalPrice = 0;
        return finalPrice;
    }

    // ========================= 4) CASTING: (int) vs Math.round =======================
    /**
     * APA: Bedanya casting langsung (trunc ke bawah) vs pembulatan Math.round.
     * KENAPA: Hasilnya berbeda, penting untuk perhitungan harga.
     * UNTUK APA: Pilih sesuai kebutuhan (soal minta "dibulatkan" -> pakai Math.round).
     */
    static void demoCasting() {
        double a = 2.7, b = 2.3, c = 2.5;
        // Truncation (int) -> buang desimal
        System.out.println("(int)2.7 = " + (int) a); // 2
        System.out.println("(int)2.3 = " + (int) b); // 2
        // Math.round -> bulat terdekat (return long)
        System.out.println("round(2.7) = " + (int) Math.round(a)); // 3
        System.out.println("round(2.3) = " + (int) Math.round(b)); // 2
        System.out.println("round(2.5) = " + (int) Math.round(c)); // 3 (Java rounding .5 up)
    }

    // ========================= 5) ARRAYLIST: ADD / REMOVE / CLEAR ====================
    /**
     * APA: Contoh class kecil untuk manajemen topping.
     * KENAPA: Terbiasa dengan add(), remove(), clear(), get().
     * UNTUK APA: Mirip NasiGoreng.topping di tugas.
     */
    static class ToppingBox {
        private final ArrayList<String> toppings = new ArrayList<>();

        void add(String t) {
            String x = (t == null) ? "" : t.trim();
            if (!x.isEmpty()) toppings.add(x);
        }

        boolean removeOne(String t) {
            String x = (t == null) ? "" : t.trim();
            if (x.isEmpty()) return false;
            return toppings.remove(x); // hapus satu kemunculan
        }

        void clear() { toppings.clear(); }

        // Pilihan A: kembalikan list internal (perubahan dari luar terlihat langsung)
        ArrayList<String> getInternal() { return toppings; }

        // Pilihan B: kembalikan salinan list (lebih aman dari modifikasi luar)
        ArrayList<String> getCopy() { return new ArrayList<>(toppings); }
    }

    // ========================= 6) STRINGBUILDER UNTUK LABEL PANJANG ==================
    /**
     * APA: Rakit label panjang: "Nasi Goreng <t1> <t2> <Pedas/Tidak Pedas> 300g"
     * KENAPA: StringBuilder efisien untuk gabung-gabung string dalam loop.
     * UNTUK APA: Dipakai di NasiGoreng.label().
     */
    static String buildNasiGorengLabel(ArrayList<String> topping, boolean pedas, int gram) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nasi Goreng ");
        if (topping.isEmpty()) {
            sb.append("Original ");
        } else {
            for (String t : topping) {
                sb.append(t).append(" ");
            }
        }
        sb.append(pedas ? "Pedas " : "Tidak Pedas ");
        sb.append(gram).append("g");
        return sb.toString();
    }

    // ========================= 7) ENUM DASAR + NAME() + SWITCH ======================
    /**
     * APA: Enum bikin nilai terbatas dan aman dari typo.
     * KENAPA: Lebih kuat daripada String literal.
     * UNTUK APA: Kategori, Unit, Ukuran, Distro, Edition, dsb.
     */
    enum Kategori { MAKANAN, MINUMAN }
    static String enumInfo(Kategori k, Unit u) {
        // name() -> teks uppercase nama enum
        String info = k.name() + " - " + u.name();
        switch (u) {
            case ML:   info += " (liquid)"; break;
            case GRAM: info += " (solid)";  break;
        }
        return info;
    }

    // ========================= 8) OVERLOADING METHOD ================================
    /**
     * APA: Dua method nama sama, parameter beda -> overloading.
     * KENAPA: Memberi opsi pemanggilan sesuai kebutuhan.
     * UNTUK APA: label() dan label(showPrice) pada MenuItem.
     */
    static String label(String name, int qty, String unit) {
        return name + " " + qty + unit;
    }
    static String label(String name, int qty, String unit, boolean showPrice, int price) {
        return showPrice ? label(name, qty, unit) + " | Rp" + price
                         : label(name, qty, unit);
    }

    // ========================= 9) ABSTRACT + OVERRIDE ===============================
    /**
     * APA: basePrice() dibuat abstrak pada induk -> diisi di subclass.
     * KENAPA: Rumus dasar beda-beda per item.
     * UNTUK APA: Pola KantinKampus (MenuItem -> Milkshake/NasiGoreng).
     */
    static abstract class BaseItem {
        abstract int basePrice();
    }
    static class MilkshakeItem extends BaseItem {
        boolean topping;
        MilkshakeItem(boolean topping) { this.topping = topping; }
        @Override
        int basePrice() {
            int base = 13000;           // contoh ukuran MEDIUM
            if (topping) base += 5000;
            return Math.max(0, base);   // defensif
        }
    }

    // ========================= 10) CLAMP SCORE 0..100 (OS) ==========================
    /**
     * APA: Pastikan nilai tetap dalam rentang 0..100.
     * KENAPA: Agar skor tidak lewat batas.
     * UNTUK APA: Di OperatingSystem.clampScore().
     */
    static double clamp(double v) {
        if (v < 0.0) return 0.0;
        if (v > 100.0) return 100.0;
        return v;
    }
    static double compatibility(double base, double multiplier) {
        // score = base + multiplier * base
        return clamp(base + multiplier * base);
    }

    // ========================= MAIN: DEMO CEPAT SEMUA HINT ==========================
    public static void main(String[] args) {
        System.out.println("== 1) Clean String + Default ==");
        System.out.println(cleanOrDefault(null, "Original"));      // Original
        System.out.println(cleanOrDefault("  Strawberry  ", "X")); // Strawberry
        System.out.println(cleanOrDefault("   ", "Original"));     // Original
        System.out.println();

        System.out.println("== 2) Ternary Validasi + Unit Symbol ==");
        System.out.println(normalizeQuantity(-5));                 // 100
        System.out.println(normalizeQuantity(250));                // 250
        System.out.println(unitSymbol(Unit.ML));                   // ml
        System.out.println(unitSymbol(Unit.GRAM));                 // g
        System.out.println();

        System.out.println("== 3) Math Ops (Promo->Happy->Tax) ==");
        System.out.println(priceWithPromoHappyTax(15000, 20, true, 0.10));
        System.out.println(priceWithPromoHappyTax(-10, 50, false, 0.10));
        System.out.println();

        System.out.println("== 4) Casting vs Rounding ==");
        demoCasting();
        System.out.println();

        System.out.println("== 5) ArrayList add/remove/clear ==");
        ToppingBox box = new ToppingBox();
        box.add(" Telur ");
        box.add("Ayam");
        System.out.println(box.getInternal()); // [Telur, Ayam]
        box.removeOne(" Telur ");
        System.out.println(box.getCopy());     // [Ayam]
        box.clear();
        System.out.println(box.getInternal()); // []
        System.out.println();

        System.out.println("== 6) StringBuilder Label ==");
        ArrayList<String> t = new ArrayList<>();
        t.add("Ayam");
        t.add("Telur");
        System.out.println(buildNasiGorengLabel(t, false, 300));
        System.out.println(buildNasiGorengLabel(new ArrayList<String>(), true, 500));
        System.out.println();

        System.out.println("== 7) Enum name() + switch ==");
        System.out.println(enumInfo(Kategori.MAKANAN, Unit.GRAM));
        System.out.println(enumInfo(Kategori.MINUMAN, Unit.ML));
        System.out.println();

        System.out.println("== 8) Overloading label()");
        System.out.println(label("Milkshake Original", 250, "ml"));
        System.out.println(label("Milkshake Original", 250, "ml", true, 18000));
        System.out.println();

        System.out.println("== 9) Abstract + Override basePrice()");
        BaseItem a = new MilkshakeItem(false);
        BaseItem b = new MilkshakeItem(true);
        System.out.println(a.basePrice()); // 13000
        System.out.println(b.basePrice()); // 18000
        System.out.println();

        System.out.println("== 10) Clamp Score 0..100 (OS) ==");
        System.out.println(compatibility(80, +0.30)); // 104 -> 100
        System.out.println(compatibility(50, -1.50)); // -25 -> 0
        System.out.println(compatibility(70, +0.20)); // 84
    }
}
