package DesignPatternExamples.ParkingLotNew.payments;

public class CreditCardPayment implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		System.out.println("Paid using Credit Card"+amount);
		
	}

}
