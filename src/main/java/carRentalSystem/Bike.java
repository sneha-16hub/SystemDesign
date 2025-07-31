package carRentalSystem;

public class Bike extends Vehicle{

	public Bike(VehicleType type, int capacity) {
		super(type, capacity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return 50;
	}

}
