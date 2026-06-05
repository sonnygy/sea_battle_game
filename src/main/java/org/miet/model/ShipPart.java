package org.miet.model;

public class ShipPart {
    private boolean hit;

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
