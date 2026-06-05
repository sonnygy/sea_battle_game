package org.example.model;

public class Ship {
    protected static int size;
    protected int health;
    protected shipStatus status;

    public Ship(int size) {
        this.size = size;
        this.status = shipStatus.fulled;
    }

    public void setStatus(shipStatus status) {
        this.status = status;
    };

    public shipStatus getStatus() {
        return this.status;
    }

    public void hit() {
        health--;
        if (health == 0) {
            setStatus(shipStatus.destroyed);
        }
        setStatus(shipStatus.damaged);
    };
}
