package main.graphics;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow(Renderer renderer) {
        setTitle("Chess Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(renderer);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
