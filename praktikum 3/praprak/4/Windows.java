/**
 * Windows.java
 * Subclass dari OperatingSystem.
 *
 * Multiplier:
 * - Jika edition == SERVER dan usage == SERVER: +30%
 * - Untuk GAMING: +20%
 * - Jika edition == HOME dan usage == SERVER: -5%
 */
public class Windows extends OperatingSystem {
    // Enum internal Edition
    public enum Edition { HOME, PRO, SERVER }

    // Atribut tambahan (private) + getter public
    private Edition edition;

    // Konstruktor public
    public Windows(String name, String version, String kernelType, double baseScore, Edition edition) {
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    public Edition getEdition() { return this.edition; }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;

        if (usage == UsageType.GAMING) {
            multiplier += 0.20;
        }
        if (edition == Edition.SERVER && usage == UsageType.SERVER) {
            multiplier += 0.30;
        }
        if (edition == Edition.HOME && usage == UsageType.SERVER) {
            multiplier += -0.05;
        }

        double score = base + (multiplier * base);
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Edition: " + this.edition.name();
    }
}
