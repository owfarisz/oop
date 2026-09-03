public class MathTutorBot extends EducationalBot {
    private String subject;

    public MathTutorBot(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void respond() {
        System.out.println("Math tutor bot " + name + " untuk subject " + subject + " siap membantu");
    }

    @Override
    public void displayInfo() {
        System.out.println("Math Tutor Bot " + name + " untuk subject " + subject + " telah melayani " + sessionCount + " sesi");
    }

    public void solveProblem(String problem) {
        System.out.println("Menyelesaikan soal " + subject + ": " + problem);
    }

    @Override
    public String getBotType() {
        return "Math Tutor Bot";
    }
}