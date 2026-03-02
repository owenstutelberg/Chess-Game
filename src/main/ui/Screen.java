package main.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import main.core.Board;

public class Screen {
    private final Board board;
    public Screen() {
        board = new Board();
    }

    public void update() {
        board.update();
    }

    public void draw(Graphics g) {
        board.draw(g);
    }

    public void handleMousePress(MouseEvent e) {
        board.handleMousePress(e);
    }

    public void handleMouseRelease(MouseEvent e) {
        board.handleMouseRelease(e);
    }
}
