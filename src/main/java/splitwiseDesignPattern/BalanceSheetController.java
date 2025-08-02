package splitwiseDesignPattern;

import java.util.List;

public class BalanceSheetController {

	public void updateBalanceSheet(User paidBy, List<Split> splits, double amount) {
		UserBalanceSheet paidUserBalanceSheet= paidBy.getBalanceSheet();
		paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment()+amount);
		for(Split split: splits) {
			UserBalanceSheet userBalanceSheet= split.getUser().getBalanceSheet();
			User currUser=split.getUser();
			double oweAmount=split.getAmount();
			
			if(paidBy.getUserId()==currUser.getUserId()) {
				paidUserBalanceSheet.setTotalExpense(paidUserBalanceSheet.getTotalExpense()+oweAmount);
			}else {
				//update all parameters of paid user
				paidUserBalanceSheet.setAmountYouGetBack(paidUserBalanceSheet.getAmountYouGetBack()+oweAmount);
                BalanceSheet userOweBalance;
				if(paidUserBalanceSheet.getUserVsBalance().containsKey(currUser)) {
					userOweBalance= paidUserBalanceSheet.getUserVsBalance().get(currUser);
				}else {
					userOweBalance=new BalanceSheet();
				}
				userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount);
				
				//amount.update parameters of oweuser
				userBalanceSheet.setAmountOwe(userBalanceSheet.getAmountOwe()+oweAmount);
				userBalanceSheet.setTotalExpense(userBalanceSheet.getTotalExpense()+oweAmount);
				BalanceSheet updatebalancesheet;
				if(userBalanceSheet.getUserVsBalance().containsKey(paidBy)) {
					updatebalancesheet=userBalanceSheet.getUserVsBalance().get(paidBy);
				}else {
					updatebalancesheet=new BalanceSheet();
				}
				updatebalancesheet.setAmountOwe(updatebalancesheet.getAmountOwe()+oweAmount);
				
			}
		}
	}


}
