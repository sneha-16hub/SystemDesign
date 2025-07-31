package designATM.atmStates;

import designATM.AtmClass;
import designATM.Card;

public class IdleState extends AtmState{
    @Override
    public void insertCard(AtmClass atm,Card card) {
    	atm.setAtmstate(new HasCardState());
    }
    
}
