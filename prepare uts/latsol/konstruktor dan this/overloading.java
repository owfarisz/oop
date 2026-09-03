public class produk {
    String nama ;
    int harga;

    produk(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }
    produk(String nama){
        this.harga = 0;
        this.nama = nama;
    }
    void info(){
        System.out.println(nama + "-" + harga);
    }
}

public class Main{
    public static void main(String[] args){
        produk p1 = new produk("babi", 15);
        p1.info();
        produk p2 = new produk("nabil");
        p2.info();
    }
}

