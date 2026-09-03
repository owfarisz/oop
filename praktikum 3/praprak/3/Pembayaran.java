/**
 * Pembayaran.java
 * Kelas abstrak untuk semua metode pembayaran.
 * 
 * Spesifikasi:
 * - Atribut protected agar bisa diakses oleh kelas ini & subclass.
 * - Method abstrak hitungTotal() wajib dioverride oleh subclass.
 * - Sediakan getter getNamaPelanggan().
 *
 * TODO (opsional untukmu):
 *  - Validasi nilai jumlah agar tidak negatif.
 *  - Tambahkan getter lain jika diperlukan (misal getJumlah()).
 */
public abstract class Pembayaran {
    // ================== ATTRIBUTES ==================
    /** Nama pelanggan yang melakukan transaksi */
    protected String namaPelanggan;
    /** Jumlah dasar yang harus dibayar (sebelum biaya/fee) */
    protected double jumlah;

    // ================== CONSTRUCTORS ==================
    /**
     * Constructor dasar.
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar (sebelum biaya tambahan)
     */
    public Pembayaran(String namaPelanggan, double jumlah) {
        // TODO: kamu bisa tambahkan pembersihan string (trim) jika mau
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    }

    // ================== ABSTRACT METHODS ==================
    /**
     * Menghitung total akhir yang harus dibayar pelanggan.
     * Wajib diimplementasikan di subclass.
     * @return total akhir pembayaran
     */
    public abstract double hitungTotal();

    // ================== GETTERS ==================
    /**
     * Mengembalikan namaPelanggan.
     * @return nama pelanggan
     */
    public String getNamaPelanggan() {
        return this.namaPelanggan;
    }

    // OPTIONAL untukmu (tidak wajib tugas):
    // public double getJumlah() { return this.jumlah; }
}
