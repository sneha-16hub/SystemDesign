package designATM;

public class User {
	BankAccount account;
	Card card;
	public BankAccount getAccount() {
		return account;
	}
	public Card getCard() {
		return card;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	public void setCard(Card card) {
		this.card = card;
	}
    
}
