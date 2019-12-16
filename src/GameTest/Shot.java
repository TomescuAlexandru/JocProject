package GameTest;

import javax.swing.*;
/**
 * Clasa Shot reprezinta gloantele trase de Player
 * Clasa Shot extinde SuperClasa Sprite ce contine metodele de initializarea imaginii , setarea coordonatelor ale imaginii, metodele ce vor returna vizibilitatea obiectului
 */
public class Shot extends Sprite {
    /**
     * Constructorul fara parametrii ce v-a crea o instanta a clasei fara parametrii
     */
    public Shot() {
    }
    /**
     * Constructorul de initializare cu parametrii care v-a seta impuscatura pe o anumita pozitie in functie de acei parametrii
     */
    public Shot(int x, int y) {
        initShot(x, y);
    }
    /**
     * Metoda initShot(x,y) v-a initializa imaginea impuscaturii si v-a seta imaginea ei dupa coordonatele x,y
     */
    private void initShot(int x, int y) {

        var shotImg = "C:\\Users\\alex\\IdeaProjects\\JocProject\\src\\images\\shot.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}
