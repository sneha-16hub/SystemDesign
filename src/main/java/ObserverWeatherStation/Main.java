package ObserverWeatherStation;

public class Main {

	public static void main(String[] args) {
		WeatherStation ws=new WeatherStation();
		Phone p1=new Phone();
		Phone p2=new Phone();
		ws.addObserver(p1);
		ws.addObserver(p2);
		ws.setTemp(65.00f);

	}

}
