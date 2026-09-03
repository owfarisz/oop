import java.util.ArrayList;

public class TransportSystem {
    private String name;
    private ArrayList<Vehicle> vehicles;

    public TransportSystem(String name) {
  	/**
	 * TODO: Buatlah konstruktor untuk sistem transportasi
	 * */ 
        this.name = name;
        this.vehicles  = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
       	/**
	 * TODO: Fungsinya untuk menambahkan objek kendaraan ke list kendaraan 
	 * */ 
        this.vehicles.add(vehicle);
    }

    public Vehicle findVehicleByDriver(String driverName) {
	/**
	 * TODO: Fungsi untuk mencari kendaraan berdasarkan nama dari driver, 
	 * kembalikan nulljika tidak ditemukan
	 * */
        for (Vehicle v : vehicles) {
            if (v.getDriver() != null && v.getDriver().getName().equals(driverName)) {
                return v;
            }
        }
        return null;
    }

    public int totalPassengerCapacity() {
	/**
	 * TODO: Menghitung seluruh kapasitas yang tersedia
	 * */	
        int sum = 0;
        for (Vehicle v : vehicles) {
            sum += v.getCapacity();
        }
        return sum;
    }

    public void showAllVehicles() {
        /**
	 * TODO: Menampilkan seluruh info kendaraan dengan format
	 * 	"=== Transport System: {name} ===
	 * 	{info vehicles}
	 *	-------------------
	 *	{info vehicles}
	 *	-------------------
	 *	...
	 *	"
	 *	Baris terakhir disertai garis juga yah.
	 *	jika kendaraan kosong, keluarkan "No vehicles in the system
	 * */
        System.out.println("=== Transport System: " + name + " ===");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system");
            return;
        }
        for (Vehicle v : vehicles) {
            v.showInfo();
            System.out.println("-------------------");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
