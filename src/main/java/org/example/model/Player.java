package org.example.model;

public class Player {
    private final String name;
    private Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }
}
