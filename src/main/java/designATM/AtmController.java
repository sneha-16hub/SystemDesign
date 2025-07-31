package designATM;

import designATM.atmStates.TransactionType;

public class AtmController {
	private AtmClass atm=AtmClass.getInstance();
	public void startAtm(User user) {
		Card card=user.getCard();
		atm.getAtmstate().insertCard(atm,card);
		atm.getAtmstate().validatePin(atm, card, 9087);
		atm.getAtmstate().selectTransaction(atm, card, TransactionType.WITHDRAWAMOUNT);
		
	}
}
