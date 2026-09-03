public class OrderMakanan {
    private String namaMakanan;
    private int countMakanan;
    private double hargaSatuan;

    /**
     * Konstruktor OrderMakanan
     * @param nama
     * @param count
     * @param harga
     */
    public OrderMakanan(String nama, int count, double harga) {
        String namaMakanan;
        int countMakanan;
        double hargaSatuan;
    }

    /**
     * getNamaMakanan
     * @return namaMakanan
     */
    public String getNamaMakanan() {
        return getNamaMakanan();
    }

    /**
     * setNamaMakanan
     * @param namaBaru
     */
    public void setNamaMakanan(String namaBaru) {
        namaMakanan = namaBaru ;
    }

    /**
     * getcountMakanan
     * @return countMakanan
     */
    public int getcountMakanan() {
        return getcountMakanan();
    }

    /**
     * setcountMakanan
     * @param countBaru
     */
    public void setcountMakanan(int countBaru) {
        countMakanan = countBaru ;
    }

    /**
     * getHargaSatuan
     * @return hargaSatuan
     */
    public double getHargaSatuan() {
        return getHargaSatuan();
    }

    /**
     * setHargaSatuan
     * @param hargaBaru
     */
    public void setHargaSatuan(double hargaBaru) {
        hargaSatuan = hargaBaru;
    }

    /**
     * increasecountMakanan
     * Menambahkan countMakanan pesanan
     * @param tambahan
     */
    public void increasecountMakanan(int tambahan) {
        if (tambahan > 0);
            countMakanan +=tambahan;
        // TODO: tambahkan nilai countMakanan dengan tambahan
        // Hint: hanya jika tambahan > 0
    }

    /**
     * decreasecountMakanan
     * Mengurangi countMakanan pesanan
     * @param pengurangan
     */
    public void decreasecountMakanan(int pengurangan) {
        if (pengurangan > 0);
            countMakanan -= pengurangan ;
        // Hint: hanya jika pengurangan > 0
    }

    /**
     * getTotalHarga
     * Menghitung total harga pesanan
     * @return totalHarga
     */
    public double getTotalHarga() {
        int getTotalHarga = countMakanan ;
        int totalHarga ;
        totalHarga = countMakanan ;
        return getTotalHarga();
    }
}