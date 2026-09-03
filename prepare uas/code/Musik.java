import java.util.ArrayList; // Jangan lupa import!
import java.util.List;

public class Musik { // Nama class biasakan Huruf Besar
    public static void main(String[] args) {
        List<String> lagu = new ArrayList<>();

        // 1. Tambah Data
        lagu.add("lalalosu");
        lagu.add("jebe");
        lagu.add("letgo");

        // 2. Hapus index 1 ("jebe" hilang)
        lagu.remove(1); // Jangan lupa titik koma ;

        // 3. Tambah di awal (Index 0)
        lagu.add(0, "mac");

        // --- LOOPING FOR-EACH (Cara Print yang Elegan) ---
        // Bacanya: "Untuk setiap 'judul' yang ada di dalam list 'lagu'..."
        System.out.println("=== DAFTAR LAGU ===");
        for (String judul : lagu) {
            System.out.println("Memutar: " + judul);
        }

        // --- CONTOH JAWABAN PERTANYAANMU ---
        // lagu.get("letgo"); // <--- INI ERROR!
        
        // Yang benar: Cari posisinya dulu
        int posisi = lagu.indexOf("letgo");
        System.out.println("Lagu 'letgo' ada di urutan: " + posisi);
    }
}