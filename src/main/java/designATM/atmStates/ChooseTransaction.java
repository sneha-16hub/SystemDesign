package designATM.atmStates;

import designATM.AtmClass;
import designATM.Card;

public class ChooseTransaction extends AtmState {
	@Override
	public void selectTransaction(AtmClass atm,Card card, TransactionType type) {
		if(type.equals(TransactionType.WITHDRAWAMOUNT)) {
			atm.setAtmstate(new WithdrawCashState());
		}else if(type.equals(TransactionType.CHECKACCOUNTSTATEMENT)) {
			atm.setAtmstate(new CheckaccountStatementSate());
		}else if(type.equals(TransactionType.INSERTCASH)) {
			atm.setAtmstate(new InsertCashState());
		}else {
			atm.setAtmstate(new TransferState());
		}
	}
	@Override
	public void exit(AtmClass atm) {
		returnCard();
		atm.setAtmstate(new IdleState());
	}
	@Override
	public void returnCard() {
		
	}
	private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
	
}
