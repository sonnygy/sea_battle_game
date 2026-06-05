package org.miet.UI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.miet.model.BoardProxy;

import java.io.IOException;

public class UIController {
    private Terminal terminal;
    private Screen screen;
    private TextGraphics textGraphics;
    private BoardProxy allyBoardProxy;
    private BoardProxy enemyBoardProxy;

    public UIController() throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setInitialTerminalSize(new TerminalSize(50, 50));
        terminal = factory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();          // включаем raw-режим (ввод без Enter)
        screen.setCursorPosition(null); // скрываем курсор

        screen.clear();
        textGraphics = screen.newTextGraphics();
        textGraphics.putString(50/2, 50/2, "Морской бой!");
        screen.refresh();
    }

    public void

    public void drawSetup() throws IOException {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.putString(10, 5, "Hello Lanterna!", SGR.BOLD);
        screen.refresh();
        terminal.readInput();
        screen.stopScreen();
    }

    // Блокирующее ожидание нажатия клавиши (возвращает KeyStroke)
    public KeyStroke waitForKey() {
        try {
            return screen.readInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Неблокирующий опрос (для циклов с таймером)
    public KeyStroke pollKey() {
        try {
            return screen.pollInput();
        } catch (IOException e) {
            return null;
        }
    }

    public void close() {
        try {
            screen.stopScreen();
        } catch (IOException e) { }
    }
}
