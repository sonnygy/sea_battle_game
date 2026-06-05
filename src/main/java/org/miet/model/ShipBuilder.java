package org.miet.model;

import java.util.ArrayList;

public class ShipBuilder { // Строитель кораблей
    private int size;
    private ArrayList<ShipPart> parts;

    ShipBuilder(int size){
        this.size = size;
    }

    public void addPart(ShipPart part){
        parts.add(part);
    }

    public Ship getShip() {
        return new Ship(size, parts);
    }
}
