package DesignPatternExamples.parkingLot;

public class ParkingAttendant extends Account{
	Payment paymentService;
	public boolean prossVehicleEntry(Vehicle vehicle);
	public PaymentInfo processPayment(ParkingTicket parkingTicket,PaymentType paymentType);

}
