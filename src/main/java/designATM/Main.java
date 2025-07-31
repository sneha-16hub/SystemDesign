package designATM;

public class Main {

	public static void main(String[] args) {
		AtmController atmController=new AtmController();
		User user=new User();
		Card card=new Card();
		card.setPin(8907);
		BankAccount bankAccount=new BankAccount();
		bankAccount.setBalance(56000);
		AtmClass atm=AtmClass.getInstance();
		atm.updateATMDatabase(80000,7,6,4,5);
		atmController.startAtm(user);
	}

}
