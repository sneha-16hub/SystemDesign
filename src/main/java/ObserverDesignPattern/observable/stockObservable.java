package ObserverDesignPattern.observable;

import ObserverDesignPattern.observer.NotificationAlertObserver;

public interface stockObservable {
	public void add(NotificationAlertObserver obj);
	public void delete(NotificationAlertObserver obj);
	public void setdata(int stockdata);
	public int getData() ;
	public void notifySubs();

}
