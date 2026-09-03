// Registration.java
public class Registration {

    public Student registerStudent(String name, int age, String password)
            throws InvalidNameException, InvalidAgeException, WeakPasswordException {

        validateName(name);
        validateAge(age);
        validatePassword(password);

        return new Student(name, age, password);
    }

    private void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 3) {
            throw new InvalidNameException("Nama harus minimal 3 karakter!");
        }
        // kalau tidak diminta, baris ini bisa dihapus
        // if (!name.trim().matches("^[A-Za-z ]+$")) {
        //     throw new InvalidNameException("Nama harus minimal 3 karakter!");
        // }
    }

    private void validateAge(int age) throws InvalidAgeException {
        if (age < 13) {
            throw new InvalidAgeException("Umur harus minimal 13 tahun!");
        }
    }

    private void validatePassword(String password) throws WeakPasswordException {
        if (password == null || password.trim().length() < 6 || !password.trim().matches(".*\\d.*")) {
            throw new WeakPasswordException("Password harus minimal 6 karakter dan mengandung angka!");
        }
    }
}
