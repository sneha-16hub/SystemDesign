package ObserverDesignPattern.observer;

import ObserverDesignPattern.observable.stockObservable;

public class MobileObserver implements NotificationAlertObserver{
	String userName;
	stockObservable observable;
	
	public MobileObserver(String EmailID,stockObservable obj) {
		this.userName=EmailID;
		this.observable=obj;
	}
	
	@Override
	public void update() {
		sendMsg(userName, "product is in stock");
	}
	
	private void sendMsg(String userName, String msg) {
		System.out.println("msg sent to"+ userName);
	}

}
