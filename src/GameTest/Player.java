package GameTest;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 *Clasa Player reprezinta player-ul cu care ne vom juca .
 * Clasa Player extinde SuperClasa Sprite ce contine metodele de initializarea imaginii , setarea coordonatelor ale imaginii, metodele ce vor returna vizibilitatea obiectului
 */

public class Player extends Sprite {
    /**
     * Acesta variabila v-a fi initializata cu latimea imaginii player-ului
     */
    private int width;

    /**
     * Constructorul v-a apela metoda initPlayer care v-a incarca imaginea si v-a crea player-ul cu o anumita pozitie data
     */
    Player() {
        initPlayer();
    }

    /**
     * Metoda apelata in constructor ce initiazileaza imaginea , si seteaza player-ul pe o pozitie in functie de x,y
     */
    public void initPlayer() {

        var playerImg = "C:\\Users\\alex\\IdeaProjects\\JocProject\\src\\images\\player.png";
        var ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());

        int START_X = 270;
        setX(START_X);

        int START_Y = 280;
        setY(START_Y);

    }

    /**
     * Metoda act() v-a face update la pozitia jucatorului in functie de pozitia unde se afla in Frame
     */
    public void act() {

        x += dx;

        if (x <= 2) {

            x = 2;
        }

        if (x >= Constante.BOARD_WIDTH - 2 * width) {

            x = Constante.BOARD_WIDTH - 2 * width;
        }
    }

    /**
     * Am suprascris metoda keyPressed pentru a crea o definitie atunci cand sunt apasate tastele : Sageata Stanga si Sageata Dreapta pentru a misca player-ul
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 2;
        }
    }

    /**
     * Am suprascris metoda keyReleased pentru ca jucatorul sa se opreasca din miscare atunci cand nu se mai apasa vreo tasta
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }
}
