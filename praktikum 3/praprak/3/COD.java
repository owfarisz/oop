/**
 * COD.java (Cash on Delivery)
 * Subclass dari Pembayaran.
 * Rumus total: jumlah + 5000.
 */
public class COD extends Pembayaran {

    /**
     * Constructor COD.
     * @param namaPelanggan nama pelanggan
     * @param jumlah jumlah dasar
     */
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    /**
     * Meng-override hitungTotal.
     * @return jumlah + 5000
     */
    @Override
    public double hitungTotal() {
        // TODO: jika ingin aman dari nilai negatif, kamu bisa Math.max(0, jumlah)
        return this.jumlah + 5000.0;
    }
}
