package DesignPatternExamples.ParkingLotNew.ParkingLot;

import java.time.LocalDateTime;

import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;

public class Ticket {
	private ParkingSpot parkingSpot;
	private Vehicle vehicle;
	private LocalDateTime startDateTime;
	
	public Ticket(ParkingSpot parkingSpot,Vehicle vehicle) {
		this.parkingSpot=parkingSpot;
		this.vehicle=vehicle;
		this.startDateTime=LocalDateTime.now();
	}

}
