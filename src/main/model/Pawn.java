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
        if (p.equals(pos)) return false;

        int dx = Math.abs(p.x - pos.y);
        int dy = Math.abs(p.y - pos.y);

        if (!(p.y < pos.y && dy <= 1 && p.x == pos.x)) {
            return false;
        }

        

        return true;
    }
}
