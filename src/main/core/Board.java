package main.core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Optional;

public class Board {
    private Cell[][] board;
    public Board() {
        board = new Cell[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Cell((x + y) % 2 == 0 ? new Color(231, 237, 235) : new Color(105, 164, 129), Optional.empty());
            }
        }

    }

    public void update() {

    }
    public void draw(Graphics g) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int xPos = x * 70;
                int yPos = y * 70;
                g.setColor(board[x][y].getColor());
                g.fillRect(xPos, yPos, 70, 70);
            }
        } 
        
    }

    public void flip() {

    }
}
