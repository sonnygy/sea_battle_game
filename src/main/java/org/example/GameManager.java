package org.example;

import org.example.model.Game;
import org.example.model.GameBuilder;

public class GameManager {
    private static GameManager instance;
    private Game currentGame;

    private GameManager() {
        GameBuilder game = new GameBuilder();
        this.currentGame = game.build();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
