package ObserverPattern;

/**
 * currentCondition观察者 实现observer观察者接口
 * 
 * @author wk
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float tempe;
	private float pressure;
	// 保留一个主题的引用
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherData;
		// 将自己注册进去
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
