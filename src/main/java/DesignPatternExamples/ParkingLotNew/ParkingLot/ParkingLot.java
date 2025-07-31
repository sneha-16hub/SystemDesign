package DesignPatternExamples.ParkingLotNew.ParkingLot;

import java.util.List;

import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;


public class ParkingLot {
	private List<ParkingFloor> floors;

	public ParkingLot(List<ParkingFloor> floors) {
		super();
		this.floors = floors;
	}
	public ParkingSpot findAvailableSpot(String vehicleType) {
		for(ParkingFloor floor: floors) {
			ParkingSpot spot=floor.findAvailableSpot(vehicleType);
			if(spot!=null) {
				return spot;
			}
		}
		return null;
	}
	public ParkingSpot parkVehicle(Vehicle vehicle) {
		ParkingSpot spot=findAvailableSpot(vehicle.getVehicleType());
		if(spot!=null) {
			spot.parkVehicle(vehicle);
			System.out.println("Vehicle parked successfully");
			return spot;
		}
		System.out.println("No spot available");
		return null;
	}
	public void vacateSpot(ParkingSpot spot,Vehicle vehicle) {
		if(spot!=null && spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
			spot.vacate();
			System.out.println("Vacated spot");
		}else {
			System.out.println("Invalid operation, give right spot and vehicle details");
		}
		
	}
	public ParkingSpot getSpotByNumber(int spotNumber) {
		for(ParkingFloor floor:floors) {
			for(ParkingSpot spot: floor.getParkingSpots()) {
				if(spot.getSpotNumber()==spotNumber) {
					return spot;
				}
			}
		}
		return null;
	}
	public List<ParkingFloor> getFloors() {
		return floors;
	}
	
	

}
