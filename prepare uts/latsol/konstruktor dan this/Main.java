class buku{
    String judul ;
    int harga;

    buku(String judul, int harga){
        this.judul = judul;
        this.harga = harga;
    }
    void info(){
        System.out.println(judul + "-"+ harga);
    }    
}
public class Main{
    public static void main(String[] args){
        buku b = new buku("bumi", 85 );
        b.info();
    }
}