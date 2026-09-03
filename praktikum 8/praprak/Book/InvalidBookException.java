/* TODO: Lengkapi class InvalidBookException
   Exception ini dilempar ketika data buku tidak valid.
   Class ini extends LibraryException.

   Fields tambahan:
   - bookTitle (String): judul buku yang invalid
   - invalidField (String): field mana yang invalid (misalnya "title", "author", "isbn")
   - invalidValue (String): nilai yang invalid (optional)

   Constructors yang dibutuhkan:
   1. InvalidBookException(String message) - panggil super dengan errorCode "INVALID_BOOK"
   2. InvalidBookException(String message, Throwable cause) - untuk exception chaining
   3. InvalidBookException(String message, String bookTitle, String invalidField)
   4. InvalidBookException(String message, String bookTitle, String invalidField, String invalidValue)

   Methods:
   - getBookTitle(), getInvalidField(), getInvalidValue()
   - getMessage(): override untuk menambahkan informasi bookTitle, invalidField, dan invalidValue

   Format message: "[INVALID_BOOK] <message> (Book: '<bookTitle>', Invalid Field: <invalidField>, Value: '<invalidValue>')"
   Jika invalidValue null, jangan tampilkan bagian "Value: ..."
*/

public class InvalidBookException extends LibraryException {
    // TODO: Implementasi
    private final String bookTitle;
    private final String invalidField;
    private final String invalidValue;

    private static final String ERROR_CODE = "INVALID_BOOK";

    public InvalidBookException(String message) {
        super(message, ERROR_CODE);
        this.bookTitle = null;
        this.invalidField = null;
        this.invalidValue = null;
    }

    public InvalidBookException(String message, Throwable cause) {
        super(message, ERROR_CODE, cause);
        this.bookTitle = null;
        this.invalidField = null;
        this.invalidValue = null;
    }

    public InvalidBookException(String message, String bookTitle, String invalidField) {
        this(message, bookTitle, invalidField, null);
    }

    public InvalidBookException(String message, String bookTitle, String invalidField, String invalidValue) {
        super(message, ERROR_CODE);
        this.bookTitle = bookTitle;
        this.invalidField = invalidField;
        this.invalidValue = invalidValue;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getInvalidField() {
        return invalidField;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        if (bookTitle != null && invalidField != null) {
            String details = " (Book: '" + bookTitle + "', Invalid Field: " + invalidField;
            if (invalidValue != null) {
                details += ", Value: '" + invalidValue + "')";
            } else {
                details += ")";
            }
            return "[" + ERROR_CODE + "] " + super.getMessage().substring(ERROR_CODE.length() + 3) + details;
        }
        return baseMessage;
    }
}