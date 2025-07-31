package splitwiseDesignPattern;

import java.util.List;

public class BalanceSheetController {

	public void updateBalanceSheet(User paidBy, List<Split> splits, double amount) {
		UserBalanceSheet paidUserBalanceSheet= paidBy.getBalanceSheet();
		paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment()+amount);
		for(Split split: splits) {
			UserBalanceSheet userBalanceSheet= split.getUser().getBalanceSheet();
			userBalanceSheet.set
		}
	}


}
