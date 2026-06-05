package org.example.controller;
import org.example.view.BoardView;
import org.example.model.Board;

public class BoardController {
    private BoardView boardView;
    private Board board;

    public BoardController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
    }

    public void initBoard() {
        boardView.initMenu();
        for (int i = 0; i < 4 ; i++) {

        }
        for (int i = 0; i < 3 ; i++) {

        }
        for (int i = 0; i < 2 ; i++) {

        }
        boardView.draw(board);
    }
}
