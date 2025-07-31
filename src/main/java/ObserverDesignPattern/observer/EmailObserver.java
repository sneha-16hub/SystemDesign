package ObserverDesignPattern.observer;

import ObserverDesignPattern.observable.stockObservable;

public class EmailObserver implements NotificationAlertObserver{
	String emailId;
	stockObservable observable;
	
	public EmailObserver(String EmailID,stockObservable obj) {
		this.emailId=EmailID;
		this.observable=obj;
	}
	
	@Override
	public void update() {
		sendMail(emailId, "product is in stock");
	}
	
	private void sendMail(String emailId, String msg) {
		System.out.println("mail sent to"+ emailId);
	}
	

}
