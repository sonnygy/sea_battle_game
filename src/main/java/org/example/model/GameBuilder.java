package org.example.model;

public class GameBuilder {
    private Game game;
    public void addPlayer() {
        Player player = new Player();
    }
    public Game build() {
        return game;
    }
}
