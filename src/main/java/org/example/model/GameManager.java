package org.example.model;

public class GameManager {
    private static GameManager instance;
    private Game currentGame;

    private void start() {
        GameBuilder game = new GameBuilder();
        currentGame = game.build();
    }

    private GameManager() {
        start();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
