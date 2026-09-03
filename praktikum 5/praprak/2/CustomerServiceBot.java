public class CustomerServiceBot extends Chatbot {
    public CustomerServiceBot(String name) {
        super(name);
    }

    @Override
    public void respond() {
        System.out.println("Customer service bot " + name + " siap melayani Anda");
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Service Bot " + name + " telah melayani " + sessionCount + " sesi");
    }

    public void handleComplaint(String complaint) {
        System.out.println("Menangani keluhan: " + complaint);
    }

    @Override
    public String getBotType() {
        return "Customer Service Bot";
    }
}