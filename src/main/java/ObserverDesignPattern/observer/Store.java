package ObserverDesignPattern.observer;

import ObserverDesignPattern.observable.IphoneObservableimp;
import ObserverDesignPattern.observable.stockObservable;
public class Store {

	public static void main(String[] args) {
		stockObservable obj=new IphoneObservableimp();
		
		NotificationAlertObserver obj1=new EmailObserver("xyz@gmail.com",obj);
		NotificationAlertObserver obj2=new MobileObserver("xyzname",obj);
		obj.add(obj2);
		obj.add(obj1);
		obj.setdata(10);
		

	}

}
