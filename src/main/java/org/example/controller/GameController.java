package org.example.controller;
import org.example.view.*;
import org.example.model.*;
import java.util.ArrayList;
import java.util.List;

public class GameController implements Controller{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer){}
    @Override
    public void detach(Observer observer){}
    @Override
    public void notifyObservers(){}
}
