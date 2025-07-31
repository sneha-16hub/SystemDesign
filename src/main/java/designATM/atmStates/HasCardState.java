package designATM.atmStates;

import designATM.AtmClass;
import designATM.Card;

public class HasCardState extends AtmState{
    @Override
    public void validatePin(AtmClass atm,Card card,int pin) {
		if(card.isCorrectpin(card, pin)==true) {
			atm.setAtmstate(new ChooseTransaction());
		}
	}
    @Override
    public void exit(AtmClass atm) {
    	returnCard();
    	atm.setAtmstate(new IdleState());
    	
    }
    @Override
    public void returnCard() {
		System.out.println("Card Returned");
	}
}
