package designATM.processtransaction;

import designATM.AtmClass;

public class TwoThousandCashProcessor extends AmountWithdrawalProcessor{
	public TwoThousandCashProcessor(AmountWithdrawalProcessor processor) {
		super(processor);
	}
	public void processWithdrawal(AtmClass atm,int amount) {
		int required=amount/2000;
		int balance=amount%2000;
		if(atm.getDatabase().getTwoThousandCash()>=required) {
			int currentNo=atm.getDatabase().getTwoThousandCash()-required;
			atm.getDatabase().setTwoThousandCash(currentNo);
		}else {
			balance+=(required-atm.getDatabase().getTwoThousandCash())*2000;
			atm.getDatabase().setTwoThousandCash(0);
		}
		if(balance>0) {
			super.processWithdrawal(atm, balance);
		}
	}

}
