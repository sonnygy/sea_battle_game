package org.miet.model;

import java.util.ArrayList;

public class Ship { // Корабль
    private final int size; // Размер (4 или 3 или 2 или 1)
    private boolean alive; // Жив ли? (Использовать для проверки победы)

    private ArrayList<ShipPart> parts; // Храним здесь детальки

    Ship(int size, ArrayList<ShipPart> parts){
        this.size = size;
        if (parts.size() != size){
            throw new RuntimeException("Array size of parts does not equal size"); // Брат ты куда преш
        }
        this.parts = parts;

        alive = true;
    }
    // В идеале вызывается каждый ход чтобы понимать жив ли корабль, потом надо понять как закрасить клетки если мертв
    public void checkAlive(){
        int hitPoints = 0;
        for(ShipPart part : parts){
            if(part.getHit()){
                hitPoints++;
            }
        }
        if(hitPoints == size){
            alive = false;
        }
    }

}
