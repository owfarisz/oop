import java.time.Year;

/* TODO: Lengkapi class Book dengan validasi ISBN dan exception handling

   Fields:
   - title (String)
   - author (String)
   - isbn (String): ISBN-10 atau ISBN-13
   - publicationYear (int)
   - copies (int): total copies
   - availableCopies (int): copies yang tersedia

   Constructor:
   - Book(String title, String author, String isbn, int publicationYear, int copies)
     throws InvalidBookException

     Validasi (throw InvalidBookException dengan bookTitle, invalidField, dan optional invalidValue):
     1. title tidak boleh null/kosong (trim)
     2. author tidak boleh null/kosong (trim)
     3. author harus minimal 2 kata (pisahkan dengan split("\\s+"))
     4. publicationYear harus antara 1000 dan tahun sekarang (gunakan java.time.Year.now().getValue())
     5. copies tidak boleh negatif
     6. ISBN harus valid (panggil isValidISBN)

     Jika semua valid:
     - Set semua fields (trim untuk String)
     - Set availableCopies = copies

   Private Helper Methods untuk ISBN Validation:

   - boolean isValidISBN(String isbn)
     * Return false jika isbn null
     * Remove hyphens dan spaces: cleanISBN = isbn.replaceAll("[\\s-]", "")
     * Jika length 10: return isValidISBN10(cleanISBN)
     * Jika length 13: return isValidISBN13(cleanISBN)
     * Otherwise: return false

   - boolean isValidISBN10(String isbn)
     * ISBN-10 checksum algorithm:
       - Sum = (digit1 * 10) + (digit2 * 9) + ... + (digit9 * 2) + check_digit
       - Check digit bisa 'X' (nilai 10) atau digit 0-9
       - Valid jika Sum % 11 == 0
     * Gunakan try-catch untuk handle exceptions, return false jika error

   - boolean isValidISBN13(String isbn)
     * ISBN-13 checksum algorithm:
       - Sum = digit1 + (digit2 * 3) + digit3 + (digit4 * 3) + ... + digit13
       - Digit ganjil (index 0,2,4...) * 1, digit genap (index 1,3,5...) * 3
       - Valid jika Sum % 10 == 0
     * Gunakan try-catch, return false jika error

   Public Methods:

   - getters untuk semua fields (getTitle, getAuthor, getIsbn, getPublicationYear, getCopies, getAvailableCopies)

   - void borrowBook() throws BookNotAvailableException
     * Jika availableCopies <= 0: throw BookNotAvailableException dengan detail (title, requestedCopies=1, availableCopies)
     * Kurangi availableCopies

   - void returnBook() throws InvalidBookException
     * Jika availableCopies >= copies: throw InvalidBookException
     * Tambah availableCopies

   - toString(): return format string
     * Format EXACT (abaikan simbol <>): "<title> by <author> (<year>) [ISBN: <isbn>] - Available: <avail>/<total>"
     * <title> = judul buku
     * <author> = nama penulis
     * <year> = tahun publikasi
     * <isbn> = ISBN (dengan hyphens/spaces seperti input asli)
     * <avail> = availableCopies
     * <total> = copies
     * Contoh: "Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/5"
     * Contoh: "Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2"
*/

public class Book {
    // TODO: Declare fields
    private final String title;
    private final String author;
    private final String isbn;
    private final int publicationYear;
    private final int copies;
    private int availableCopies;

    // TODO: Implement constructor dengan validasi lengkap
    public Book(String title, String author, String isbn, int publicationYear, int copies)
            throws InvalidBookException {

        // 1. title tidak boleh null/kosong (trim)
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidBookException("Judul buku tidak boleh kosong.", title, "title");
        }
        String trimmedTitle = title.trim();

        // 2. author tidak boleh null/kosong (trim)
        if (author == null || author.trim().isEmpty()) {
            throw new InvalidBookException("Nama penulis tidak boleh kosong.", trimmedTitle, "author");
        }
        String trimmedAuthor = author.trim();

        // 3. author harus minimal 2 kata
        if (trimmedAuthor.split("\\s+").length < 2) {
            throw new InvalidBookException("Nama penulis harus minimal 2 kata.", trimmedTitle, "author", trimmedAuthor);
        }

        // 4. publicationYear harus antara 1000 dan tahun sekarang
        int currentYear = Year.now().getValue();
        if (publicationYear < 1000 || publicationYear > currentYear) {
            throw new InvalidBookException("Tahun publikasi tidak valid.", trimmedTitle, "publicationYear", String.valueOf(publicationYear));
        }

        // 5. copies tidak boleh negatif
        if (copies < 0) {
            throw new InvalidBookException("Jumlah copies tidak boleh negatif.", trimmedTitle, "copies", String.valueOf(copies));
        }

        // 6. ISBN harus valid
        if (isbn == null || !isValidISBN(isbn)) {
            throw new InvalidBookException("ISBN tidak valid.", trimmedTitle, "isbn", isbn);
        }
        String originalIsbn = isbn; // Simpan ISBN asli untuk toString

        this.title = trimmedTitle;
        this.author = trimmedAuthor;
        this.isbn = originalIsbn;
        this.publicationYear = publicationYear;
        this.copies = copies;
        this.availableCopies = copies;
    }

    // TODO: Implement private helper methods untuk ISBN validation
    private boolean isValidISBN(String isbn) {
        if (isbn == null) {
            return false;
        }
        String cleanISBN = isbn.replaceAll("[\\s-]", "");
        if (cleanISBN.length() == 10) {
            return isValidISBN10(cleanISBN);
        } else if (cleanISBN.length() == 13) {
            return isValidISBN13(cleanISBN);
        }
        return false;
    }

    private boolean isValidISBN10(String isbn) {
        if (isbn.length() != 10) return false;
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                sum += (digit * (10 - i));
            }

            char checkChar = isbn.charAt(9);
            int checkDigit;
            if (checkChar == 'X' || checkChar == 'x') {
                checkDigit = 10;
            } else {
                checkDigit = Integer.parseInt(isbn.substring(9));
            }
            sum += checkDigit;

            return sum % 11 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidISBN13(String isbn) {
        if (isbn.length() != 13) return false;
        try {
            int sum = 0;
            for (int i = 0; i < 13; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                if (i % 2 == 0) { // Index ganjil (posisi 1, 3, 5, ...) -> kali 1
                    sum += digit;
                } else { // Index genap (posisi 2, 4, 6, ...) -> kali 3
                    sum += (digit * 3);
                }
            }
            return sum % 10 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // TODO: Implement getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getCopies() {
        return copies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // TODO: Implement borrowBook()
    public void borrowBook() throws BookNotAvailableException {
        if (availableCopies <= 0) {
            throw new BookNotAvailableException("Tidak ada salinan buku yang tersedia untuk dipinjam.",
                    title, 1, availableCopies);
        }
        availableCopies--;
    }

    // TODO: Implement returnBook()
    public void returnBook() throws InvalidBookException {
        if (availableCopies >= copies) {
            throw new InvalidBookException("Jumlah salinan yang dikembalikan melebihi total salinan.",
                    title, "availableCopies", String.valueOf(availableCopies));
        }
        availableCopies++;
    }

    // TODO: Implement toString()
    @Override
    public String toString() {
        return String.format("%s by %s (%d) [ISBN: %s] - Available: %d/%d",
                title, author, publicationYear, isbn, availableCopies, copies);
    }
}