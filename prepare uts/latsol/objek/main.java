class lampu {
    boolean nyala = false ;
    void nyalain(){
        nyala = true ;
        System.out.println("lampu nyala");
    }
    void matiin(){
        nyala = false ;
        System.out.println("lampu mati");
    }
    void status(){
        if (nyala == true) {
            System.out.println("status : on");
        } else {
            System.out.println("status : off");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        lampu l = new lampu();
        l.status(); // manggil method yang ada disitu (disini kasusnya status) pada object l
        l.nyalain();
        l.status();
        l.matiin();
        l.status();
    }
}
