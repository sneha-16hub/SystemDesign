package designATM.atmStates;

import designATM.AtmClass;
import designATM.Card;
import designATM.UserState;

public class WithdrawCashState extends AtmState{
   @Override
   public void withdrawCash(AtmClass atm,Card card,int amount) {
		if(atm.getDatabase().getTotalAmount()<amount) {
			System.out.println("Insuffient amount in the Atm");
			exit(atm);
		}else if(card.getBankAccount().getUserState()!= UserState.ACTIVE) {
			System.out.println("Your account is not active");
			exit(atm);
		}else if(card.getBankAccount().getBalance() <amount) {
			System.out.println("Insuffient amount in your bank account");
			exit(atm);
		}else {
			card.getBankAccount().deductBankBalance(amount);
			atm.getDatabase().setTotalAmount(atm.getDatabase().getTotalAmount()-amount);
			AmountWithdrawalProcessor processor=TwoThousandCashProcessor(FiveHundredCashProcessor(HundredCashProcessor(atm,amount)));
			exit(atm);
		}
		
	}
}
