public class Pembeli {
    private String namaPembeli;
    private int nomorMeja;
    private double saldoPembeli;

    /**
     * Konstruktor Pembeli
     * @param nama
     * @param nomor
     * @param saldo
     */
    public Pembeli(String nama, int nomor, double saldo) {
        // TODO: inisialisasi atribut
        this.namaPembeli = nama;
        this.nomorMeja = nomor;
        this.saldoPembeli = saldo;
    }

    /**
     * getNamaPembeli
     * @return namaPembeli
     */
    public String getNamaPembeli() {
        // TODO: return namaPembeli
        return this.namaPembeli;
    }

    /**
     * setNamaPembeli
     * @param namaBaru
     * @return void
     */
    public void setNamaPembeli(String namaBaru) {
        // TODO: set nilai namaPembeli
        this.namaPembeli = namaBaru;
    }

    /**
     * getNomorMeja
     * @return nomorMeja
     */
    public int getNomorMeja() {
        // TODO: return nomorMeja
        return this.nomorMeja;
    }

    /**
     * setNomorMeja
     * @param nomorBaru
     * @return void
     */
    public void setNomorMeja(int nomorBaru) {
        // TODO: set nilai nomorMeja
        this.nomorMeja = nomorBaru;
    }

    /**
     * getSaldo
     * @return saldoPembeli
     */
    public double getSaldo() {
        // TODO: return saldoPembeli
        return this.saldoPembeli;
    }

    /**
     * setSaldo
     * @param saldoBaru
     * @return void
     */
    public void setSaldo(double saldoBaru) {
        // TODO: set nilai saldo
        this.saldoPembeli = saldoBaru;
    }

    /**
     * cekBisaBayar
     * Mengecek apakah saldo cukup untuk membayar total harga OrderMakanan
     * @param order
     * @return true jika saldo mencukupi untuk membayar total harga OrderMakanan, selain itu false
     */
    public boolean cekBisaBayar(OrderMakanan order) {
        // TODO: implementasi perbandingan saldo vs order.getTotalHarga()
        return this.saldoPembeli >= order.getTotalHarga();
    }
}
