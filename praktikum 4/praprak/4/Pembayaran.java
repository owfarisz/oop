/**
 * Pembayaran.java
 *
 * APA:
 *   Kelas dasar yang menyimpan saldo (balance) untuk berbagai metode pembayaran.
 *
 * KENAPA:
 *   Balance disatukan agar turunan (COD/EWallet) tinggal pakai getter/setter yang sama.
 *
 * UNTUK APA:
 *   Enkapsulasi balance (private) + akses via getter/setter.
 */
public class Pembayaran {

    // TODO: Private field balance (int)
    /** Saldo metode pembayaran ini (disembunyikan / private). */
    private int balance;

    // TODO: Constructor optional (bisa tidak dipakai jika tidak diminta)
    /**
     * Constructor opsional untuk inisialisasi balance awal.
     * Jika tidak ingin pakai, cukup gunakan setter setelah membuat objek.
     *
     * @param initialBalance saldo awal
     */
    public Pembayaran(int initialBalance) {
        this.balance = Math.max(0, initialBalance);
    }

    /**
     * Constructor tanpa argumen (default 0).
     */
    public Pembayaran() {
        this(0);
    }

    // TODO: Setter dan Getter balance
    /**
     * Mengubah nilai saldo.
     * @param newBalance saldo baru (dibatasi minimal 0)
     */
    public void setBalance(int newBalance) {
        this.balance = Math.max(0, newBalance);
    }

    /**
     * Mengambil nilai saldo saat ini.
     * @return saldo (int)
     */
    public int getBalance() {
        return this.balance;
    }
}
