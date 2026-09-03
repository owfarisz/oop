public class Event {
    private String title;
    private Waktu start; // komposisi
    private Waktu end;   // komposisi

    // total event
    private static int totalEvents = 0;

    public static int getTotalEvents() {
        return totalEvents;
    }

    // ========== CONSTRUCTORS (OVERLOADING) ==========

    // default
    public Event() {
        this.title = "Untitled";
        this.start = new Waktu(0, 0);
        this.end   = new Waktu(0, 0);
        totalEvents++;
    }

    // title, start, end (copy objek waktu)
    public Event(String title, Waktu start, Waktu end) {
        if (title == null || title.trim().isEmpty()) title = "Untitled";
        this.title = title;

        if (start == null) start = new Waktu(0, 0);
        if (end   == null) end   = new Waktu(0, 0);

        // salin (hindari referensi langsung)
        this.start = new Waktu(Waktu.toMinutes(start));
        this.end   = new Waktu(Waktu.toMinutes(end));

        totalEvents++;
    }

    // title, sh, sm, eh, em
    public Event(String title, int sh, int sm, int eh, int em) {
        if (title == null || title.trim().isEmpty()) title = "Untitled";
        this.title = title;
        this.start = new Waktu(sh, sm);
        this.end   = new Waktu(eh, em);
        totalEvents++;
    }

    // title, start, duration (menit)
    public Event(String title, Waktu start, int durationMin) {
        if (title == null || title.trim().isEmpty()) title = "Untitled";
        this.title = title;

        if (start == null) start = new Waktu(0, 0);
        // simpan salinan start
        this.start = new Waktu(Waktu.toMinutes(start));
        // end = start + duration
        this.end = Waktu.addMinutes(this.start, durationMin);

        totalEvents++;
    }

    // Getter (kembalikan salinan untuk start & end)
    public String getTitle() { return title; }
    public Waktu getStart()  { return new Waktu(Waktu.toMinutes(start)); }
    public Waktu getEnd()    { return new Waktu(Waktu.toMinutes(end)); }

    // cek overlap (pakai menit, asumsi [start, end) )
    public static boolean isOverlap(Event a, Event b) {
        if (a == null || b == null) return false;
        int aStart = Waktu.toMinutes(a.start);
        int aEnd   = Waktu.toMinutes(a.end);
        int bStart = Waktu.toMinutes(b.start);
        int bEnd   = Waktu.toMinutes(b.end);
        return (aStart < bEnd) && (bStart < aEnd);
    }

    @Override
    public String toString() {
        // "Judul [start-end] (tz: WIB)"
        String tz = Waktu.getDefaultTz();
        return title + " [" + start.toString() + "-" + end.toString() + "] (tz: " + tz + ")";
    }
}
