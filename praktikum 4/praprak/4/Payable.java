/**

 *
 * APA:
 *   Interface (kontrak) untuk fitur pembayaran.
 *
 * KENAPA:
 *   Memisahkan perilaku bayar agar kelas turunan bisa memilih mengimplementasikan
 *   kemampuan bayar saja atau bersama fitur lain (mis. refund).
 *
 * UNTUK APA:
 *   Dipakai oleh EWallet dan COD.
 */
public interface Payable {

    // TODO: Method kontrak pembayaran
    /**
     * Melakukan pembayaran sejumlah amount.
     * RULE:
     * - Valid jika amount > 0 dan saldo mencukupi (balance >= amount).
     * - Output sukses: "[<Tipe Pembayaran>] Paid: {amount}. Remaining balance: {balance}"
     * - Output gagal:  "[<Tipe Pembayaran>] Payment failed. Insufficient balance or invalid amount."
     *
     * @param amount jumlah pembayaran
     */
    void pay(int amount);
}
