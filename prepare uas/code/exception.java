public class Main { // Nama class huruf besar
    
    // Method main langsung jalan, gak perlu bikin method 'forloop' lagi di dalamnya
    public static void main(String[] args) { 
        
        String[] dataInput = { "10", "0", "lima", "20" };

        System.out.println("=== MULAI PROSES ===");

        // Loop dari 0 sampai 6 (Sengaja kita bikin kebablasan index-nya)
        for (int i = 0; i < 7; i++) {
            
            // TRY ADA DI DALAM LOOP
            // Supaya kalau i=1 error, i=2 tetap jalan.
            try {
                // JEBAKAN 1: Index Array Habis
                // Kalau i sudah 4, 5, 6, baris ini akan melempar ArrayIndexOutOfBounds
                String teks = dataInput[i]; 

                // JEBAKAN 2: Konversi Teks ke Angka
                // Kalau teks = "lima", baris ini melempar NumberFormatException
                int angka = Integer.parseInt(teks); 

                // JEBAKAN 3: Pembagian
                // Kalau angka = 0, baris ini melempar ArithmeticException
                int hasil = 100 / angka;

                System.out.println("Index " + i + ": Berhasil -> " + hasil);

            } catch (ArithmeticException e) {
                // Menangkap error bagi nol
                System.out.println("Index " + i + ": Gak bisa bagi nol cuy!");

            } catch (NumberFormatException e) {
                // Menangkap error teks "lima"
                System.out.println("Index " + i + ": Input bukan angka! (" + dataInput[i] + ")");

            } catch (ArrayIndexOutOfBoundsException e) {
                // Menangkap error index kelewat (4, 5, 6)
                System.out.println("Index " + i + ": Datanya habis!");
            }
        }
        
        System.out.println("=== SELESAI ===");
    }
}