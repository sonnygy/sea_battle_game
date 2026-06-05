package org.example.model;

import java.util.List;

public class Ship {
    private final int size;
    private int health;
    private shipStatus status;
    private List<Coordinate> coordinates;

    public Ship(int size, List<Coordinate> coordinates) {
        this.size = size;
        this.health = size;
        this.coordinates = coordinates;
        this.status = shipStatus.full;
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
