package GameTest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game extends JPanel {
    private Player player;
    private Dimension d;
    private boolean inGame = true;
    private Timer timer;
    private Shot shot;
    private int direction = -1;
    private int score = 0;
    private String message;
    private String explImg = "C:\\Users\\alex\\IdeaProjects\\JocProject\\src\\images\\explosion.png";
    List<Alien> aliens;

    public Game() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(Constante.BOARD_WIDTH, Constante.BOARD_HEIGHT);
        setBackground(Color.black);
        timer = new Timer(Constante.DELAY, new GameCycle());
        timer.start();
        gameInit();
    }

    private void gameInit() {
        aliens = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {

                var alien = new Alien(Constante.ALIEN_INIT_X + 18 * j, Constante.ALIEN_INIT_Y + 18 * i);
                aliens.add(alien);
            }
        }
        player = new Player(this);
        shot = new Shot();
    }

    public void paintPlayer(Graphics g) {
        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }
    }

    private void paintShot(Graphics g) {
        System.out.println("S-a creat Shot");
        if (shot.isVisible()) {
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    public void paintAliens(Graphics g) {
        for (Alien alien : aliens) {

            if (alien.isVisible()) {

                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }

            if (alien.isDying()) {

                alien.die();
            }
        }
    }

    private void paintBomb(Graphics g) {

        for (Alien a : aliens) {

            Alien.Bomb b = a.getBomb();

            if (!b.isDestroyed()) {

                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Drawing(g);
    }


    private void Drawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (inGame) {

            g.drawLine(0, Constante.GROUND,
                    Constante.BOARD_WIDTH, Constante.GROUND);

            paintPlayer(g);
            paintShot(g);
            paintAliens(g);
            paintBomb(g);

        } else {

            if (timer.isRunning()) {
                timer.stop();
            }

            //to do gameOver();
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
        player.act();
        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            for (Alien alien : aliens) {

                int alienX = alien.getX();
                int alienY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (alienX) && shotX <= (alienX + Constante.ALIEN_WIDTH) && shotY >= (alienY) && shotY <= (alienY + Constante.ALIEN_HEIGHT)) {

                        var ii = new ImageIcon(explImg);
                        alien.setImage(ii.getImage());
                        alien.setDying(true);
                        score++;
                        shot.die();
                    }
                }
            }

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }

        for (Alien alien : aliens) {

            int x = alien.getX();

            if (x >= Constante.BOARD_WIDTH - Constante.BORDER_RIGHT && direction != -1) {

                direction = -1;

                Iterator<Alien> i1 = aliens.iterator();

                while (i1.hasNext()) {

                    Alien a2 = i1.next();
                    a2.setY(a2.getY() + Constante.GO_DOWN);
                }
            }

            if (x <= Constante.BORDER_LEFT && direction != 1) {

                direction = 1;

                Iterator<Alien> i2 = aliens.iterator();

                while (i2.hasNext()) {

                    Alien a = i2.next();
                    a.setY(a.getY() + Constante.GO_DOWN);
                }
            }
        }

        Iterator<Alien> it = aliens.iterator();

        while (it.hasNext()) {

            Alien alien = it.next();

            if (alien.isVisible()) {

                int y = alien.getY();

                if (y > Constante.GROUND - Constante.ALIEN_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
                }

                alien.act(direction);
            }
        }
        var generator = new Random();

        for (Alien alien : aliens) {

            int shot = generator.nextInt(15);
            Alien.Bomb bomb = alien.getBomb();

            if (shot == Constante.CHANCE && alien.isVisible() && bomb.isDestroyed()) {

                bomb.setDestroyed(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());
            }

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !bomb.isDestroyed()) {

                if (bombX >= (playerX) && bombX <= (playerX + Constante.PLAYER_WIDTH) && bombY >= (playerY) && bombY <= (playerY + Constante.PLAYER_HEIGHT)) {
                    var ii = new ImageIcon(explImg);
                    player.setImage(ii.getImage());
                    player.setDying(true);
                    bomb.setDestroyed(true);
                }
            }

            if (!bomb.isDestroyed()) {

                bomb.setY(bomb.getY() + 1);

                if (bomb.getY() >= Constante.GROUND - Constante.BOMB_HEIGHT) {

                    bomb.setDestroyed(true);
                }
            }
        }
    }

    private void gameCycle() {
        update();
        repaint();
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameCycle();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_S) {

                if (inGame) {

                    if (!shot.isVisible()) {

                        shot = new Shot(x, y);
                    }
                }
            }
        }
    }
}
