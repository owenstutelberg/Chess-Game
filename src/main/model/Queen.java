package main.model;

import java.awt.Point;

import main.core.Cell;

public class Queen extends Piece {
    public Queen(Point pos, String color) {
        super(pos, color, "queen");
    }

    @Override
    public boolean isValidMove(Point p, Cell[][] board) {

        if (p.equals(pos)) return false;

        int dx = Math.abs(p.x - pos.x);
        int dy = Math.abs(p.y - pos.y);

        if (board[p.x][p.y].getPiece().isPresent()) {
            if (board[p.x][p.y].getPiece().get().color.equals(this.color)) {
                return false;
            }
        }

        if (dx == dy) {
            int stepX = Integer.compare(dx, 0);
            int stepY = Integer.compare(dy, 0);

            int x = pos.x + stepX;
            int y = pos.y + stepY;

            while (x != p.x && y != p.y) {
                if (board[x][y].getPiece().isPresent()) {
                    return false;
                }

                x += stepX;
                y += stepY;
            }

            return true;
        }

        if (p.x == pos.x || p.y == pos.y) {
            int stepX = Integer.compare(dx, 0);
            int stepY = Integer.compare(dy, 0);

            int x = pos.x + stepX;
            int y = pos.y + stepY;

            while (x != p.x || y != p.y) {
                if (board[x][y].getPiece().isPresent()) {
                    return false;
                }
                x += stepX;
                y += stepY;
            }
            return true;
        }

        return false;
    }
}
