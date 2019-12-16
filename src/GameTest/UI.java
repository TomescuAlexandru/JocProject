package GameTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JButton jButton = new JButton("Start");
    private JButton jButton2 = new JButton("Exit");
    private JFrame frameJoc = new JFrame();
    private JFrame frameMenu = new JFrame();

    public UI() {
        jButton.setBounds(130, 130, 70, 30);
        jButton2.setBounds(130, 160, 70, 30);
        event click = new event();
        jButton.addActionListener(click);
        jButton2.addActionListener(click);
        frameMenu.setTitle("Menu");
        frameMenu.setSize(Constante.BOARD_WIDTH, Constante.BOARD_HEIGHT);
        frameMenu.add(jButton);
        frameMenu.add(jButton2);
        frameMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameMenu.setResizable(false);
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setLayout(null);
        frameMenu.setVisible(true);
    }

    public class event implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == jButton) {
                frameJoc.add(new Game());
                frameJoc.setSize(Constante.BOARD_WIDTH, Constante.BOARD_HEIGHT);

                frameJoc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frameJoc.setResizable(false);
                frameJoc.setLocationRelativeTo(null);
                frameMenu.setVisible(false);
                frameJoc.setVisible(true);
            } else if (actionEvent.getSource() == jButton2) {
                System.exit(0);
            }
        }
    }
}
