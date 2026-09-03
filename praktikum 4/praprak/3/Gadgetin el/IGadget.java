// Interface dasar untuk semua gadget
interface IGadget {
  /**
   * Menghidupkan gadget
   * 
   * Mengubah status isOn menjadi true
   * 
   * Menampilkan pesan "[brand] [model] is now ON"
   */
  public void turnOn();

  /**
   * Mematikan gadget
   * 
   * Mengubah status isOn menjadi false
   * 
   * Menampilkan pesan "[brand] [model] is now OFF"
   */
  public void turnOff();

  /**
   * Mendapatkan informasi gadget
   * 
   * Jika gadget menyala, mengembalikan string dalam format:
   * "[ON] [brand] [model] - Rp [price]"
   * 
   * Jika gadget mati, mengembalikan string dalam format:
   * "[OFF] [brand] [model] - Rp [price]"
   */
  public String getInfo();

  /**
   * Mendapatkan harga gadget
   * 
   * @return harga gadget
   */
  public double getPrice();

  /**
   * Mendapatkan merek gadget
   * 
   * @return merek gadget
   */
  public String getBrand();
}
