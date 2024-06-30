package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
