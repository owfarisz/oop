class Player {
    // TODO: Deklarasikan atribut: username (String), avatar (Avatar), game (Game)
    String username;
    Avatar avatar;
    Game game;
    // TODO: Deklarasikan static int totalPlayer untuk menghitung total player
    // dibuat
    static int totalPlayer = 0;

    // TODO: Constructor set username dan avatar, dan increment totalPlayer
    Player(String username, Avatar avatar) {
        // HINT: this.username = username; dst.
        this.username = username;
        this.avatar = avatar;
        this.game = null;
        totalPlayer++;
    }

    // TODO: Method joinGame: set game ke g kemudian panggil g.joinGame(this)
    void joinGame(Game g) {
        this.game = g;
        g.joinGame(this);
    }

    // TODO: Tampilkan profil sesuai format:
    // Username: <username>.
    // Avatar: <namaSkin> (Lv.<level>).
    // Sedang bermain: <namaGame>.
    // ATAU jika belum gabung: Belum bergabung ke game.
    // Diakhiri 1 baris kosong
    void showProfile() {
        // HINT: Cek game == null
        System.out.println("Username: " + username + ".");
        System.out.println("Avatar: " + avatar.namaSkin + " (Lv." + avatar.level + ").");
        if (game == null) {
            System.out.println("Belum bergabung ke game.");
        } else {
            System.out.println("Sedang bermain: " + game.namaGame + ".");
        }
        System.out.println();
    }

    // TODO: Kembalikan totalPlayer
    static int getTotalPlayer() {
        return totalPlayer; // ganti dengan nilai dari totalPlayer
    }
}
