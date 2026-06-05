package org.miet.model;

import java.util.ArrayList;

// TODO: Переместить логику привязки кораблей к контейнеру (когда нибудь)
public class ShipBuilder { // Строитель кораблей
    private int size;
    private Ship ship;
    private ArrayList<ShipPart> parts;
    private ShipContainer container;

    ShipBuilder(int size, ShipContainer container){
        this.size = size;
        this.container = container; // тут тоже делаем грязь
    }

    public void addPart(ShipPart part){
        parts.add(part);
    }

    // Вот здесь делаем грязь
    public Ship getShip() {
        ship = new Ship(size, parts);
        container.addShip(ship);
        return ship;
    }
}
