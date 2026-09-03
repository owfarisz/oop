/**
 * EWallet.java
 *
 * APA:
 *   Kelas metode pembayaran E-Wallet.
 *
 * KENAPA:
 *   Contoh penerapan multiple interface pada Java (Payable + Refundable)
 *   sekaligus turunan dari kelas dasar Pembayaran untuk reuse balance.
 *
 * UNTUK APA:
 *   Mengelola saldo e-wallet: bayar dan refund sesuai kontrak interface.
 */
public class EWallet extends Pembayaran implements Payable, Refundable {

    // TODO: Opsional constructor untuk set saldo awal
    /**
     * Membuat EWallet dengan saldo awal tertentu.
     * @param initialBalance saldo awal
     */
    public EWallet(int initialBalance) {
        super(initialBalance);
    }

    /**
     * Membuat EWallet dengan saldo awal 0.
     */
    public EWallet() {
        super(0);
    }

    // TODO: Implementasi Payable.pay(int)
    @Override
    public void pay(int amount) {
        // Valid jika amount > 0 dan balance cukup
        int current = getBalance();
        if (amount > 0 && current >= amount) {
            int remaining = current - amount;
            setBalance(remaining);
            System.out.println("[EWallet] Paid: " + amount + ". Remaining balance: " + remaining);
        } else {
            System.out.println("[EWallet] Payment failed. Insufficient balance or invalid amount.");
        }
    }

    // TODO: Implementasi Refundable.refund(int)
    @Override
    public void refund(int amount) {
        // Valid jika amount > 0
        if (amount > 0) {
            int newBalance = getBalance() + amount;
            setBalance(newBalance);
            System.out.println("[EWallet] Refunded: " + amount + ". New balance: " + newBalance);
        } else {
            System.out.println("[EWallet] Refund failed. Invalid amount.");
        }
    }
}
