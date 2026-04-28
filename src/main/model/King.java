package main.model;

import java.awt.Point;

import main.core.Cell;

public class King extends Piece {
    private boolean hasMoved = false;
    public King(Point pos, String color) {
        super(pos, color, "king");
    }

    @Override
    public boolean validSelection(Point p, Cell[][] board) {
        // TODO: Castling
        
        int dx = Math.abs(p.x - pos.x);
        int dy = Math.abs(p.y - pos.y);

        return dx <= 1 && dy <= 1;
    }
}
