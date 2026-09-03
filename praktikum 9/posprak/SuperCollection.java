import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection (List<Integer> collection) {
        this.collection = collection;
    }

    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    //
    // HINT:
    // - Perlu membuat struktur data untuk menampung dua kelompok element
    // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan
    public List<List<Integer>> partitionByCondition (int threshold) {
        List<Integer> index0 = new ArrayList<>();
        List<Integer> index1 = new ArrayList<>();

        for (Integer element : collection) {
            if (element <= threshold) {
                index0.add(element);
            } else {
                index1.add(element);
            }
        }

        List<List<Integer>> partitioned = new ArrayList<>();
        partitioned.add(index0);
        partitioned.add(index1);
        return partitioned;
    }

    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna
    public List<Integer> findTopN(int n) {
        List<Integer> temp = new ArrayList<>(collection);
        Collections.sort(temp, (e1, e2) -> Integer.compare(e2, e1));

        List<Integer> top = new ArrayList<>();

        int limit = Math.min(n, temp.size());
        for (int i = 0; i < n; i++) {
            top.add(temp.get(i));
        }
        
        return top;
    }

    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut
    public List<Integer> runningSum () {
        List<Integer> runSum = new ArrayList<Integer>();
        int sum = 0;
        for (Integer element : collection) {
            sum += element;
            runSum.add(sum);
        }

        return runSum;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil kalian
    public List<String> findPairsWithSum (int targetSum) {
        List<String> pairs = new ArrayList<>();
        TreeSet<String> pairTree = new TreeSet<>();
        for (int i = 0; i < collection.size(); i++) {
            for (int j = i + 1; j < collection.size(); j++) {
                int a = collection.get(i);
                int b = collection.get(j);
                if (a + b == targetSum) {
                    if (a > b) {
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    pairTree.add(String.format("%d+%d=%d", a, b, targetSum));
                }
            }
        }
        pairs.addAll(pairTree);
        return pairs;
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    //
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value, frequency)
    // - Untuk sorting custom, gunakan Comparator
    public List<Integer> getMostFrequentElements (int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer value : collection) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList, (e1, e2) -> {
            int freqCompare = Integer.compare(e2.getValue(), e1.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            return Integer.compare(e2.getKey(), e1.getKey());
        });

        List<Integer> frequent = new ArrayList<>();
        for (int i = 0; i < Math.min(n, entryList.size()); i++) {
            frequent.add(entryList.get(i).getKey());
        }

        return frequent;
    }

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection() {
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection) {
        collection = newCollection;
    }
}