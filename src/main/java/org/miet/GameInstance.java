package org.miet;

import org.miet.UI.UIController;
import org.miet.model.Board;
import org.miet.model.BoardBuilder;
import org.miet.model.BoardProxy;
import org.miet.model.ShipContainer;

import java.io.IOException;

public class GameInstance { // Синглетон игры
    private static GameInstance gameInstance;

    private GameState state;

    private Board board1;
    private Board board2;

    private BoardProxy boardProxy1;
    private BoardProxy boardProxy2;

    private ShipContainer shipContainer1;
    private ShipContainer shipContainer2;

    private UIController ui;

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

    public BoardProxy getBoardProxy1(){
        return new BoardProxy(board1);
    }

    public BoardProxy getBoardProxy2(){
        return new BoardProxy(board2);
    }

    public void play() { // Вызываем чтоб начать
        // Здесь идет вся игра (зависит от state)
        while (true) {
            switch (state) {
                case start:
                    init();
                    break;
                case p1setup:
                    setup();
                    break;
            }
        }
    }

    private void init(){
        shipContainer1 = new ShipContainer();
        shipContainer2 = new ShipContainer();
        try {
            ui = new UIController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        changeState(GameState.p1setup);
    }

    private void setup(){
        if (state == GameState.p1setup){
            BoardBuilder boardBuilder = new BoardBuilder();
            try {
                ui.drawSetup();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true){

            }
        }
    }

}
