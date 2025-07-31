package carRentalSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Store {
    int storeId;
    Location location;
    InventoryManager inventoryManager;
    ReservationManager reservationManager;
    public Store(Location location) {
    	this.location=location;
    	this.storeId=1098;
    	reservationManager=new ReservationManager();
    }
    public List<Vehicle> getVehicle(){
    	return inventoryManager.getVehicles();
    }
    public void setVehicle(List<Vehicle> vehicles) {
    	this.inventoryManager= new InventoryManager(vehicles);
    }
    public void createReservation(User user,int capacity,VehicleType type,LocalDateTime startDateTime,LocalDateTime endDateTime) {
    	
    	reservationManager.createReservation(user,capacity,type,startDateTime,endDateTime,inventoryManager);
    }
    
    
}
