package DesignPatternExamples.ParkingLotNew.vehicles;

public class LargeVehicle extends Vehicle{
	public static final double RATE=50;

	public LargeVehicle(String liciencePlate) {
		super(liciencePlate,"Car");
	}
	
	@Override
	public double calculateFee(int hrsStayed) {
		return RATE*hrsStayed;
	}
}
