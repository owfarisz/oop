/**
 * IAnimal.java
 *
 * Interface = kontrak perilaku. Semua hewan punya method sound().
 * Class yang implements wajib menyediakan implementasi method ini.
 *
 * TODO:
 * - Tambahkan method lain jika diperlukan (mis. move(), eat()).
 */
public interface IAnimal {
    /**
     * Mengembalikan suara khas hewan.
     * @return String suara hewan
     */
    String sound();
}
