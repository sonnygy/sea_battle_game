package org.example.controller;
import org.example.view.*;
import org.example.model.*;
import java.util.ArrayList;
import java.util.List;

public class BoardController implements Controller{
    private final List<Observer> observers = new ArrayList<>();
    private BoardView boardView;
    private Board board;

    public BoardController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
    }

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
