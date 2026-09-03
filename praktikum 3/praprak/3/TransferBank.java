/**
 * TransferBank.java
 * Subclass dari Pembayaran.
 * Rumus total: jumlah + 4000.
 */
public class TransferBank extends Pembayaran {

    /**
     * Constructor TransferBank.
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * Meng-override hitungTotal.
     * @return jumlah + 4000
     */
    @Override
    public double hitungTotal() {
        return this.jumlah + 4000.0;
    }
}
