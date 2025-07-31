package carRentalSystem;

public class car extends Vehicle{

	public car(VehicleType type, int capacity) {
		super(type, capacity);
	}

	@Override
	public int price() {
		
		return 100;
	}
	
}
