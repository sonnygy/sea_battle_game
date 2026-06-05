package org.miet.model;
public class BoardBuilder { // Должен ОТВЕЧАТЬ за ПРАВИЛЬНОСТЬ установки деталек кораблей в клетки
    private Board board;

    BoardBuilder(){
        board = new Board();
    }

    private boolean checkNeighbours(int x, int y, Orientation orientation){ // Проверятель соседей
        boolean free = true;
        int[] dx = new int[0];
        int[] dy = new int[0];

        if (orientation == Orientation.vertical) {
            dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            dy = new int[]{-1, 0, 1, 0, 1, -1, 0, 1};
        }
        if (orientation == Orientation.horizontal){
            dx = new int[]{-1, -1, 0, 0, 0, 1, 1, 1};
            dy = new int[]{-1,  1,-1, 0, 1,-1, 0, 1};
        }

        for (int i = 0; i < dy.length; i++) {
            if ((x + dx[i] < 0) || (x + dx[i] >= Board.SIZE) || (y + dy[i] < 0) || (y + dy[i] >= Board.SIZE)){
                continue;
            }
            else {
                if (board.getCellState(x + dx[i], y + dy[i]) == CellState.ship){
                    free = false;
                    break;
                }
            }
        }

        return free;
    }

    // TODO: надо будет переместить логику создания кораблей и привязки к контейнеру в более уместное место, но пока так
    public void addShip(int x, int y, Orientation orientation, int size, ShipBuilder shipBuilder){
        try {
            if ((orientation == Orientation.vertical && y + size >= Board.SIZE) || (orientation == Orientation.horizontal && x + size >= Board.SIZE)){
                throw new RuntimeException("Ship does not fit in board bounds");
            }
            ShipPart partBuffer;
            for (int i = 0; i < size; i++) {
                if (orientation == Orientation.vertical){
                    if (checkNeighbours(x, y+i, orientation)){
                        throw new RuntimeException("Ship interferes with other ships");
                    }
                } else if (orientation == Orientation.horizontal) {
                    if (checkNeighbours(x+i, y, orientation)){
                        throw new RuntimeException("Ship interferes with other ships");
                    }
                }

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
