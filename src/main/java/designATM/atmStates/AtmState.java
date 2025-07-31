package designATM.atmStates;

import designATM.AtmClass;
import designATM.Card;

public abstract class AtmState {
	
	public void insertCard(AtmClass atm,Card card) {
    	System.out.println("Opps wrong  operation");
    }
	public void validatePin(AtmClass atm,Card card,int pin) {
		System.out.println("Opps wrong  operation");
	}
	public void selectTransaction(AtmClass atm,Card card, TransactionType type) {
		System.out.println("Opps wrong  operation");
	}
	public void withdrawCash(AtmClass atm,Card card,int amount) {
		System.out.println("Opps wrong  operation");
	}
	public void insertCash(AtmClass atm,Card card,int amount) {
		System.out.println("Opps wrong  operation");
	}
	public void returnCard() {
		System.out.println("Opps wrong  operation");
	}
	public void exit(AtmClass atm) {
		System.out.println("Opps wrong  operation");
	}
}
