package DesignPatternExamples.ParkingLotNew.vehicles;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType,String liciencePlate) {
    	if(vehicleType.equalsIgnoreCase("Car")) {
    		return new LargeVehicle(liciencePlate);
    	}else if(vehicleType.equalsIgnoreCase("Bike")) {
    		return new MiniVehicles(liciencePlate); 	
    	}else {
    		return null;
    	}
    		
    }
}
