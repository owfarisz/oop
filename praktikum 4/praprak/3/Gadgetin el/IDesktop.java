// Interface untuk perangkat desktop
interface IDesktop extends IGadget {

  /**
   * Menginstal perangkat lunak pada desktop
   * Menampilkan pesan "Installing [softwareName] on [brand] [model]"
   * 
   * @param softwareName
   */
  public void installSoftware(String softwareName);

  /**
   * Membuka aplikasi pada desktop
   * Menampilkan pesan "Opening [appName]"
   *
   * @param appName
   */
  public void openApplication(String appName);

  /**
   * Mendapatkan sistem operasi desktop
   * 
   * @return sistem operasi
   */
  public String getOperatingSystem();
}