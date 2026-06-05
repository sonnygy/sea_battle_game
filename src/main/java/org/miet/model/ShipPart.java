package org.miet.model;

// TODO:
// --- Понять как связать состояние деталек и корабля (мб Observer)

public class ShipPart { // Деталька размещается в клетке
    private boolean hit; // Попали ли в детальку

    ShipPart(){
        hit = false;
    }

    public void setHit(){ // Бум
        hit = true;
    }

    public boolean getHit(){
        return hit;
    } // Попали все таки???
}
