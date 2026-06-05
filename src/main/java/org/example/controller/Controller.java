package org.example.controller;

public interface Controller {
    void init();
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
