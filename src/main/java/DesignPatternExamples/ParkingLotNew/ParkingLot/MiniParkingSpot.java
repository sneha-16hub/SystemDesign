package DesignPatternExamples.ParkingLotNew.ParkingLot;

import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;

public class MiniParkingSpot extends ParkingSpot{

	public MiniParkingSpot(int spotNumber) {
		super(spotNumber,"Bike");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canParkVehicle(Vehicle vehicle) {
		if(vehicle.getVehicleType().equalsIgnoreCase("Bike")) {
			return true;
		}
		return false;
	}

}
