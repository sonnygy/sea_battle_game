package org.miet.model;

import java.util.ArrayList;

public class ShipContainer {
    private ArrayList<Ship> ships;

    public ShipContainer(){
        ships = new ArrayList<>();
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    // Каждый ход проверяем, если да то выбрасываем в победу
    public boolean allDead(){
        boolean flag = true;
        for(Ship ship: ships){
            if (ship.isAlive()) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
