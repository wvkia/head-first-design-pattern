package ObserverPattern;

/**
 * currentCondition
 * 具体观察者实现
 * @author wk
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float tempe;
	private float pressure;
	//观察者保持一份主题的引用，用来注册和删除自己
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherData;
		weatherData.registObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions : " + tempe + " degrees and pressure :" + pressure);
	}

	@Override
	public void update(float tempe, float pressure) {
		// TODO Auto-generated method stub
		this.tempe = tempe;
		this.pressure = pressure;
		display();
	}

}
