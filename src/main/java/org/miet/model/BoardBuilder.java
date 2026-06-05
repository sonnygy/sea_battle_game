package org.miet.model;
// TODO: ---Все запрогать---
public class BoardBuilder { // Должен ОТВЕЧАТЬ за ПРАВИЛЬНОСТЬ установки деталек кораблей в клетки
    private Board board;

    BoardBuilder(){
        board = new Board();
    }

    // TODO: проверка на наличие деталек вокруг и на месте устанавливаемой детальки (много писать)
    // Создать корабль и добавить его на доску по кусочкам
    public void addShip(int x, int y, Orientation orientation, int size){
        try {
            if ((orientation == Orientation.vertical && y + size >= Board.SIZE) || (orientation == Orientation.horizontal && x + size >= Board.SIZE)){
                throw new RuntimeException("Ship does not fit in board bounds");
            }
            ShipPart partBuffer;
            ShipBuilder shipBuilder = new ShipBuilder(size);;
            for (int i = 0; i < size; i++) {
                partBuffer = new ShipPart();
                shipBuilder.addPart(partBuffer);
                if (orientation == Orientation.vertical){
                    board.addShipPart(x, (y+i), partBuffer);
                } else if (orientation == Orientation.horizontal) {
                    board.addShipPart((x+i), y, partBuffer);
                }
            }
        }
        catch (RuntimeException e){
            throw e;
        }
    }

    public Board getBoard(){
        return board;
    }
}
