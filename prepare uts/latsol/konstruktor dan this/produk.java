public class produk {
    String nama ;
    int harga;

    produk(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }
    void info(){
        System.out.println(nama + "-" + harga);
    }
}

public class Main{
    public static void main(String[] args){
        produk p = new produk("babi", 15);
        p.info();
    }
}