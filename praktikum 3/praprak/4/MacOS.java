/**
 * MacOS.java
 * Subclass dari OperatingSystem.
 *
 * Multiplier:
 * - DEVELOPMENT: +25%
 * - GAMING: -20%
 * - hasMSeriesChip == true: +10% (tambahan)
 */
public class MacOS extends OperatingSystem {
    private boolean hasMSeriesChip;

    public MacOS(String name, String version, String kernelType, double baseScore, boolean hasMSeriesChip) {
        super(name, version, kernelType, baseScore);
        this.hasMSeriesChip = hasMSeriesChip;
    }

    public boolean hasMSeriesChip() { return this.hasMSeriesChip; }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double multiplier = 0.0;
        if (usage == UsageType.DEVELOPMENT) {
            multiplier += 0.25;
        } else if (usage == UsageType.GAMING) {
            multiplier += -0.20;
        }
        if (hasMSeriesChip) {
            multiplier += 0.10;
        }
        double score = base + (multiplier * base);
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Has M-Series Chip: " + (hasMSeriesChip ? "Yes" : "No");
    }
}
