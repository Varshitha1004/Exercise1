import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        System.out.println("Weather Station: New temperature is " + temperature + "°C");
        this.temperature = temperature;
        notifyObservers();
    }
}

class DisplayUnit implements Observer {
    private String location;

    public DisplayUnit(String location) {
        this.location = location;
    }

    @Override
    public void update(float temperature) {
        System.out.println(location + " display unit: Temperature updated to " + temperature + "°C");
    }
}

// Main class to use WeatherStation
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        DisplayUnit lobbyDisplay = new DisplayUnit("Lobby");
        DisplayUnit officeDisplay = new DisplayUnit("Office");

        station.registerObserver(lobbyDisplay);
        station.registerObserver(officeDisplay);

        station.setTemperature(23);
        station.removeObserver(officeDisplay);
        station.setTemperature(25);
    }
}
