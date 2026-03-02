package main.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Optional;

import main.model.Bishop;
import main.model.King;
import main.model.Knight;
import main.model.Pawn;
import main.model.Piece;
import main.model.Queen;
import main.model.Rook;

public class Board {
    private Cell[][] board;

    private Cell selection;
    private Cell placement;

    public Board() {
        board = new Cell[8][8];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Optional<Piece> piece = Optional.empty();
                if (y == 0) {
                    if (x == 0 || x == 7) {
                        piece = Optional.of(new Rook(new Point(x, y), "black"));
                    } else if (x == 1 || x == 6) {
                        piece = Optional.of(new Knight(new Point(x, y), "black"));
                    } else if (x == 2 || x == 5) {
                        piece = Optional.of(new Bishop(new Point(x, y), "black"));
                    } else if (x == 3) {
                        piece = Optional.of(new Queen(new Point(x, y), "black"));
                    } else if (x == 4) {
                        piece = Optional.of(new King(new Point(x, y), "black"));
                    }
                } else if (y == 1) {
                    piece = Optional.of(new Pawn(new Point(x, y), "black"));
                } else if (y == 6) {
                    piece = Optional.of(new Pawn(new Point(x, y), "white"));
                } else if (y == 7) {
                    if (x == 0 || x == 7) {
                        piece = Optional.of(new Rook(new Point(x, y), "white"));
                    } else if (x == 1 || x == 6) {
                        piece = Optional.of(new Knight(new Point(x, y), "white"));
                    } else if (x == 2 || x == 5) {
                        piece = Optional.of(new Bishop(new Point(x, y), "white"));
                    } else if (x == 3) {
                        piece = Optional.of(new Queen(new Point(x, y), "white"));
                    } else if (x == 4) {
                        piece = Optional.of(new King(new Point(x, y), "white"));
                    }
                }
                board[x][y] = new Cell((x + y) % 2 == 0 ? new Color(231, 237, 235) : new Color(105, 164, 129), piece);
            }
        }

    }

    public void update() {

    }

    public void draw(Graphics g) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int xPos = x * 70;
                int yPos = y * 70;
                g.setColor(board[x][y].getColor());
                g.fillRect(xPos, yPos, 70, 70);
                if (board[x][y].getPiece().isPresent()) {
                    board[x][y].getPiece().get().draw(g);
                }
            }
        }

    }

    public void flip() {
        Cell[][] copy = new Cell[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Cell original = board[7 - x][7 - y];
                copy[x][y] = original;
                if (original.getPiece().isPresent()) {
                    original.getPiece().get().setPosition(new Point(x, y));
                }
            }
        }
        board = copy;
    }

    public void handleMousePress(MouseEvent e) {
        int x = e.getX() / 70;
        int y = e.getY() / 70;

        // remember the cell the player clicked on
        selection = board[x][y];
    }

    public void handleMouseRelease(MouseEvent e) {

        int x = e.getX() / 70;
        int y = e.getY() / 70;

        if (x > 7 || y > 7 || x < 0 || y < 0) return;

        // target cell where the mouse was released
        Cell dest = board[x][y];

        if (selection != null && selection.getPiece().isPresent()) {
            // move the piece from the selected cell to the destination
            Piece moving = selection.getPiece().get();
            dest.addPiece(moving);
            moving.setPosition(new Point(x, y));
            selection.clear();
        }

        // reset selection reference
        selection = null;

        flip();
    }
}
