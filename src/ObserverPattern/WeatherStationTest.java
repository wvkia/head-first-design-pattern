package ObserverPattern;

public class WeatherStationTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentCondition = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(1, 1);
		weatherData.setMeasurements(2, 2);
		weatherData.setMeasurements(3, 3);

	}
}
