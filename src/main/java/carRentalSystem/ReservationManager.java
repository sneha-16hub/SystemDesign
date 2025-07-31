package carRentalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
	List<Reservation> reservations=new ArrayList<>();

	public void createReservation(User user, int capacity,VehicleType type,
			LocalDateTime startDateTime,LocalDateTime endDateTime,InventoryManager inventoryManager) {
		Vehicle vehicle=availableVehicle(inventoryManager.getVehicles(),capacity,type,startDateTime,endDateTime);
		if(vehicle!=null) {
			Reservation reservation=new Reservation();
			makeBasePayment(new Bill(vehicle));
			
			reservation.createReservation(vehicle, user, startDateTime, endDateTime);
			reservations.add(reservation);
			
		}
		
		
	}
	public void completeReservation(Reservation reservation){
		makePayment(new Bill(reservation))
		
	}
	public Vehicle availableVehicle(List<Vehicle> vehicles,int capacity,VehicleType type,
			LocalDateTime startDateTime,LocalDateTime endDateTime) {
		for(Vehicle vehicle:vehicles) {
			if(vehicle.getCapacity()==capacity && vehicle.getType()==type 
					&& isAvailableInDuration(vehicle,startDateTime,endDateTime)) {
				return vehicle;
			}
		}
		return null;
	}
	private boolean isAvailableInDuration(Vehicle vehicle, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		for(Reservation res:reservations) {
			if(res.getVehicle().getId()==vehicle.getId() 
					&& timesOverlap(startDateTime, endDateTime, res.getFromDateTime(), res.getToDateTime())) {
				return true;
			}
		}
		
		return false;
	}
	private boolean timesOverlap(LocalDateTime start1, LocalDateTime end1,
	            LocalDateTime start2, LocalDateTime end2) {
	return !(end1.isBefore(start2) || start1.isAfter(end2));
	}

}
