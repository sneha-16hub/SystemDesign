package DesignPatternExamples.ParkingLotNew.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
	private List<ParkingSpot> spots;
	private int floorNumber;
	public ParkingFloor(int floorNumber,int numofCarSpots,int numofBikeSpots) {
		this.floorNumber=floorNumber;
		spots=new ArrayList<>();
		for(int i=0;i<numofCarSpots;i++) {
			this.spots.add(new LargePakingSpot(i+1));
		}
		for(int i=0;i<numofBikeSpots;i++) {
			this.spots.add(new MiniParkingSpot(i+1));
		}
	}
	public ParkingSpot findAvailableSpot(String vehicleType) {
		for(ParkingSpot spot:spots) {
			if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)) {
				return spot;
			}
		}
		return null;
	}
	public List<ParkingSpot> getParkingSpots(){
		return spots;
	}
	

}
