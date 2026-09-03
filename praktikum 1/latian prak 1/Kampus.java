class Mahasiswa {
    String nama;
    int nim;

    Mahasiswa(String nama, int nim) {
        this.nama = nama;
        this.nim = nim;
    }

    void tampilkanInfo() {
        System.out.println("Mahasiswa: " + nama + " (NIM: " + nim + ")");
    }
}

class Dosen {
    String nama;
    String mataKuliah;

    Dosen(String nama, String mataKuliah) {
        this.nama = nama;
        this.mataKuliah = mataKuliah;
    }

    void tampilkanInfo() {
        System.out.println("Dosen: " + nama + " - " + mataKuliah);
    }
}

public class Kampus {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Andi", 12345);
        Dosen d1 = new Dosen("Bu Sari", "Pemrograman Java");

        m1.tampilkanInfo();
        d1.tampilkanInfo();
    }
}
