package org.miet;

public class GameInstance { // Синглетон игры
    private static GameInstance gameInstance;

    private GameState state;

    private GameInstance(){ // Приватный конструктор не трогаем
        state = GameState.start;
    }

    public static GameInstance getGameInstance() { // Получаем игру отсюда
        if (gameInstance == null){
            gameInstance = new GameInstance();
        }
        return gameInstance;
    }

    public void changeState(GameState state){ // взависимости от хода игры меняем состояние через этот метод
        this.state = state;
    }

    public void play(){ // Вызываем чтоб начать
        // Здесь идет вся игра (зависит от state)
        switch (state){
            case start: // Здесь начинаем (Менюшка приветствие)

            case p1setup: // Здесь
            case p2setup: // расставляем

            case p1move: // Здесь
            case p2move: // ходим

            case p1win: // Здесь
            case p2win: // побеждаем
        }
    }
}
