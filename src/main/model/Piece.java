package main.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import main.core.Cell;

public abstract class Piece {
    protected Point pos;
    protected String color;
    protected Image image;
    
    public Piece(Point pos, String color, String type) {
        this.pos = pos;
        this.color = color;

        String filePath = "C:\\Users\\owens\\Documents\\GitHub\\Chess-Game\\src\\resources\\pieces\\" + color + "-" + type + ".png";

        image = new ImageIcon(filePath).getImage();
    }

    public void setPosition(Point pos) {
        this.pos = pos;
    }

    public void draw(Graphics g) {
        g.drawImage(image, 70 * pos.x + 9, 70 * pos.y + 9, 50, 50, null);
    }

    public abstract boolean isValidMove(Point p, Cell[][] board);
}
