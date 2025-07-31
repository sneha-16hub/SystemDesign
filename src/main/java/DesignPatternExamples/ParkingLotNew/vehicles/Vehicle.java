package DesignPatternExamples.ParkingLotNew.vehicles;

public abstract class Vehicle {
	private String liciencePlate;
	private String vehicleType;
	public Vehicle(String liciencePlate, String vehicleType) {
		super();
		this.liciencePlate = liciencePlate;
		this.vehicleType = vehicleType;
	}
	
	public String getLiciencePlate() {
		return liciencePlate;
	}


	public String getVehicleType() {
		return vehicleType;
	}
	public abstract double calculateFee(int hoursstayed);
	
	

}
