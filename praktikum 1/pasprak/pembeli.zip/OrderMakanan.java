public class OrderMakanan {
    private String namaMakanan;
    private int countMakanan;
    private double hargaSatuan;

    public OrderMakanan(String nama, int count, double harga) {
        this.namaMakanan = nama;
        this.countMakanan = Math.max(0, count);
        this.hargaSatuan = Math.max(0.0, harga);
    }

    public String getNamaMakanan() {
        return this.namaMakanan;
    }

    public void setNamaMakanan(String namaBaru) {
        this.namaMakanan = namaBaru;
    }

    public int getcountMakanan() {
        return this.countMakanan;
    }

    public void setcountMakanan(int countBaru) {
        if (countBaru >= 0) this.countMakanan = countBaru;
    }

    public double getHargaSatuan() {
        return this.hargaSatuan;
    }

    public void setHargaSatuan(double hargaBaru) {
        if (hargaBaru >= 0.0) this.hargaSatuan = hargaBaru;
    }

    public void increasecountMakanan(int tambahan) {
        if (tambahan > 0) this.countMakanan += tambahan;
    }

    public void decreasecountMakanan(int pengurangan) {
        if (pengurangan > 0) this.countMakanan = Math.max(0, this.countMakanan - pengurangan);
    }

    public double getTotalHarga() {
        return this.countMakanan * this.hargaSatuan;
    }
}
