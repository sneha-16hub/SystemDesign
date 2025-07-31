package designATM.processtransaction;

import designATM.AtmClass;

public class AmountWithdrawalProcessor {
	AmountWithdrawalProcessor processor;
	public AmountWithdrawalProcessor(AmountWithdrawalProcessor processor) {
		this.processor=processor;
	}
	public void processWithdrawal(AtmClass atm,int amount) {
		if(processor!=null) {
			processor.processWithdrawal(atm,amount);
		}
		
	}

}
