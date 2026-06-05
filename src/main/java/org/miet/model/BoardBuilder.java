package org.miet.model;
public class BoardBuilder { // Должен ОТВЕЧАТЬ за ПРАВИЛЬНОСТЬ установки деталек кораблей в клетки
    private Board board;

    BoardBuilder(){
        board = new Board();
    }

    // TODO: проверка на наличие деталек вокруг и на месте устанавливаемой детальки (много писать)
    // TODO: надо будет переместить логику создания кораблей и привязки к контейнеру в более уместное место, но пока так
    public void addShip(int x, int y, Orientation orientation, int size, ShipBuilder shipBuilder){
        try {
            if ((orientation == Orientation.vertical && y + size >= Board.SIZE) || (orientation == Orientation.horizontal && x + size >= Board.SIZE)){
                throw new RuntimeException("Ship does not fit in board bounds");
            }
            ShipPart partBuffer;
            for (int i = 0; i < size; i++) {
                partBuffer = new ShipPart();
                shipBuilder.addPart(partBuffer);
                if (orientation == Orientation.vertical){
                    board.addShipPart(x, (y+i), partBuffer);
                } else if (orientation == Orientation.horizontal) {
                    board.addShipPart((x+i), y, partBuffer);
                }
            }
            shipBuilder.getShip();
        }
        catch (RuntimeException e){
            throw e;
        }
    }

    public Board getBoard(){
        return board;
    }
}
