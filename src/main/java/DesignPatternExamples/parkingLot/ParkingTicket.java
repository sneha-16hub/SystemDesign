package DesignPatternExamples.parkingLot;

import java.util.Date;

import DesignPatternExamples.parkingLot.Enum.ParkingSpaceType;
import DesignPatternExamples.parkingLot.Enum.ParkingTicketStatus;

public class ParkingTicket {
	int ticketId;
	int levelId;
	int spaceID;
	Date vehicleEntryDateTime;
	Date vehicleExitDateTime;
	ParkingSpaceType parkingSPaceType;
	double totalCost;
	ParkingTicketStatus parkingticketstatus;
	
	public void updateTotalCost();
	public void updateVehicleExitTime(Date vehicleExitDateTime);
	

}
