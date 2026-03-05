package main.model;

import java.awt.Point;

import main.core.Cell;

public class Pawn extends Piece {
    public Pawn(Point pos, String color) {
        super(pos, color, "pawn");
    }

    @Override
    public boolean isValidMove(Point p, Cell[][] board) {
        if (board[p.x][p.y].getPiece().isPresent()) {
            if (board[p.x][p.y].getPiece().get().color.equals(this.color)) {
                return false;
            }
        }
        return true;
    }
}
