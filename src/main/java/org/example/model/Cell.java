package org.example.model;

public class Cell {
    private CellState state;

    public Cell() {
        state = CellState.empty;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
