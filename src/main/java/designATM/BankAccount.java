package designATM;

public class BankAccount {
	int balance;
	int accountNumber;
	UserState userState;
	public int getBalance() {
		return balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public UserState getUserState() {
		return userState;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void updateBankBalance(int amount) {
		this.balance+=amount;
	}
	public void deductBankBalance(int amount) {
		this.balance-=amount;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setUserState(UserState userState) {
		this.userState = userState;
	}

}
