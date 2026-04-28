package main.model;

import java.awt.Point;

import main.core.Cell;

public class Pawn extends Piece {
    public Pawn(Point pos, String color) {
        super(pos, color, "pawn");
    }

    @Override
    public boolean validSelection(Point p, Cell[][] board) {
        // TODO: En Passant
        int dx = Math.abs(p.x - pos.x);
        int dy = (p.y - pos.y);

        if (dx == 0) {
            if (dy > 0) return false;
            if (pos.y == 6) {
                if (dy < -2) return false;
            } else if (dy < -1) return false;
        } else {
            if (dy != -1) return false;
            if (board[p.x][p.y].getPiece().isEmpty()) return false;
        }
        return true;
    }
}
