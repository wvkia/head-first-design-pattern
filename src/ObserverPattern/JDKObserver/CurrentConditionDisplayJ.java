package ObserverPattern.JDKObserver;

import ObserverPattern.DisplayElement;
import ObserverPattern.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayJ implements Observer , DisplayElement {
    Observable observable;
    private float tempe;
    private float pressure;

    public CurrentConditionDisplayJ(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + tempe + " degrees and pressure :" + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJ) {
            WeatherDataJ weatherDataJ = (WeatherDataJ) o;
            this.tempe = weatherDataJ.getTempe();
            this.pressure = weatherDataJ.getPressure();
            display();
        }
    }
}
