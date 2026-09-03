class Laptop implements IDesktop {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;
  private String operatingSystem;

  /* Konstruktor */
  public Laptop(String brand, String model, double price, String operatingSystem) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.operatingSystem = operatingSystem;
    this.isOn = false;
    System.out.println("Laptop " + brand + " " + model + " created.");
  }

    /**
   * Menginstal perangkat lunak pada desktop
   * Menampilkan pesan "Installing [softwareName] on [brand] [model]"
   * 
   * @param softwareName
   */
  @Override
  public void installSoftware(String softwareName) {
    System.out.println("Installing " + softwareName + " on " + getBrand() + " " + this.model);
  }

  /**
   * Membuka aplikasi pada desktop
   * Menampilkan pesan "Opening [appName]"
   *
   * @param appName
   */
  @Override
  public void openApplication(String appName) {
    System.out.println("Opening " + appName);
  }

  /**
   * Mendapatkan sistem operasi desktop
   * 
   * @return sistem operasi
   */
  @Override
  public String getOperatingSystem() {
    return this.operatingSystem;
  }

  /**
   * Menghidupkan gadget
   * 
   * Mengubah status isOn menjadi true
   * 
   * Menampilkan pesan "[brand] [model] is now ON"
   */
  @Override
  public void turnOn() {
    this.isOn = true;
    System.out.println(getBrand() + " " + this.model + " is now ON");
  }

  /**
   * Mematikan gadget
   * 
   * Mengubah status isOn menjadi false
   * 
   * Menampilkan pesan "[brand] [model] is now OFF"
   */
  @Override
  public void turnOff() {
    isOn = false;
    System.out.println(getBrand() + " " + this.model + " is now OFF");
  }

  /**
   * Mendapatkan informasi gadget
   * 
   * Jika gadget menyala, mengembalikan string dalam format:
   * "[ON] [brand] [model] - Rp [price]"
   * 
   * Jika gadget mati, mengembalikan string dalam format:
   * "[OFF] [brand] [model] - Rp [price]"
   */
  @Override
  public String getInfo() {
    if (this.isOn) {
      return "[ON] " + getBrand() + " " + this.model + " - Rp " + getPrice();
    } else {
      return "[OFF] " + getBrand() + " " + this.model + " - Rp " + getPrice();
    }
  }

  /**
   * Mendapatkan harga gadget
   * 
   * @return harga gadget
   */
  @Override
  public double getPrice() {
    return this.price;
  }

  /**
   * Mendapatkan merek gadget
   * 
   * @return merek gadget
   */
  @Override
  public String getBrand() {
    return this.brand;
  }
}