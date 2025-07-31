package DesignPatternExamples.parkingLot;

import java.util.List;

public class parkingLot {
	List<ParkingFloor> parkingFloors;
	List<Entrance> entrances;
	List<Exit> exits;
	
	Address address;
	String name;
	
	public boolean isParkingSpaceAvailable(Vehicle vehicle);
	public boolean updateParkingAttendant(ParkingAttendant parkingAttendent, int gateId);

}
