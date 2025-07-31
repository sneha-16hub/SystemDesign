package DesignPatternExamples.ParkingLotNew.payments;

public class UPIPayment implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		System.out.println("Paid using UPI "+amount);
	}

}
