package org.miet.model;
public class BoardProxy { // Используем для доступа к доске (ограничиваем когда надо)
    private Board board;
    private BoardMode mode;

    BoardProxy(Board board){
        this.board = board;
    }

    public CellState getCellState(int x, int y) { // Надстройка для получения состояния клетки
        CellState cellState = board.getCellState(x, y); // Получаем состояние
        switch (mode) {
            case BoardMode.ally: // Доверяем доске
                break;
            case BoardMode.enemy: // Не доверяем
                if (cellState == CellState.ship){
                    cellState = CellState.empty; // Скрываем корабли
                }
                break;
        }
        return cellState;
    }

    public void changeState(){ // Меняем состояние при смене хода
        if (mode == BoardMode.ally){
            mode = BoardMode.enemy;
        } else if (mode == BoardMode.enemy) {
            mode = BoardMode.ally;
        }
    }

}
