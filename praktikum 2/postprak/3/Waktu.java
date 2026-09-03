public class Waktu {
    private int hour;   // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone
    private static String DEFAULT_TZ = "WIB";

    // default constructor: 00:00
    public Waktu() {
        this.hour = 0;
        this.minute = 0;
    }

    // constructor (jam, menit) dengan pembatasan rentang
    public Waktu(int hour, int minute) {
        if (hour < 0) hour = 0;
        if (hour > 23) hour = 23;
        if (minute < 0) minute = 0;
        if (minute > 59) minute = 59;
        this.hour = hour;
        this.minute = minute;
    }

    // constructor dari total menit (dibatasi ke 0..1439)
    public Waktu(int totalMinutes) {
        if (totalMinutes < 0) totalMinutes = 0;
        if (totalMinutes > 23 * 60 + 59) totalMinutes = 23 * 60 + 59;
        this.hour = totalMinutes / 60;
        this.minute = totalMinutes % 60;
    }

    // Getter
    public int getHour()   { return hour; }
    public int getMinute() { return minute; }

    // ===== STATIC methods =====
    public static Waktu fromMinutes(int total) {
        return new Waktu(total);
    }

    public static int toMinutes(Waktu t) {
        if (t == null) return 0;
        return t.hour * 60 + t.minute;
    }

    public static Waktu addMinutes(Waktu t, int add) {
        if (t == null) return new Waktu(0, 0);
        int total = toMinutes(t) + add;
        // batasi ke 0..1439
        if (total < 0) total = 0;
        if (total > 23 * 60 + 59) total = 23 * 60 + 59;
        return new Waktu(total);
    }

    // ===== STATIC getter & setter untuk timezone =====
    public static String getDefaultTz() {
        return DEFAULT_TZ;
    }

    public static void setDefaultTz(String tz) {
        if (tz == null || tz.trim().isEmpty()) return;
        DEFAULT_TZ = tz;
    }

    // Helper format HH:MM
    private String format() {
        return String.format("%02d:%02d", hour, minute);
    }

    @Override
    public String toString() {
        // "HH:MM TZ"
        return format() + " " + DEFAULT_TZ;
    }
}
