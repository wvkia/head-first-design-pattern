package ObserverPattern.JDKObserver;


import ObserverPattern.Observer;

import java.util.Observable;

public class WeatherDataJ extends Observable {
    private float tempe;
    private float pressure;

    public WeatherDataJ() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float tempe, float pressure) {
        this.tempe = tempe;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTempe() {
        return tempe;
    }

    public float getPressure() {
        return pressure;
    }
}
