package main.model;

import java.awt.Point;

import main.core.Cell;

public class Bishop extends Piece {
    public Bishop(Point pos, String color) {
        super(pos, color, "bishop");
    }

    @Override
    public boolean isValidMove(Point p, Cell[][] board) {

        if (board[p.x][p.y].getPiece().isPresent()) {
            if (board[p.x][p.y].getPiece().get().color.equals(this.color)) {
                return false;
            }
        }
        
        int dx = Math.abs(p.x - pos.x);
        int dy = Math.abs(p.y - pos.y);

        if (dx != dy) return false;

        int stepX = Integer.compare(p.x, pos.x);
        int stepY = Integer.compare(p.y, pos.y);

        int x = pos.x + stepX;
        int y = pos.y + stepY;

        while (x != p.x) {
            if (board[x][y].getPiece().isPresent()) return false;
            x += stepX;
            y += stepY;
        }

        return true;
    }
}
