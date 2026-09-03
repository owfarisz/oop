// Interface untuk perangkat mobile
interface IMobileDevice extends IGadget {

  /**
   * Melakukan panggilan telepon
   * Menampilkan pesan "Calling [number] from [brand] [model]"
   * 
   * @param number
   */
  public void makeCall(String number);

  /**
   * Mengirim pesan
   * Menampilkan pesan "Sending message: [message]"
   *
   * @param message
   */
  public void sendMessage(String message);

  /**
   * Menghubungkan ke jaringan WiFi
   * Menampilkan pesan "Connected to [networkName]"
   *
   * @param networkName
   */
  public void connectToWifi(String networkName);
}
