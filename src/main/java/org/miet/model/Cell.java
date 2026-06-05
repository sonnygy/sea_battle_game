package org.miet.model;

public class Cell { // Клетка
    private CellState cellState; // Все для отрисовки

    private ShipPart occupier; // Деталька в клетке

    Cell(){
        cellState = CellState.empty;
    }

    public void addShipPart(ShipPart part){ // Добавляем детальку
        occupier = part;
        cellState = CellState.ship;
    }

    public void shoot(){ // Стреляем в клетку
        if (cellState == CellState.ship){ // Попали
            cellState = CellState.hit;
            occupier.setHit();
        }
        else if (cellState == CellState.empty){ // Не попали
            cellState = CellState.miss;
        }
        else {
            throw new RuntimeException("Cell already was shot"); // Уже стреляли братан, еще раз нельзя
        }
    }
}
