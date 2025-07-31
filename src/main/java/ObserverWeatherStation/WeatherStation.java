package ObserverWeatherStation;

import java.util.*;

public class WeatherStation implements Subject{
    private List<observer> obj=new ArrayList<>();
    private float temp=45.9f;
    public void setTemp(float temp) {
    	this.temp=temp;
    	updateAll();
    }
	@Override
	public void addObserver(observer obj) {
		this.obj.add(obj);
		
	}

	@Override
	public void removeObserver(observer obj) {
		this.obj.remove(obj);
		
	}

	@Override
	public void updateAll() {
		for(observer o:this.obj) {
			o.notify(temp);
		}
		
	}

}
