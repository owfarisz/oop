public class DataPribadi {
    private static String DEFAULT_NAMA = "Unknown" ;
    private static int DEFAULT_UMUR = 0 ;
    private static String DEFAULT_ALAMAT = "Unknown" ;

    private String nama;
    private int umur;
    private String alamat;

    // TODO 1: Buat default constructor yang memanggil parameterized constructor dengan nilai default
    // Petunjuk: Gunakan this(DEFAULT_NAMA, DEFAULT_UMUR, DEFAULT_ALAMAT);
    public DataPribadi() {
         this(DEFAULT_NAMA, DEFAULT_UMUR, DEFAULT_ALAMAT);
    }

    // TODO 2: Buat parameterized constructor yang menerima nama, umur, dan alamat
    // yang kiri field, yang kanan nilai input.
    // this.nama = nama ;
    public DataPribadi(String nama, int umur, String alamat) {
        this.nama = nama ;
        this.umur = umur ;
        this.alamat = alamat ;
    }

    // TODO 3: Buat method getter untuk semua atribut
    public String getNama() {
        return nama ;
    }

    public int getUmur() {
        return umur;

    }

    public String getAlamat() {
        return alamat ;
    }

    // TODO 4: Override method toString() untuk mengembalikan "nama (umur tahun)"
    // Contoh: "Dr. Budi (35 tahun)"
    //Aturannya: toString() wajib mengembalikan String, nggak boleh langsung nge-print. 
    // %s = string
    // %d = angka (int)
    public String toString() {
         return String.format("%s (%d tahun)", nama, umur);

    }
}