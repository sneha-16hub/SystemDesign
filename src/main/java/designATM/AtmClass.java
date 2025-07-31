package designATM;

import designATM.atmStates.AtmState;
import designATM.atmStates.IdleState;

public class AtmClass {
    Keyboard keyboard;
    Display display;
    Database database;
    CardReader cardReader;
    CashReceiver cashReceiver;
    CashDispenser cashDispenser;
    static AtmClass instance=null;
    AtmState atmstate;
    private AtmClass() {
    	keyboard=new Keyboard();
    	display=new Display();
    	database=new Database();
    	cardReader=new CardReader();
    	cashReceiver=new CashReceiver();
    	cashDispenser=new CashDispenser();  
    	atmstate=new IdleState();
    	
    }
    public static AtmClass getInstance() {
    	if(instance==null) {
    		synchronized(AtmClass.class){
    			if(instance==null) {
    				instance=new AtmClass();
    			}
    		}
    		
    	}
    	return instance;
    }
    public void updateATMDatabase(int totalAmount,int twoThousandCash,int fiveHundredCash,int hundredCash,int tenCash) {
    	database.insertCash(totalAmount, twoThousandCash, fiveHundredCash, hundredCash, tenCash);
    }
	public AtmState getAtmstate() {
		return atmstate;
	}
	public void setAtmstate(AtmState atmstate) {
		this.atmstate = atmstate;
	}
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return database;
	}
	
    
    
}
