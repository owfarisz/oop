public class Pasien {
    private static int nomorUrut = 1;

    private String nomorPasien;
    private DataPribadi dataPribadi;
    private String keluhan;
    private String tingkatUrgent;
    private Dokter dokterPemeriksa;
    private double biaya;
    private boolean sudahSelesai;

    // TODO 1: Buat constructor yang menerima DataPribadi, keluhan, dan tingkatUrgent
    public Pasien(DataPribadi dataPribadi, String keluhan, String tingkatUrgent) {
        // TODO 1a: Generate nomorPasien menggunakan format "P0001", "P0002", dst.
        this.nomorPasien = "P" + String.format("%04d", nomorUrut);

        // TODO 1b: Tambahkan nomorUrut untuk pasien berikutnya
        nomorUrut++;

        // TODO 1c: Inisialisasi semua variabel instance
        // Set dokterPemeriksa ke null, biaya ke 0.0, sudahSelesai ke false
        this.dataPribadi = dataPribadi;
        this.keluhan = keluhan;
        this.tingkatUrgent = tingkatUrgent;
        this.dokterPemeriksa = null;
        this.biaya = 0.0;
        this.sudahSelesai = false;
    }

    // TODO 2: Buat method assignDokter() yang menerima object Dokter
    public boolean assignDokter(Dokter dokter) {
        // Validasi awal
        if (dokter == null) return false;

        // TODO 2a: Periksa apakah dokter dapat menangani tingkat urgensi pasien ini
        String s = dokter.getSpesialisasi();
        String t = this.tingkatUrgent;

        // - Pasien "Berat" hanya bisa ke dokter "Jantung" atau "Anak"
        if ("Berat".equalsIgnoreCase(t)) {
            if (!( "Jantung".equalsIgnoreCase(s) || "Anak".equalsIgnoreCase(s) )) {
                return false;
            }
        // - Pasien "Sedang" tidak boleh ke dokter "Umum"
        } else if ("Sedang".equalsIgnoreCase(t)) {
            if ("Umum".equalsIgnoreCase(s)) {
                return false;
            }
        }
        // "Ringan" bisa ke dokter mana saja

        // TODO 2b: Hitung biaya berdasarkan tingkatUrgent
        double multiplier = 1.0;
        if ("Sedang".equalsIgnoreCase(t)) multiplier = 1.5;
        else if ("Berat".equalsIgnoreCase(t)) multiplier = 2.0;

        // TODO 2c: Assign dokter dan tambahkan pasien ke hitungan dokter
        if (dokter.tambahPasien()) {
            this.dokterPemeriksa = dokter;
            this.biaya = dokter.getTarif() * multiplier;
            return true;
        }
        return false;
    }

    // TODO 3: Buat method resetAssignment()
    // Reset dokterPemeriksa ke null dan biaya ke 0
    public void resetAssignment() {
        this.dokterPemeriksa = null;
        this.biaya = 0.0;
    }

    // TODO 4: Override method toString()
    // Format: "nomorPasien - nama (tingkatUrgent) - Biaya: RpX,XXX"
    // Petunjuk: Gunakan String.format("%,.0f", biaya) untuk format mata uang dengan koma
    @Override
    public String toString() {
        String nama = (dataPribadi != null) ? dataPribadi.getNama() : "Unknown";
        return String.format("%s - %s (%s) - Biaya: Rp%s",
                nomorPasien, nama, tingkatUrgent, String.format("%,.0f", biaya));
    }

    // TODO 5: Buat method getter untuk semua atribut yang diperlukan
    public Dokter getDokterPemeriksa() {
        return dokterPemeriksa;
    }

    public double getBiaya() {
        return biaya;
    }

    public String getTingkatUrgent() {
        return tingkatUrgent;
    }

    public DataPribadi getDataPribadi() {
        return dataPribadi;
    }

    public String getNomorPasien() {
        return nomorPasien;
    }
}