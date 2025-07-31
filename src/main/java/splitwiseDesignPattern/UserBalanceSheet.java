package splitwiseDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
     Map<User,BalanceSheet> userVsBalance;
     double amountYouGetBack;
     double amountOwe;
     double totalExpense;
     double totalPayment;
     public UserBalanceSheet(){
    	 userVsBalance=new HashMap<>();
    	 amountOwe=0;
    	 amountYouGetBack=0;
    	 totalExpense=0;
     }
	public Map<User, BalanceSheet> getUserVsBalance() {
		return userVsBalance;
	}
	public double getAmountYouGetBack() {
		return amountYouGetBack;
	}
	public double getAmountOwe() {
		return amountOwe;
	}
	public double getTotalExpense() {
		return totalExpense;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setUserVsBalance(Map<User, BalanceSheet> userVsBalance) {
		this.userVsBalance = userVsBalance;
	}
	public void setAmountYouGetBack(double amountYouGetBack) {
		this.amountYouGetBack = amountYouGetBack;
	}
	public void setAmountOwe(double amountOwe) {
		this.amountOwe = amountOwe;
	}
	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}
	public void setTotalPayment(double d) {
		this.totalPayment = d;
	}
     
}
