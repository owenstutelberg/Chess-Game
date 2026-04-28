package main.model;

import java.awt.Point;

import main.core.Cell;

public class Pawn extends Piece {
    public Pawn(Point pos, String color) {
        super(pos, color, "pawn");
    }

    @Override
    protected boolean validateMoveSpecific(Point p, Cell[][] board) {
        // TODO: En Passant
        int dx = Math.abs(p.x - pos.x);
        int dy = (p.y - pos.y);

        // Make sure the pawn cannot go backwards
        if (dy > 0) return false;

        // Check for capturing
        if (dx > 0) {
            if (dx == 1) {
                if (board[p.x][p.y].getPiece().isEmpty()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        

        return true;
    }
}
