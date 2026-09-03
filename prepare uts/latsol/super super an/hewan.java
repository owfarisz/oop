public abstract class hewan{
    protected String nama;


    public hewan(String nama){
        this.nama = nama;
    }
    
    
    public abstract void suara();
        
    
    public void perkenalan(){
        System.out.println("Hai, aku " + nama);
    }
}


public class kucing extends hewan {
    public kucing(String nama){
        super(nama);
    }
    @Override
    public void suara(){
        System.out.println(nama + ": meong");

    }
}

public class anjing extends hewan{
    public anjing(String nama){
        super(nama);
    }
    @Override
    public void suara(){
        System.out.println(nama + ": guk guk");        
    }
}

public class Main {
    public static void main(String[] args) {
        hewan h1 = new kucing("Mimi");
        h1.perkenalan();
        h1.suara();
        hewan h2 = new anjing("Doggo");
        h2.perkenalan()
        h2.suara();
        
        }
        // TODO: Hewan h1 = new Kucing("Mimi");
        // TODO: Hewan h2 = new Anjing("Doggo");
        // TODO: panggil perkenalan() lalu suara() untuk masing-masing
    }

