/**
 * OperatingSystem.java
 * Kelas abstrak dasar untuk berbagai OS.
 *
 * Ketentuan:
 * - Semua atribut private dengan getter public.
 * - Method calculateCompatibility dan printInfo harus public.
 * - Method bantu clampScore dan getAdditionalInfo protected.
 * - baseScore diharapkan 0..100, tetapi hasil compatibility tetap dijaga dengan clampScore (0..100).
 */
public abstract class OperatingSystem {
    // ================== ATTRIBUTES (private) ==================
    private String name;
    private String version;
    private String kernelType;
    private double baseScore; // 0..100

    // ================== CONSTRUCTOR (public) ==================
    /**
     * @param name       nama OS (null/kosong -> "Unknown OS")
     * @param version    versi OS (null/kosong -> "Unknown Version")
     * @param kernelType tipe kernel (null/kosong -> "Unknown Kernel")
     * @param baseScore  skor dasar
     */
    public OperatingSystem(String name, String version, String kernelType, double baseScore) {
        this.name = (name == null || name.trim().isEmpty()) ? "Unknown OS" : name.trim();
        this.version = (version == null || version.trim().isEmpty()) ? "Unknown Version" : version.trim();
        this.kernelType = (kernelType == null || kernelType.trim().isEmpty()) ? "Unknown Kernel" : kernelType.trim();
        this.baseScore = baseScore;
    }

    // ================== ABSTRACT API (public) ==================
    public abstract double calculateCompatibility(UsageType usage);

    // ================== HELPERS (protected) ==================
    /**
     * Menjaga skor agar tetap pada rentang 0..100
     */
    protected double clampScore(double score) {
        if (score < 0.0) return 0.0;
        if (score > 100.0) return 100.0;
        return score;
    }

    /**
     * Informasi tambahan untuk ditampilkan pada printInfo().
     * Default: string kosong. Subclass dapat override untuk menambahkan.
     */
    protected String getAdditionalInfo() {
        return "";
    }

    // ================== GETTERS (public) ==================
    public String getName()       { return name; }
    public String getVersion()    { return version; }
    public String getKernelType() { return kernelType; }
    public double getBaseScore()  { return baseScore; }

    // ================== OUTPUT (public) ==================
    /**
     * Mencetak informasi OS dan nilai kompatibilitas.
     * Format:
     * Name: <name>
     * Version: <version>
     * Kernel Type: <kernelType>
     * {Additional Information jika ada}
     * Base Score: <baseScore dua desimal>
     * Compatibility for <usage.name()>: <nilai dua desimal>
     */
    public void printInfo(UsageType usage) {
        System.out.printf("Name: %s%n", getName());
        System.out.printf("Version: %s%n", getVersion());
        System.out.printf("Kernel Type: %s%n", getKernelType());

        String extra = getAdditionalInfo();
        if (extra != null && !extra.isEmpty()) {
            System.out.printf("%s%n", extra);
        }

        System.out.printf("Base Score: %.2f%n", getBaseScore());
        double comp = calculateCompatibility(usage);
        System.out.printf("Compatibility for %s: %.2f%n", usage.name(), comp);
    }
}
