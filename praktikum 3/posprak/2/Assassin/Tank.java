public class Tank extends Hero {
    // TODO: Buat atribut: int armor, int shield
    private int armor;
    private int shield;

    // TODO: Buat constructor yang menerima name, hp, attackPower, armor, shield
    // Gunakan super() untuk panggil constructor parent dengan role "Tank"
    public Tank(String name, int hp, int attackPower, int armor, int shield) {
        super(name, hp, attackPower, "Tank");
        this.armor = armor;
        this.shield = shield;
    }

    // TODO: Override method specialSkill()
    // Tank menggunakan "Shield Wall", tampilkan format:
    // "<name> activates Shield Wall! Shield: <shield>"
    // Contoh: "Tigreal activates Shield Wall! Shield: 100"
    @Override
    public void specialSkill() {
        System.out.println(getName() + " activates Shield Wall! Shield: " + this.shield);
    }
        

    // TODO: Buat method levelUp() yang override parent
    // Panggil super.levelUp() dulu, lalu tambah armor +5, shield +30, hp bonus +30
    // Tampilkan pesan bonus: "Bonus Tank: +5 armor, +30 shield, +30 bonus HP!"
    @Override
    public void levelUp() {
        super.levelUp();
        this.armor += 5;
        this.shield += 30;
        setHp(getHp() + 30);
        System.out.println("Bonus Tank: +5 armor, +30 shield, +30 bonus HP!");
    }

    // TODO: Buat method taunt() untuk menarik perhatian musuh
    // Format: "<name> berteriak dan menarik perhatian semua musuh! Armor: <armor>"
    // Contoh: "Tigreal berteriak dan menarik perhatian semua musuh! Armor: 25"
    public void taunt() {
        System.out.println(getName() + " berteriak dan menarik perhatian semua musuh! Armor: " + this.armor);
    }

    // TODO: Buat method takeDamage(int damage)
    // Armor mengurangi damage terlebih dahulu, lalu shield menyerap sisa damage
    // Format: "<name> menerima <effectiveDamage> damage! HP: <hp>, Shield: <shield>"
    // Contoh: "Tigreal menerima 35 damage! HP: 415, Shield: 55"
    public void takeDamage(int damage) {
        int afterArmor = damage - this.armor;
        if (afterArmor < 0) {
            afterArmor = 0;

        }
        
        int damageToShield;
        int damageToHp;

        if (this.shield >= afterArmor) {
            damageToShield = afterArmor;
            damageToHp = 0;
        } else {
            damageToShield = this.shield;
            damageToHp = afterArmor - this.shield;
        }

    this.shield -= damageToShield;
    setHp(getHp() - damageToHp);

    System.out.println(getName() + " menerima " + afterArmor + " damage! HP: " + getHp() + ", Shield: " + this.shield);
}

    // TODO: Buat getter dan setter untuk armor dan shield
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}