/**
 * COD.java
 *
 * APA:
 *   Kelas metode pembayaran Cash On Delivery (COD).
 *
 * KENAPA:
 *   COD hanya perlu kemampuan bayar; tidak ada pengembalian dana.
 *
 * UNTUK APA:
 *   Menunjukkan bahwa kita bisa menambah metode pembayaran lain dengan mudah
 *   hanya dengan memilih interface yang diperlukan (loose coupling).
 */
public class COD extends Pembayaran implements Payable {

    // TODO: Opsional constructor untuk set saldo awal (misal deposit untuk COD)
    /**
     * Membuat COD dengan saldo awal tertentu (opsional).
     * @param initialBalance saldo awal
     */
    public COD(int initialBalance) {
        super(initialBalance);
    }

    /**
     * Membuat COD dengan saldo awal 0.
     */
    public COD() {
        super(0);
    }

    // TODO: Implementasi Payable.pay(int)
    @Override
    public void pay(int amount) {
        int current = getBalance();
        if (amount > 0 && current >= amount) {
            int remaining = current - amount;
            setBalance(remaining);
            System.out.println("[COD] Paid: " + amount + ". Remaining balance: " + remaining);
        } else {
            System.out.println("[COD] Payment failed. Insufficient balance or invalid amount.");
        }
    }

    // NOTE:
    // Tidak mengimplementasikan Refundable.
    // Jika suatu saat COD perlu refund, tinggal implements Refundable dan tambahkan method refund().
}

