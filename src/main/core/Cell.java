package main.core;

import java.awt.Color;
import java.util.Optional;

import main.model.Piece;

public class Cell {
    private Color color;
    private Optional<Piece> piece;
    public Cell(Color color, Optional<Piece> piece) {
        this.color = color;
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }


}
