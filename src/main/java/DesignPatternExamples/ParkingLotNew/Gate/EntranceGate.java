package DesignPatternExamples.ParkingLotNew.Gate;
import java.util.Scanner;
import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingLot;
import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingSpot;
import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;
import DesignPatternExamples.ParkingLotNew.vehicles.VehicleFactory;


public class EntranceGate {
	private ParkingLot parkingLot;

	public EntranceGate(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
	}
	public void processEntrance() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter liciencePlate: ");
		String licensePlate=scanner.next();
		System.out.println("Enter vehicle type: ");
		String vehicleType=scanner.next();
		
		Vehicle vehicle=VehicleFactory.createVehicle(vehicleType,licensePlate);
		if(vehicle==null) {
			System.out.println("invalid vehicle type");
			return;
		}
		//try to park vehicle
		ParkingSpot spot=parkingLot.parkVehicle(vehicle);
		if(spot!=null) {
			System.out.println("Vehicle parked");
		}else {
			System.out.println("spot not avaialble");
		}
	}
	

}
