package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wk
 *
 */
public class WeatherData implements Subject {
	private List observers; //保持一个观察者的集合引用
	private float tempe;
	private float pressure;

	public WeatherData() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<>();
	}

	@Override
	public void registObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer ob = (Observer) observers.get(i);
			//调用观察者的更新方法，通知观察者
			ob.update(tempe, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float tempe, float pressure) {
		this.tempe = tempe;
		this.pressure = pressure;
		measurementsChanged();
	}
}
