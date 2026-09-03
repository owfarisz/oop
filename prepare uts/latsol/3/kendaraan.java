// Kendaraan.java
public class Kendaraan {
    protected String merk;
    void berjalan(){
        System.out.println(merk + " berjalan");
    }
    // TODO: atribut protected String merk
    // TODO: method berjalan() -> println: "<merk> bergerak"
}

// Mobil.java
public class Mobil extends Kendaraan {
    private int jumlahPintu;
    public Mobil (String merk, int jumlahPintu){
        this.jumlahPintu = jumlahPintu ;
        this.merk = merk;
    }
    public int getJumlahPintu(){
        return jumlahPintu;
    }
    public void setJumlahPintu(int jumlahPintu){
        this.jumlahPintu = jumlahPintu;
    }
    public void bukaPintu(){
        System.out.println("Membuka" + jumlahPintu + "pintu");
    }
    // TODO: atribut private int jumlahPintu
    // TODO: constructor untuk isi merk dan jumlahPintu (panggil setter/akses protected)
    // TODO: method bukaPintu() -> println: "Membuka <jumlahPintu> pintu"
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Mobil m = new Mobil("Toyota", 4);
        m.berjalan();
        m.bukaPintu();
        // TODO: buat Mobil m = new Mobil("Toyota", 4)
        // TODO: panggil m.berjalan(); m.bukaPintu();
    }
}

