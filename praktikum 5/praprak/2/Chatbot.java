public abstract class Chatbot {
    protected String name;
    protected int sessionCount = 0;

    public Chatbot(String name) {
        this.name = name;
    }

    public abstract void respond();

    public void startSession() {
        sessionCount++;
        System.out.println("Session started for " + name);
    }

    public abstract void displayInfo();

    public abstract String getBotType();

    public int getSessionCount() {
        return sessionCount;
    }
}