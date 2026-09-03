class Smartwatch implements IMobileDevice {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;

  /* Konstruktor */
  public Smartwatch(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.isOn = false;
    System.out.println("Smartwatch " + brand + " " + model + " created.");
  }

  /**
   * Melakukan panggilan telepon
   * Menampilkan pesan "Calling [number] from [brand] [model]"
   * 
   * @param number
   */
  @Override
  public void makeCall(String number) {
    System.out.println("Calling " + number + " from " + getBrand() + " " + this.model);
  }

  /**
   * Mengirim pesan
   * Menampilkan pesan "Sending message: [message]"
   *
   * @param message
   */
  @Override
  public void sendMessage(String message) {
    System.out.println("Sending message: " + message);
  }

  /**
   * Menghubungkan ke jaringan WiFi
   * Menampilkan pesan "Connected to [networkName]"
   *
   * @param networkName
   */
  @Override
  public void connectToWifi(String networkName) {
    System.out.println("Connected to " + networkName);
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