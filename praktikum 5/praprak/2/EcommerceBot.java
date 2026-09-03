public class EcommerceBot extends CustomerServiceBot {
    private String platform;

    public EcommerceBot(String name, String platform) {
        super(name);
        this.platform = platform;
    }

    @Override
    public void respond() {
        System.out.println("Ecommerce bot " + name + " dari " + platform + " siap melayani Anda");
    }

    @Override
    public void displayInfo() {
        System.out.println("Ecommerce Bot " + name + " dari " + platform + " telah melayani " + sessionCount + " sesi");
    }

    public void processOrder(String item) {
        System.out.println("Memproses pesanan: " + item + " dari " + platform);
    }

    @Override
    public String getBotType() {
        return "Ecommerce Bot";
    }
}