package DesignPatternExamples.ParkingLotNew.payments;

import java.util.Scanner;

public class PaymentService {
	private Scanner scanner;

	public PaymentService(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	public void processPyament(double fee) {
		choosePaymentMethod(fee);
	}
	public void choosePaymentMethod(double fee) {
		System.out.println("1.Credit Card");
		System.out.println("2. UPI");
		System.out.println("3. Cash");
		int choice=scanner.nextInt();
		Payment payment;
		switch (choice) {
			case 1:
				payment=new Payment(fee,new CreditCardPayment());
				break;
			case 2:
				payment=new Payment(fee,new UPIPayment());
				break;
			case 3:
				payment=new Payment(fee,new CashPayment());
				break;
			default:
				System.out.println("Invalid option: setting default cash payment method");
				payment=new Payment(fee,new CashPayment());
				break;
		}
		payment.processPayment();
	}
}
