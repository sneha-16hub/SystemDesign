package NullObjectDesignPattern;

public class mainClass {

	public static void main(String[] args) {
		Vehicle vehicle=VehicleFactory.getVehicleObject("Car");
		printVehicleDetails(vehicle);
	}
	public static void printVehicleDetails(Vehicle vehicle) {
		
			System.out.println("Seating capacity "+ vehicle.getSeatCapacity());
			System.out.println("Tank Capacity "+ vehicle.getTankCapacity());
		
	}

}
