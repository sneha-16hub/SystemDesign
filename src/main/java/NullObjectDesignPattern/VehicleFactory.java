package NullObjectDesignPattern;

public class VehicleFactory {

	public static Vehicle getVehicleObject(String Vehicletype) {
		if(Vehicletype.equalsIgnoreCase("Car")) {
			return new Car();
		}
		return new NullVehicle();
	}

}
