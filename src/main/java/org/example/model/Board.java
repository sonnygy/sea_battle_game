package org.example.model;

public class Board {
    private final int SIZE = 10;
    private Cell [][] cells = new Cell [SIZE][SIZE];
    private Ship [] ships = new Ship[SIZE];

    public Cell[][] getCells() {
        return cells;
    }
    public Ship[] getShips() {
        return ships;
    }
}
