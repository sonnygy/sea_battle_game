package org.example.controller;
import org.example.view.*;
import org.example.model.*;
import java.util.ArrayList;
import java.util.List;

public class GameController implements Controller{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void init(){}

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void detach(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
