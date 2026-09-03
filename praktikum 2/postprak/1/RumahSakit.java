public class RumahSakit {
    private static RumahSakit instance = null;
    private String namaRS;
    private double totalPendapatan;

    // TODO 1: Buat private constructor (syarat Singleton pattern)
    // Constructor harus menerima parameter namaRS dan inisialisasi variabel
    private RumahSakit(String namaRS) {
        this.namaRS = namaRS;
        this.totalPendapatan = 0.0;
    }

    // TODO 2: Buat static method getInstance() (Singleton pattern)
    // Jika instance null, buat RumahSakit baru, jika tidak return instance yang ada
    public static RumahSakit getInstance(String namaRS) {
        if (instance == null) {
            instance = new RumahSakit(namaRS);
        }
        return instance;
    }

    // TODO 3: Buat method prosesPemeriksaan()
    // Method ini menerima Pasien dan array Dokter
    // Harus menemukan dokter terbaik yang tersedia untuk pasien
    // PENJELASAN: Dokter "terbaik" = dokter yang bisa menangani pasien DAN memiliki jumlah pasien paling sedikit
    public boolean prosesPemeriksaan(Pasien pasien, Dokter[] daftarDokter) {
        // TODO 3a: Inisialisasi variabel untuk melacak dokter terbaik
        Dokter dokterTerpilih = null;
        int minPasien = 999;

        if (daftarDokter == null || daftarDokter.length == 0 || pasien == null) {
            System.out.println("Error: Tidak ada dokter yang tersedia untuk pasien ini");
            return false;
        }

        // TODO 3b: Loop melalui semua dokter di daftarDokter
        // Untuk setiap dokter, periksa apakah mereka bertugas dan punya ruang (< 3 pasien)
        for (Dokter d : daftarDokter) {
            if (d == null) continue;
            if (!d.isSedangBertugas()) continue;
            if (d.getJumlahPasien() >= 3) continue;

            // TODO 3c: Tes kompatibilitas dengan pasien.assignDokter(d)
            int current = d.getJumlahPasien();
            if (pasien.assignDokter(d)) {
                if (current < minPasien) {
                    minPasien = current;
                    dokterTerpilih = d;
                }
                // reset setelah testing
                d.decrementPasien();
                pasien.resetAssignment();
            }
        }

        // TODO 3d: Setelah menemukan dokter terbaik, assign pasien
        if (dokterTerpilih != null) {
            boolean ok = pasien.assignDokter(dokterTerpilih);
            if (ok) {
                this.totalPendapatan += pasien.getBiaya();
                String namaPasien = pasien.getDataPribadi() != null ? pasien.getDataPribadi().getNama() : "Unknown";
                String namaDokter = dokterTerpilih.getDataPribadi() != null ? dokterTerpilih.getDataPribadi().getNama() : "Unknown";
                System.out.println("Berhasil: " + namaPasien + " ditangani " + namaDokter);
                return true;
            }
        }

        // TODO 3e: Return true jika berhasil, false jika tidak ada dokter yang cocok
        System.out.println("Error: Tidak ada dokter yang tersedia untuk pasien ini");
        return false;
    }

    // TODO 4: Buat method getter
    public String getNamaRS() {
        return namaRS;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }
}
