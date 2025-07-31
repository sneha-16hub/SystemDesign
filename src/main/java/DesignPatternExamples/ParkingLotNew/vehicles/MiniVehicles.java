package DesignPatternExamples.ParkingLotNew.vehicles;

public class MiniVehicles extends Vehicle{
	public static final double RATE=10;

	public MiniVehicles(String liciencePlate) {
		super(liciencePlate, "Bike");
	}
	
	@Override
	public double calculateFee(int hrsStayed) {
		return RATE*hrsStayed;
	}
	

}
