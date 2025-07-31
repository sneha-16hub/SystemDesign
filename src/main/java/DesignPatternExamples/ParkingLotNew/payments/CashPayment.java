package DesignPatternExamples.ParkingLotNew.payments;

public class CashPayment implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		System.out.println("cash amutn Paid"+amount);
		
	}

}
