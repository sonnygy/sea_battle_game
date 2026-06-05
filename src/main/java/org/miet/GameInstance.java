package org.miet;

public class GameInstance {
    private static GameInstance gameInstance;

    private GameState state;

    GameInstance(){
        state = GameState.start;
    }

    public static GameInstance getGameInstance() {
        if (gameInstance == null){
            gameInstance = new GameInstance();
        }
        return gameInstance;
    }

    public void changeState(GameState state){
        this.state = state;
    }

    public void play(){
        // Здесь идет вся игра (зависит от state)
    }
}
