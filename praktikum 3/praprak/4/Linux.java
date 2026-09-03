/**
 * Linux.java
 * Subclass dari OperatingSystem.
 *
 * Multiplier:
 * - SERVER: +20%
 * - DEVELOPMENT: +10%
 * - GAMING: -15%
 */
public class Linux extends OperatingSystem {
    // Enum internal Distro
    public enum Distro { UBUNTU, FEDORA, ARCH, DEBIAN }

    // Atribut tambahan (private) + getter public
    private Distro distroType;

    // Konstruktor public
    public Linux(String name, String version, String kernelType, double baseScore, Distro distroType) {
        super(name, version, kernelType, baseScore);
        this.distroType = (distroType == null) ? Distro.UBUNTU : distroType;
    }

    public Distro getDistroType() { return this.distroType; }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;
        if (usage == UsageType.SERVER) {
            multiplier += 0.20;
        } else if (usage == UsageType.DEVELOPMENT) {
            multiplier += 0.10;
        } else if (usage == UsageType.GAMING) {
            multiplier += -0.15;
        }
        double score = base + (multiplier * base);
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Distribution: " + this.distroType.name();
    }
}
