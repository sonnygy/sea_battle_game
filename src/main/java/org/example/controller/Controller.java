package org.example.controller;

public interface Controller {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
