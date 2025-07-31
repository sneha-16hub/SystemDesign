package ObserverWeatherStation;

public interface Subject {
	void addObserver(observer obj);
	void removeObserver(observer obj);
	void updateAll();

}
