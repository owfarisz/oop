/**
 * Pembayaran.java
 *
 * APA:
 *   Abstract class dasar untuk semua metode pembayaran.
 *
 * KENAPA:
 *   Semua metode pembayaran punya data umum (namaPelanggan, jumlah)
 *   dan perilaku umum (harus bisa hitung total), tapi rumusnya beda-beda.
 *   Jadi kita pakai abstract method hitungTotal() yang wajib dioverride di subclass.
 *
 * UNTUK APA:
 *   Menyediakan kerangka yang konsisten untuk COD, EWallet, dan TransferBank.
 *
 * TODO (opsional):
 *   - Validasi jumlah agar tidak negatif jika diinstruksikan.
 *   - Tambahkan getter getJumlah() jika butuh dicek dari luar.
 */
public abstract class Pembayaran {

    // ------------------- ATRIBUT (protected agar bisa diakses subclass) -------------------
    protected String namaPelanggan;
    protected double jumlah;  // jumlah dasar (sebelum biaya/fee)

    // ------------------- KONSTRUKTOR -------------------
    /**
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar (sebelum biaya tambahan)
     */
    public Pembayaran(String namaPelanggan, double jumlah) {
        // HINT: kamu bisa trim null/whitespace jika perlu
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    }

    // ------------------- ABSTRACT METHOD -------------------
    /**
     * APA:
     *   Rumus total akhir. Wajib dioverride oleh subclass.
     *
     * KENAPA:
     *   Setiap metode pembayaran punya aturan biaya berbeda.
     *
     * @return total akhir pembayaran
     */
    public abstract double hitungTotal();

    // ------------------- GETTER -------------------
    /**
     * @return nama pelanggan
     */
    public String getNamaPelanggan() {
        return this.namaPelanggan;
    }

    // TODO (opsional):
    // public double getJumlah() { return this.jumlah; }
}

/**
 * COD.java (Cash On Delivery)
 *
 * APA:
 *   Subclass untuk metode bayar COD.
 *
 * KENAPA:
 *   Rumus total: jumlah + 5000 (biaya kurir).
 *
 * UNTUK APA:
 *   Meng-override hitungTotal() sesuai ketentuan.
 */
public class COD extends Pembayaran {

    /**
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * @Override hitungTotal
     * @return jumlah + 5000
     */
    @Override
    public double hitungTotal() {
        return this.jumlah + 5000.0;
    }
}

/**
 * EWallet.java
 *
 * APA:
 *   Subclass untuk metode bayar E-Wallet.
 *
 * KENAPA:
 *   Rumus total: jumlah + (jumlah * 0.01) (fee 1 persen).
 *
 * UNTUK APA:
 *   Meng-override hitungTotal() sesuai ketentuan.
 */
public class EWallet extends Pembayaran {

    /**
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public EWallet(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * @Override hitungTotal
     * @return jumlah + (jumlah * 0.01)
     */
    @Override
    public double hitungTotal() {
        return this.jumlah + (this.jumlah * 0.01);
    }
}

/**
 * TransferBank.java
 *
 * APA:
 *   Subclass untuk metode bayar Transfer Bank.
 *
 * KENAPA:
 *   Rumus total: jumlah + 4000 (biaya admin transfer).
 *
 * UNTUK APA:
 *   Meng-override hitungTotal() sesuai ketentuan.
 */
public class TransferBank extends Pembayaran {

    /**
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * @Override hitungTotal
     * @return jumlah + 4000
     */
    @Override
    public double hitungTotal() {
        return this.jumlah + 4000.0;
    }
}








/**
 * IAnimal.java
 *
 * APA:
 *   Interface = kontrak perilaku. Semua hewan harus punya method sound().
 *
 * KENAPA:
 *   Biar konsisten: setiap kelas hewan wajib menyediakan implementasi suara.
 *
 * UNTUK APA:
 *   Jadi acuan umum agar polimorfisme jalan (semua hewan bisa dipanggil sound()).
 *
 * TODO:
 *   - Tambahkan method lain jika diperlukan (mis. move(), eat()).
 */
public interface IAnimal {

    /**
     * @return string suara khas hewan
     */
    String sound();
}

/**
 * Animal.java
 *
 * APA:
 *   Abstract class untuk hewan, meng-implements IAnimal.
 *
 * KENAPA:
 *   Punya data/perilaku umum (name, species, habitat, sound, type),
 *   tapi tidak mau di-instansiasi langsung (harus subclass).
 *
 * UNTUK APA:
 *   Sebagai pondasi bagi Aves, Mammal, Reptile.
 */
public abstract class Animal implements IAnimal {

    // --------- ATRIBUT (private: enkapsulasi) ---------
    private String name;
    private String species;
    private String habitat;
    private String sound;

    // Jenis hewan level tinggi (membantu pengujian / grouping)
    public enum AnimalType { MAMMAL, AVES, REPTILE }
    private AnimalType animalType;

    // --------- KONSTRUKTOR (protected: hanya subclass) ---------
    /**
     * @param name    nama hewan (null -> "")
     * @param species spesies (null -> "")
     * @param habitat habitat (null -> "")
     * @param sound   suara (null -> "")
     * @param type    tipe hewan (MAMMAL/AVES/REPTILE)
     */
    protected Animal(String name, String species, String habitat, String sound, AnimalType type) {
        this.name    = (name == null)    ? "" : name.trim();
        this.species = (species == null) ? "" : species.trim();
        this.habitat = (habitat == null) ? "" : habitat.trim();
        this.sound   = (sound == null)   ? "" : sound.trim();
        this.animalType = type;
    }

    // --------- GETTER (public) ---------
    public String getName()            { return name; }
    public String getSpecies()         { return species; }
    public String getHabitat()         { return habitat; }
    public AnimalType getAnimalType()  { return animalType; }

    // --------- PERILAKU ---------
    /**
     * @Override dari IAnimal.
     * @return suara hewan (default dari field sound)
     */
    @Override
    public String sound() {
        return sound;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Species: " + species + "\n" +
               "Habitat: " + habitat + "\n" +
               "Type: " + animalType + "\n";
    }

    // TODO:
    // - Tambahkan setter jika perlu, dengan validasi sederhana.
}


/**
 * Aves.java
 *
 * APA:
 *   Subclass untuk burung (aves).
 *
 * KENAPA:
 *   Burung punya properti khusus: canFly (bisa terbang).
 *
 * UNTUK APA:
 *   Menyediakan getter canFly() yang memang dipanggil oleh tester.
 */
public class Aves extends Animal {

    private boolean canFly;

    /**
     * @param name    nama burung
     * @param species spesies burung
     * @param habitat habitat burung
     * @param sound   suara burung
     * @param canFly  true jika bisa terbang
     */
    public Aves(String name, String species, String habitat, String sound, boolean canFly) {
        super(name, species, habitat, sound, Animal.AnimalType.AVES);
        this.canFly = canFly;
    }

    /** Getter sesuai ekspektasi tester */
    public boolean canFly() { return canFly; }

    /** Alias opsional */
    public boolean isCanFly() { return canFly; }
    /** Alias opsional */
    public boolean getCanFly() { return canFly; }

    /** Setter opsional */
    public void setCanFly(boolean canFly) { this.canFly = canFly; }

    /** @Override: masih pakai suara default dari parent (bisa diubah nanti) */
    @Override
    public String sound() {
        return super.sound();
    }
}


/**
 * Mammal.java
 *
 * APA:
 *   Subclass untuk mamalia.
 *
 * KENAPA:
 *   Mamalia punya atribut unik: tipe bulu (FurType).
 *
 * UNTUK APA:
 *   Simpan FurType dan sediakan getter/setter.
 */
public class Mammal extends Animal {

    public enum FurType { SHORT, LONG, THICK, NONE }

    private FurType furType;

    /**
     * @param name    nama mamalia
     * @param species spesies mamalia
     * @param habitat habitat
     * @param sound   suara mamalia
     * @param furType tipe bulu
     */
    public Mammal(String name, String species, String habitat, String sound, FurType furType) {
        super(name, species, habitat, sound, Animal.AnimalType.MAMMAL);
        this.furType = furType;
    }

    public FurType getFurType() { return furType; }
    public void setFurType(FurType furType) { this.furType = furType; }

    /** @Override: tetap kembalikan suara default dari parent */
    @Override
    public String sound() {
        return super.sound();
    }
}


/**
 * Reptile.java
 *
 * APA:
 *   Subclass untuk reptil.
 *
 * KENAPA:
 *   Reptil punya atribut unik: tipe sisik (ScaleType).
 *
 * UNTUK APA:
 *   Simpan ScaleType dan sediakan getter.
 */
public class Reptile extends Animal {

    public enum ScaleType { SMOOTH, ROUGH, KEELED, GRANULAR }

    private ScaleType scaleType;

    /**
     * @param name      nama reptil
     * @param species   spesies reptil
     * @param habitat   habitat
     * @param sound     suara
     * @param scaleType tipe sisik
     */
    public Reptile(String name, String species, String habitat, String sound, ScaleType scaleType) {
        super(name, species, habitat, sound, Animal.AnimalType.REPTILE);
        this.scaleType = scaleType;
    }

    public ScaleType getScaleType() { return scaleType; }

    /** @Override: tetap kembalikan suara default dari parent */
    @Override
    public String sound() {
        return super.sound();
    }
}






/**
 * UsageType.java
 *
 * APA:
 *   Enum untuk jenis penggunaan OS.
 *
 * KENAPA:
 *   Memudahkan logika hitung multiplier yang berbeda per skenario.
 *
 * UNTUK APA:
 *   Dipakai argumen di calculateCompatibility() dan printInfo().
 */
public enum UsageType {
    SERVER,
    DEVELOPMENT,
    GAMING
}

/**
 * OperatingSystem.java
 *
 * APA:
 *   Abstract class dasar untuk berbagai OS.
 *
 * KENAPA:
 *   Ada data umum (name, version, kernelType, baseScore) dan perilaku umum
 *   (printInfo, clampScore), tapi rumus kompatibilitas berbeda di tiap OS,
 *   jadi calculateCompatibility dibuat abstrak.
 *
 * UNTUK APA:
 *   Jadi pondasi untuk Linux, MacOS, Windows.
 */
public abstract class OperatingSystem {

    // --------- ATRIBUT private + getter public (enkapsulasi) ---------
    private String name;
    private String version;
    private String kernelType;
    private double baseScore; // 0..100

    // --------- KONSTRUKTOR ---------
    /**
     * name, version, kernelType, baseScore
     * Null atau kosong -> default "Unknown ..." / 0
     */
    public OperatingSystem(String name, String version, String kernelType, double baseScore) {
        this.name       = (name == null || name.trim().isEmpty()) ? "Unknown OS"       : name.trim();
        this.version    = (version == null || version.trim().isEmpty()) ? "Unknown Version" : version.trim();
        this.kernelType = (kernelType == null || kernelType.trim().isEmpty()) ? "Unknown Kernel"  : kernelType.trim();
        this.baseScore  = baseScore;
    }

    // --------- ABSTRACT API ---------
    /**
     * @param usage skenario penggunaan
     * @return skor kompatibilitas yang SUDAH di-clamp ke 0..100
     */
    public abstract double calculateCompatibility(UsageType usage);

    // --------- HELPERS (protected) ---------
    /**
     * clampScore: memastikan skor tetap 0..100
     */
    protected double clampScore(double score) {
        if (score < 0.0) return 0.0;
        if (score > 100.0) return 100.0;
        return score;
    }

    /**
     * Informasi tambahan untuk printInfo.
     * Default kosong, override di subclass jika ada informasi khusus.
     */
    protected String getAdditionalInfo() {
        return "";
    }

    // --------- GETTER (public) ---------
    public String getName()       { return name; }
    public String getVersion()    { return version; }
    public String getKernelType() { return kernelType; }
    public double getBaseScore()  { return baseScore; }

    // --------- OUTPUT (public) ---------
    /**
     * printInfo:
     * Name: <name>
     * Version: <version>
     * Kernel Type: <kernelType>
     * {Additional Info jika ada}
     * Base Score: <2 desimal>
     * Compatibility for <usage>: <2 desimal>
     */
    public void printInfo(UsageType usage) {
        System.out.printf("Name: %s%n", getName());
        System.out.printf("Version: %s%n", getVersion());
        System.out.printf("Kernel Type: %s%n", getKernelType());

        String extra = getAdditionalInfo();
        if (extra != null && !extra.isEmpty()) {
            System.out.printf("%s%n", extra);
        }

        System.out.printf("Base Score: %.2f%n", getBaseScore());
        double comp = calculateCompatibility(usage);
        System.out.printf("Compatibility for %s: %.2f%n", usage.name(), comp);
    }
}


/**
 * Linux.java
 *
 * APA:
 *   Subclass OS untuk Linux.
 *
 * KENAPA:
 *   Menambahkan info distro dan aturan multiplier per usage.
 *
 * UNTUK APA:
 *   Menghitung kompatibilitas sesuai ketentuan:
 *   SERVER +20%, DEVELOPMENT +10%, GAMING -15%.
 */
public class Linux extends OperatingSystem {

    public enum Distro { UBUNTU, FEDORA, ARCH, DEBIAN }

    private Distro distroType;

    /**
     * @param name       nama OS
     * @param version    versi
     * @param kernelType jenis kernel
     * @param baseScore  base score
     * @param distroType enum distro (null -> UBUNTU)
     */
    public Linux(String name, String version, String kernelType, double baseScore, Distro distroType) {
        super(name, version, kernelType, baseScore);
        this.distroType = (distroType == null) ? Distro.UBUNTU : distroType;
    }

    public Distro getDistroType() { return this.distroType; }

    /**
     * @Override calculateCompatibility:
     * score = base + multiplier * base; clamp 0..100
     */
    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;
        if (usage == UsageType.SERVER) multiplier += 0.20;
        else if (usage == UsageType.DEVELOPMENT) multiplier += 0.10;
        else if (usage == UsageType.GAMING) multiplier += -0.15;
        double score = base + (multiplier * base);
        return clampScore(score);
    }

    /** Info tambahan untuk printInfo */
    @Override
    protected String getAdditionalInfo() {
        return "Distribution: " + this.distroType.name();
    }
}


/**
 * MacOS.java
 *
 * APA:
 *   Subclass OS untuk macOS.
 *
 * KENAPA:
 *   Ada flag hasMSeriesChip yang mempengaruhi multiplier.
 *
 * UNTUK APA:
 *   Hitung kompatibilitas:
 *   DEVELOPMENT +25%, GAMING -20%, jika hasMSeriesChip true +10%.
 */
public class MacOS extends OperatingSystem {

    private boolean hasMSeriesChip;

    /**
     * @param name       nama OS
     * @param version    versi
     * @param kernelType jenis kernel
     * @param baseScore  base score
     * @param hasMSeriesChip apakah ada chip seri M
     */
    public MacOS(String name, String version, String kernelType, double baseScore, boolean hasMSeriesChip) {
        super(name, version, kernelType, baseScore);
        this.hasMSeriesChip = hasMSeriesChip;
    }

    public boolean hasMSeriesChip() { return this.hasMSeriesChip; }

    /**
     * @Override calculateCompatibility:
     * score = base + multiplier * base; clamp 0..100
     */
    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;
        if (usage == UsageType.DEVELOPMENT) multiplier += 0.25;
        else if (usage == UsageType.GAMING) multiplier += -0.20;
        if (hasMSeriesChip) multiplier += 0.10;
        double score = base + (multiplier * base);
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Has M-Series Chip: " + (hasMSeriesChip ? "Yes" : "No");
    }
}

/**
 * Windows.java
 *
 * APA:
 *   Subclass OS untuk Windows.
 *
 * KENAPA:
 *   Ada enum Edition yang mempengaruhi multiplier.
 *
 * UNTUK APA:
 *   Hitung kompatibilitas:
 *   - Jika edition SERVER dan usage SERVER: +30%
 *   - Untuk GAMING: +20%
 *   - Jika edition HOME dan usage SERVER: -5%
 */
public class Windows extends OperatingSystem {

    public enum Edition { HOME, PRO, SERVER }

    private Edition edition;

    /**
     * @param name       nama OS
     * @param version    versi
     * @param kernelType jenis kernel
     * @param baseScore  base score
     * @param edition    edisi (null -> HOME)
     */
    public Windows(String name, String version, String kernelType, double baseScore, Edition edition) {
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    public Edition getEdition() { return this.edition; }

    /**
     * @Override calculateCompatibility:
     * score = base + multiplier * base; clamp 0..100
     */
    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;

        if (usage == UsageType.GAMING) multiplier += 0.20;
        if (edition == Edition.SERVER && usage == UsageType.SERVER) multiplier += 0.30;
        if (edition == Edition.HOME && usage == UsageType.SERVER)   multiplier += -0.05;

        double score = base + (multiplier * base);
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Edition: " + this.edition.name();
    }
}


/**
 * MenuItem.java
 *
 * APA:
 *   Abstract class induk untuk item menu.
 *
 * KENAPA:
 *   Harga dasar tiap menu berbeda (ditentukan subclass), sehingga basePrice() dibuat abstrak.
 *
 * UNTUK APA:
 *   Simpan data umum (nama, quantity, unit, kategori) dan hitung price()
 *   dengan aturan promo, happy hour, dan pajak seperti di soal.
 */

public abstract class MenuItem {

    // Enum agar aman dari salah ketik String
    public enum Kategori { MAKANAN, MINUMAN }
    public enum Unit { ML, GRAM }

    // Atribut umum tiap menu (enkapsulasi dengan private + getter)
    private String namaMenu;

    /** jumlah mililiter atau gram, tergantung unit */
    private int quantity;
    private Unit unit;
    private Kategori kategori;

    /** Pajak tetap untuk semua menu (10%). */
    private static final double TAX_RATE = 0.10;

    /** Counter total objek yang pernah dibuat. */
    private static int totalCreated;

    /** Persentase promo global (0-90). */
    private static int promoPercent;

    /**
     * Status happy hour (diskon ekstra 20% SETELAH promo diterapkan).
     * - true  => aktif, harga setelah promo dikalikan 0.8
     * - false => nonaktif
     */
    private static boolean happyHour;

    /**
     * Constructor untuk membuat MenuItem baru.
     * totalCreated akan bertambah setiap kali objek dibuat.
     * Validasi quantity lebih dari sama dengan 0. Jika quantity negatif, quantity akan bernilai defaultnya yaitu 100
     *
     * For your exploration:
     * 1) Carilah cara agar string yang dimasukkan ke objek lebih bersih
     * 2) Cobalah belajar cara menggunakan ternary operation
     *
     * @param namaMenu  Nama menu
     * @param quantity  Volume saji
     * @param unit      ML atau GRAM
     * @param kategori  kategori menu (MAKANAN atau MINUMAN)
     */
    public MenuItem(String namaMenu, int quantity, Unit unit, Kategori kategori) {
        // APA: normalisasi nama agar tidak null dan tidak ada spasi pinggir.
        // KENAPA: mencegah NullPointerException dan data kotor.
        String nm = (namaMenu == null) ? "" : namaMenu.trim();
        this.namaMenu = nm;

        // Validasi quantity: negatif -> 100 (sesuai soal)
        this.quantity = (quantity < 0) ? 100 : quantity;

        this.unit = unit;
        this.kategori = kategori;

        // Hitung berapa objek MenuItem yang pernah dibuat (static counter)
        totalCreated++;
    }

    // ===== GETTERS =====
    /** @return nama menu */
    public String getNamaMenu() { return this.namaMenu; }

    /** @return jumlah ml/gram */
    public int getQuantity() { return this.quantity; }

    /** @return unit (ML atau GRAM) */
    public Unit getUnit() { return this.unit; }

    /** @return kategori (MAKANAN atau MINUMAN) */
    public Kategori getKategori() { return this.kategori; }

    /** @return total objek MenuItem yang pernah dibuat */
    public static int getTotalCreated() { return totalCreated; }

    /**
     * Mengatur persentase promo global (0 - 90).
     * Aturan: hanya menerima 0 - 90. Jika di luar rentang, abaikan.
     *
     * @param percent persentase promo
     */
    public static void setPromo(int percent) {
        if (percent >= 0 && percent <= 90) {
            promoPercent = percent;
        }
    }

    /**
     * Mengatur status happy hour (diskon ekstra 20%).
     *
     * @param active true jika happy hour aktif
     */
    public static void setHappyHour(boolean active) {
        happyHour = active;
    }

    // ===== Wajib di-override oleh subclass =====
    /**
     * Menghasilkan harga dasar (sebelum promo & pajak) untuk menu ini.
     * Method abstrak WAJIB dioverride oleh subclass.
     *
     * @return harga dasar menu
     */
    public abstract int basePrice();

    /**
     * Menghitung harga final setelah promo, happy hour, dan pajak.
     *
     * Aturan perhitungan (WAJIB diikuti):
     * 1) Ambil harga dasarnya (paling minimum harga dasar dibikin 0)
     * 2) Terapkan promoPercent
     * 3) Jika happyHour aktif, dapat diskon tambahan 20% (ingat misalnya 50% + 20% bukan berarti 70% ya)
     * 4) Tambahkan pajak (berdasarkan harga sebelum diskon)
     * 5) Selalu bulatkan hasil tiap proses ke integer
     *
     * For your exploration:
     * 1) Coba pelajari tentang penggunaan method pada Math, misalnya (Math.round, Math.min, Math.max, dsb.)
     * 2) Pelajari tentang casting tipe data, misalnya double jadi integer, dan sebagainya
     *
     * @return harga final
     */
    public int price() {
        // 1) base tidak boleh negatif
        int base = Math.max(0, basePrice());

        // 2) promo: bulatkan ke integer
        int afterPromo = (int) Math.round(base * (100 - promoPercent) / 100.0);

        // 3) happy hour: diskon 20% SETELAH promo
        if (happyHour) {
            afterPromo = (int) Math.round(afterPromo * 0.8);
        }

        // 4) pajak dihitung dari harga dasar (base), bulatkan
        int tax = (int) Math.round(base * TAX_RATE);

        // 5) total akhir
        int finalPrice = afterPromo + tax;
        if (finalPrice < 0) finalPrice = 0;
        return finalPrice;
    }

    /**
     * Mengembalikan simbol satuan dari unit yang dipakai.
     * Format:
     * - Jika unit = ML   -> "ml"
     * - Jika unit = GRAM -> "g"
     *
     * @return string simbol unit ("ml" atau "g")
     */
    private String unitSymbol() {
        return (this.unit == Unit.ML) ? "ml" : "g";
    }

    /**
     * Label default menu.
     * Format: "<namaMenu> <quantity><unitSymbol>".
     *
     * @return label string default
     */
    public String label() {
        return this.namaMenu + " " + this.quantity + unitSymbol();
    }

    /**
     * Overloading label:
     * Jika showPrice = true, kembalikan "<namaMenu> <quantity><unit> | Rp<hargaFinal>"
     * Jika showPrice = false, kembalikan label() saja
     *
     * @param showPrice tampilkan harga atau tidak
     * @return label menu (dengan atau tanpa harga)
     */
    public String label(boolean showPrice) {
        if (showPrice) {
            return label() + " | Rp" + price();
        }
        return label();
    }

    /**
     * Final method (tidak boleh dioverride): Mengembalikan brand tetap untuk semua MenuItem.
     *
     * @return string brand
     */
    public final String brand() {
        return "Kantin Kampus";
    }

    /**
     * Representasi string dari MenuItem dengan format:
     * "<kategori> <namaMenu> <quantity><unit> | Rp<harga final> dari <brand>"
     *
     * @return string representasi menu
     */
    @Override
    public String toString() {
        return this.kategori + " " + this.namaMenu + " " + this.quantity + unitSymbol()
                + " | Rp" + price() + " dari " + brand();
    }
}


/**
 * Milkshake.java
 *
 * APA:
 *   Subclass dari MenuItem untuk minuman Milkshake.
 *
 * KENAPA:
 *   Aturan harga dasar bergantung ukuran dan topping es krim.
 *
 * UNTUK APA:
 *   Simpan jenis rasa, flag topping, ukuran. Override basePrice() dan label().
 */

public class Milkshake extends MenuItem {

    public enum Ukuran { SMALL, MEDIUM, LARGE }

    private String jenis;
    private boolean iceCreamTopping;
    private Ukuran ukuran;

    /**
     * Constructor Milkshake.
     *
     * For your exploration:
     * - Untuk enum, jangan lupa gunakan EnumName.VALUE
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set jenis menjadi "Original"
     *
     * @param volumeMl        volume minuman dalam ml
     * @param jenis           jenis milkshake (contoh: "Strawberry")
     * @param iceCreamTopping true jika ada topping es krim tambahan
     * @param ukuran          ukuran milkshake (SMALL, MEDIUM, LARGE)
     */
    public Milkshake(int volumeMl, String jenis, boolean iceCreamTopping, Ukuran ukuran) {
        // TODO: panggil constructor superclass (super) dengan namaMenu="Milkshake",
        //       quantity=volumeMl, unit=Unit.ML, kategori=Kategori.MINUMAN
        super("Milkshake", volumeMl, Unit.ML, Kategori.MINUMAN);

        // TODO: simpan parameter jenis, iceCreamTopping, ukuran ke atribut
        String j = (jenis == null) ? "" : jenis.trim();
        if (j.isEmpty()) j = "Original";
        this.jenis = j;
        this.iceCreamTopping = iceCreamTopping;
        this.ukuran = ukuran;
    }

    /**
     * Getter untuk jenis milkshake.
     *
     * @return jenis milkshake
     */
    public String getJenis() {
        return this.jenis;
    }

    /**
     * Setter untuk jenis milkshake.
     *
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set jenis menjadi "Original"
     *
     * @param jenis jenis milkshake baru
     */
    public void setJenis(String jenis) {
        String j = (jenis == null) ? "" : jenis.trim();
        if (j.isEmpty()) j = "Original";
        this.jenis = j;
    }

    /**
     * Getter untuk iceCreamTopping.
     *
     * @return iceCreamTopping
     */
    public boolean hasIceCreamTopping() {
        return this.iceCreamTopping;
    }

    /**
     * Setter untuk status topping es krim.
     *
     * @param iceCreamTopping true jika ada topping
     */
    public void setIceCreamTopping(boolean iceCreamTopping) {
        this.iceCreamTopping = iceCreamTopping;
    }

    /**
     * Getter untuk ukuran milkshake.
     *
     * @return ukuran milkshake
     */
    public Ukuran getUkuran() {
        return this.ukuran;
    }

    /**
     * Setter untuk ukuran milkshake.
     *
     * @param ukuran ukuran milkshake baru
     */
    public void setUkuran(Ukuran ukuran) {
        this.ukuran = ukuran;
    }

    /**
     * Override basePrice() dari MenuItem.
     * Aturan harga dasar:
     * - SMALL  = 10000
     * - MEDIUM = 13000
     * - LARGE  = 15000
     * Tambahan:
     * - Jika iceCreamTopping = true, tambahkan 5000
     *
     * @return harga dasar milkshake
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
     * Override label() dari MenuItem.
     * Format contoh:
     * - "Milkshake Strawberry [MEDIUM] 250ml" (jika iceCreamTopping = false)
     * - "Milkshake Strawberry Float [MEDIUM] 250ml" (jika iceCreamTopping = true)
     *
     * @return label string untuk milkshake
     */
    @Override
    public String label() {
        String name = "Milkshake " + this.jenis + (iceCreamTopping ? " Float" : "");
        return name + " [" + this.ukuran + "] " + getQuantity() + "ml";
    }
}


