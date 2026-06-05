package org.miet.model;
public class Board { // Доска
    public static final int SIZE = 10;
    private Cell[][] cellMatrix; // Клетки в доске

    Board(){
        cellMatrix = new Cell[SIZE][SIZE]; // Пустые клетки
    }

    public void addShipPart(int x, int y, ShipPart part){ // Добавить детальку в клетку
        cellMatrix[x][y].addShipPart(part);
    }

    public Cell[][] getCellMatrix() { // Получить всю матрицу в тупую
        return cellMatrix;
    }

    public CellState getCellState(int x, int y) { // Получить состояние клетки
        return cellMatrix[x][y].getCellState();
    }
}
