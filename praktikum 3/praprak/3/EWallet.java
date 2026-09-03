/**
 * EWallet.java
 * Subclass dari Pembayaran.
 * Rumus total: jumlah + (jumlah * 0.01).
 */
public class EWallet extends Pembayaran {

    /**
     * Constructor EWallet.
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public EWallet(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * Meng-override hitungTotal.
     * @return jumlah + (jumlah * 0.01)
     */
    @Override
    public double hitungTotal() {
        // TODO: jika ingin pembulatan khusus, lakukan di sini
        return this.jumlah + (this.jumlah * 0.01);
    }
}
