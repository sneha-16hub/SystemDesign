package designATM;

import java.time.LocalDateTime;

public class Card {
	BankAccount bankAccount;
	int pin;
	LocalDateTime expiry;
	int cvv;
	public boolean isCorrectpin(Card card,int pin) {
		if(card.getPin()==pin) {
			return true;
		}
		return false;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

	private int getPin() {
		return pin;
	}
	
	

}
