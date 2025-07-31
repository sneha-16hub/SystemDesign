package DesignPatternExamples.ParkingLotNew.Gate;

import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingLot;
import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingSpot;
import DesignPatternExamples.ParkingLotNew.payments.PaymentService;
import DesignPatternExamples.ParkingLotNew.vehicles.Vehicle;

public class ExitGate {
	private ParkingLot parkingLot;
	private PaymentService paymentService;
	public ExitGate(ParkingLot parkingLot, PaymentService paymentService) {
		super();
		this.parkingLot = parkingLot;
		this.paymentService = paymentService;
	}
	
	public void processExit(int spotNumber,int hoursStayed) {
		ParkingSpot spot=parkingLot.getSpotByNumber(spotNumber);
		if(spot==null || !spot.isOccupied()) {
			System.out.println("ENter valid details of spot");
			return;
		}
		Vehicle vehicle=spot.getVehicle();
		if(vehicle==null) {
			return;
		}
		double fee=vehicle.calculateFee(hoursStayed);
		paymentService.processPyament(fee);
		parkingLot.vacateSpot(spot,vehicle);
		System.out.println("spot vacated successfully");
	}
}
