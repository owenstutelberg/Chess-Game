package main.model;

import java.awt.Point;

import main.core.Cell;

public class Rook extends Piece {
    public Rook(Point pos, String color) {
        super(pos, color, "rook");
    }

    @Override
    public boolean isValidMove(Point p, Cell[][] board) {
        if (board[p.x][p.y].getPiece().isPresent()) {
            if (board[p.x][p.y].getPiece().get().color.equals(this.color)) {
                return false;
            }
        }
        if (p.equals(pos)) return false;

        if (p.x != pos.x && p.y != pos.y) return false;

        if (p.x == pos.x) {
            int direction = Integer.compare(p.y, pos.y);

            for (int y = pos.y + direction; y != p.y; y += direction) {
                if (board[pos.x][y].getPiece().isPresent()) return false;
            }


        } else {
            int direction = Integer.compare(p.x, pos.x);

            for (int x = pos.x + direction; x != p.x; x += direction) {
                if (board[x][pos.y].getPiece().isPresent()) return false;
            }
        }

        return true;
    }
}
