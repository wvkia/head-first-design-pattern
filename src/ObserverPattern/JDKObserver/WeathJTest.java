package ObserverPattern.JDKObserver;

import ObserverPattern.WeatherData;

public class WeathJTest {
    public static void main(String[] args) {

        WeatherDataJ weatherDataJ = new WeatherDataJ();
        CurrentConditionDisplayJ displayJ = new CurrentConditionDisplayJ(weatherDataJ);
        weatherDataJ.setMeasurements(1.2f,43.4f);
    }
}
