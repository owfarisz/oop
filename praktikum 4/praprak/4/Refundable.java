/**
 * Refundable.java
 *
 * APA:
 *   Interface (kontrak) untuk fitur pengembalian dana.
 *
 * KENAPA:
 *   Tidak semua metode pembayaran perlu refund (contoh: COD).
 *
 * UNTUK APA:
 *   Dipakai oleh EWallet (bisa pay + refund).
 */
public interface Refundable {

    // TODO: Method kontrak refund
    /**
     * Melakukan pengembalian dana sejumlah amount.
     * RULE:
     * - Valid jika amount > 0.
     * - Output sukses: "[<Tipe Pembayaran>] Refunded: {amount}. New balance: {balance}"
     * - Output gagal:  "[<Tipe Pembayaran>] Refund failed. Invalid amount."
     *
     * @param amount jumlah refund
     */
    void refund(int amount);
}
