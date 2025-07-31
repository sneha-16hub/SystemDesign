package ObserverDesignPattern.observable;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.observer.NotificationAlertObserver;

public class IphoneObservableimp implements stockObservable{
	public List<NotificationAlertObserver> objList=new ArrayList<>();
	public int stockCount=0;
	
	@Override
	public void add(NotificationAlertObserver obj) {
		objList.add(obj);
	}
	@Override
	public void delete(NotificationAlertObserver obj) {
		objList.remove(obj);
	}
	@Override
	public void notifySubs() {
		for(NotificationAlertObserver obj: objList) {
			obj.update();
		}
	}
	public void setdata(int stockdata) {
		if(stockCount==0) {
			notifySubs();
		}
		stockCount+=stockdata;
	}
	public int getData() {
		return stockCount;
	}

}
