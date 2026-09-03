import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= N; i++) {
            // data Pembeli
            String namaPembeli = sc.nextLine();                       // bisa mengandung spasi
            int nomorMeja = Integer.parseInt(sc.nextLine().trim());
            double saldo = Double.parseDouble(sc.nextLine().trim());

            // data Order
            String namaMakanan = sc.nextLine();                       // bisa mengandung spasi
            int jumlah = Integer.parseInt(sc.nextLine().trim());
            double hargaSatuan = Double.parseDouble(sc.nextLine().trim());

            // objek
            Pembeli pembeli = new Pembeli(namaPembeli, nomorMeja, saldo);
            OrderMakanan order = new OrderMakanan(namaMakanan, jumlah, hargaSatuan);

            boolean bisa = pembeli.cekBisaBayar(order);
            if (bisa) {
                // kurangi saldo sebesar total harga
                pembeli.setSaldo(pembeli.getSaldo() - order.getTotalHarga());
            }

            // output sesuai contoh
            System.out.println("=== Pembeli " + i + " ===");
            System.out.println("Nama: " + pembeli.getNamaPembeli() + " (Meja " + pembeli.getNomorMeja() + ")");
            System.out.println("Pesanan: " + order.getNamaMakanan() + " x " + order.getcountMakanan() + " @ " + order.getHargaSatuan());
            System.out.println("Total: " + order.getTotalHarga());
            System.out.println("Bisa Bayar: " + (bisa ? "Bisa" : "Gak Bisa"));
            if (bisa) {
                System.out.println("Saldo setelah bayar: " + pembeli.getSaldo());
            }
            System.out.println(); // endline kosong setelah setiap pembeli (termasuk yang terakhir)
        }

        sc.close();
    }
}
