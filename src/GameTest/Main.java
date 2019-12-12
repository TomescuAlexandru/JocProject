package GameTest;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        initUI();
    }

    private void initUI() {

        add(new Game());

        setTitle("Game");
        setSize(Constante.BOARD_WIDTH, Constante.BOARD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var frame = new Main();
            frame.setVisible(true);
        });
    }
}

