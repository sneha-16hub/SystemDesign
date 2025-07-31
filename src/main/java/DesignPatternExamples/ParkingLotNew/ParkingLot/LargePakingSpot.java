package DesignPatternExamples.ParkingLotNew.ParkingLot;

import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;

public class LargePakingSpot extends ParkingSpot{


	public LargePakingSpot(int spotNumber) {
		super(spotNumber,"Car");
	}

	@Override
	public boolean canParkVehicle(Vehicle vehicle) {
		if(vehicle.getVehicleType().equalsIgnoreCase("Car")) {
			return true;
		}
		return false;
	}

}
