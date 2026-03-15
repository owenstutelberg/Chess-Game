package main.model;

import java.awt.Point;

import main.core.Cell;

public class King extends Piece {
    public King(Point pos, String color) {
        super(pos, color, "king");
    }

    @Override
    public boolean isValidMove(Point p, Cell[][] board) {
        if (board[p.x][p.y].getPiece().isPresent()) {
            if (board[p.x][p.y].getPiece().get().color.equals(this.color)) {
                return false;
            }
        }
        if (p.equals(pos)) return false;
        
        int dx = Math.abs(p.x - pos.x);
        int dy = Math.abs(p.y - pos.y);

        return dx <= 1 && dy <= 1;
    }
}
