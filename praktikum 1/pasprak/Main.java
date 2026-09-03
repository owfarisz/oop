public class Main {
    public static void main(String[] args) {
        OrderMakanan order = new OrderMakanan("Pisang Goreng", 3, 5000);
        Pembeli pembeli = new Pembeli("Toto", 7, 10000);

        System.out.println("Pesanan: " + order.getNamaMakanan());
        System.out.println("Jumlah: " + order.getcountMakanan());
        System.out.println("Total harga: " + order.getTotalHarga());
        System.out.println("Saldo pembeli: " + pembeli.getSaldo());
        System.out.println("Cukup bayar? " + pembeli.cekBisaBayar(order));
    }
}
