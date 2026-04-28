package main.model;

import java.awt.Point;

import main.core.Cell;

public class Knight extends Piece {
    public Knight(Point pos, String color) {
        super(pos, color, "knight");
    }

    @Override
    public boolean validSelection(Point p, Cell[][] board) {        
        int dx = Math.abs(p.x - pos.x);
        int dy = Math.abs(p.y - pos.y);

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
