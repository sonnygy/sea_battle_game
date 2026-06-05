package org.example.view;
import org.example.model.*;

public class BoardProxy implements BoardComponent {
    @Override
    public void draw(Board board) {
        Cell[][] cells = board.getCells();

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int y = 0; y < 10; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < 10; x++) {

                switch (cells[y][x].getState()) {
                    case empty -> System.out.print("□ ");
                    case ship -> System.out.print("□ ");
                    case miss -> System.out.print("⊡ ");
                    case hit -> System.out.print("⊞ ");
                }
            }
            System.out.println();
        }
    };
}
