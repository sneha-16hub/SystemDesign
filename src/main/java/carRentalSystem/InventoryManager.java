package carRentalSystem;

import java.util.List;

public class InventoryManager {
	List<Vehicle> vehicles;
	public InventoryManager(List<Vehicle> vehicles) {
		this.vehicles=vehicles;
	}
	void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	public List<Vehicle> getVehicles(){
		return vehicles;
	}
	
	

}
