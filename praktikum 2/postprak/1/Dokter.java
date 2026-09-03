public class Dokter {
    private static int jumlahDokter = 0;
    private static int MAX_PASIEN = 3;

    private String kodeDokter;
    private DataPribadi dataPribadi;
    private String spesialisasi;
    private int jumlahPasien;
    private boolean sedangBertugas;
    private double tarif;

    // TODO 1: Buat constructor yang menerima DataPribadi dan spesialisasi
    public Dokter(DataPribadi dataPribadi, String spesialisasi) {
        // TODO 1a: Tambahkan jumlahDokter
        jumlahDokter++;

        // TODO 1b: Generate kodeDokter menggunakan format "DR001", "DR002", dst.
        // Petunjuk: Gunakan String.format("%03d", jumlahDokter) untuk mendapat angka 3 digit dengan leading zeros
        this.kodeDokter = "DR" + String.format("%03d", jumlahDokter);

        // TODO 1c: Inisialisasi semua variabel instance
        this.dataPribadi = dataPribadi;
        this.spesialisasi = spesialisasi;
        this.jumlahPasien = 0;
        this.sedangBertugas = false;

        // TODO 1d: Hitung tarif berdasarkan spesialisasi
        // Umum: 100000, Jantung: 300000, Anak: 200000
        if ("Jantung".equalsIgnoreCase(spesialisasi)) {
            this.tarif = 300_000;
        } else if ("Anak".equalsIgnoreCase(spesialisasi)) {
            this.tarif = 200_000;
        } else {
            this.tarif = 100_000; // default ke Umum
        }

        // TODO 1e: Tambahkan bonus pengalaman berdasarkan umur
        // Bonus = ((umur - 25) / 5) * 50000
        int umur = dataPribadi != null ? dataPribadi.getUmur() : 0;
        int kelipatan = (umur - 25) / 5; // integer division
        if (kelipatan > 0) {
            this.tarif += kelipatan * 50_000;
        }
    }

    // TODO 2: Buat method mulaiShift()
    // Mengembalikan true jika berhasil memulai shift, false jika sudah bertugas
    public boolean mulaiShift() {
        if (sedangBertugas) return false;
        sedangBertugas = true;
        return true;
    }

    // TODO 3: Buat method tambahPasien()
    // Mengembalikan true jika berhasil menambah pasien, false jika tidak bertugas atau sudah maksimal
    public boolean tambahPasien() {
        if (!sedangBertugas) return false;
        if (jumlahPasien >= MAX_PASIEN) return false;
        jumlahPasien++;
        return true;
    }

    // TODO 4: Buat method decrementPasien() untuk mengurangi jumlah pasien
    // Petunjuk: Hanya kurangi jika jumlahPasien > 0
    public void decrementPasien() {
        if (jumlahPasien > 0) jumlahPasien--;
    }

    // TODO 5: Buat static getter untuk jumlahDokter
    public static int getJumlahDokter() {
        return jumlahDokter;
    }

    // TODO 6: Override method toString()
    // Format: "kodeDokter - nama (spesialisasi) - Pasien: current/max"
    // Contoh: "DR001 - Dr. Budi (Umum) - Pasien: 2/3"
    @Override
    public String toString() {
        String nama = (dataPribadi != null) ? dataPribadi.getNama() : "Unknown";
        return String.format("%s - %s (%s) - Pasien: %d/%d",
                kodeDokter, nama, spesialisasi, jumlahPasien, MAX_PASIEN);
    }

    // TODO 7: Buat method getter untuk semua atribut private
    public String getSpesialisasi() {
        return spesialisasi;
    }

    public boolean isSedangBertugas() {
        return sedangBertugas;
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public double getTarif() {
        return tarif;
    }

    public DataPribadi getDataPribadi() {
        return dataPribadi;
    }

    public String getKodeDokter() {
        return kodeDokter;
    }
}
