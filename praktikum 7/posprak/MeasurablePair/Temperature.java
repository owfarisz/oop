// TODO:
// Lengkapi parameter generik dari kelas ini. 
// Perhatikan bahwa objek ini hanya bisa dibandingkan dengan objek Temperature lain
public final class Temperature implements Comparable<Temperature> {
    private final double celsius;
    // TODO:
    // 1. Implementasikan fungsi compareTo untuk membandingkan nilai temperatur objek ini dengan objek lain.
    //    Gunakan Double.compare(<Temperature objek ini> , <Temperature objek lain>) untuk mendapatkan hasil perbandingan.
    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    @Override
    public int compareTo(Temperature other) {
        if (celsius < other.celsius) {
            return -1;
        }
        if (celsius > other.celsius) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return celsius + " C";
    }
}
