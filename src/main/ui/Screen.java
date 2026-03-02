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

    }

    public void draw(Graphics g) {
        board.draw(g);
    }

    public void handleMousePress(MouseEvent e) {

    }

    public void handleMouseRelease(MouseEvent e) {

    }
}
