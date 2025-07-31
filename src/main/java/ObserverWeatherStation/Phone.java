package ObserverWeatherStation;

public class Phone implements observer{

	@Override
	public void notify(float temp) {
		System.out.println("phone temperature displayed");
		
	}

}
