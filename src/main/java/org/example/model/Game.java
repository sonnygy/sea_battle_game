package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private boolean isOver;

    public boolean isOver() {
        return isOver;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Game() {

    }
    
}
