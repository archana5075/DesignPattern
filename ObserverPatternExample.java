package com.apex.designpattern.behavioralpattern;

/**
 * 
 * 
 
 In this program:

We have a Subject interface defining methods to register, remove, and notify observers.
WeatherStation is a concrete subject class that maintains the temperature and manages a list of observers. 
It implements the Subject interface.
The WeatherDisplay class implements the Observer interface and represents an observer that displays the temperature.
In the Main class, we create a WeatherStation subject and WeatherDisplay observers.
 We register the observers with the subject, set the temperature on the subject, and observe the updates being notified to the observers. 
 We also demonstrate removing an observer and updating the temperature again. This shows how the observer pattern allows objects to subscribe 
and unsubscribe to changes in another object's state, and be notified when that state changes.
 * 
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject class
class WeatherStation implements Subject {
    private int temperature;
    private List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void update(int temperature);
}

// Concrete Observer class
class WeatherDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature updated: " + temperature);
    }
}

// Client code
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a subject (weather station)
        WeatherStation weatherStation = new WeatherStation();

        // Create observers (weather displays)
        Observer display1 = new WeatherDisplay();
        Observer display2 = new WeatherDisplay();

        // Register observers with the subject
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Set temperature on the subject
        weatherStation.setTemperature(25);

        // Remove one observer
        weatherStation.removeObserver(display2);

        // Set temperature again
        weatherStation.setTemperature(30);
    }
}


