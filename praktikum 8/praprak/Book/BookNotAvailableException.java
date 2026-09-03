/* TODO: Lengkapi class BookNotAvailableException
   Exception ini dilempar ketika buku tidak tersedia untuk dipinjam.
   Class ini extends LibraryException.

   Fields tambahan:
   - bookTitle (String): judul buku
   - requestedCopies (int): jumlah copy yang diminta
   - availableCopies (int): jumlah copy yang tersedia

   Constructors:
   1. BookNotAvailableException(String message) - dengan errorCode "BOOK_NOT_AVAILABLE"
   2. BookNotAvailableException(String message, String bookTitle, int requestedCopies, int availableCopies)

   Methods:
   - getBookTitle(), getRequestedCopies(), getAvailableCopies()
   - getMessage(): format "[BOOK_NOT_AVAILABLE] <message> (Book: '<title>', Requested: <n>, Available: <m>)"
*/

public class BookNotAvailableException extends LibraryException {
    // TODO: Implementasi
    private final String bookTitle;
    private final int requestedCopies;
    private final int availableCopies;

    private static final String ERROR_CODE = "BOOK_NOT_AVAILABLE";

    public BookNotAvailableException(String message) {
        super(message, ERROR_CODE);
        this.bookTitle = null;
        this.requestedCopies = 0;
        this.availableCopies = 0;
    }

    public BookNotAvailableException(String message, String bookTitle, int requestedCopies, int availableCopies) {
        super(message, ERROR_CODE);
        this.bookTitle = bookTitle;
        this.requestedCopies = requestedCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getRequestedCopies() {
        return requestedCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        if (bookTitle != null) {
            String details = String.format(" (Book: '%s', Requested: %d, Available: %d)",
                    bookTitle, requestedCopies, availableCopies);
            return "[" + ERROR_CODE + "] " + super.getMessage().substring(ERROR_CODE.length() + 3) + details;
        }
        return baseMessage;
    }
}